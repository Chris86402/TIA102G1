package com.tia102g1.chart.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aspose.cells.Chart;
import com.aspose.cells.ChartType;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

@Service
public class ChartService {

    public void generateChart(List<Object[]> orderList, String outputFilePath) throws Exception {
        // 創建一個新的工作簿
        Workbook workbook = new Workbook();
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.getCells().get("A1").putValue("訂單日期");
        sheet.getCells().get("B1").putValue("處理中金額");
        sheet.getCells().get("C1").putValue("已付款金額");
        sheet.getCells().get("D1").putValue("退款金額");
        
        int row = 1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // 處理原始數據並寫入工作表
        for (Object[] record : orderList) {
            Date date = (Date) record[0];
            BigDecimal group1Amount = (BigDecimal) record[1];
            BigDecimal group2Amount = (BigDecimal) record[2];
            BigDecimal group3Amount = (BigDecimal) record[3];
            
            sheet.getCells().get(row, 0).putValue(date.toLocalDate().format(formatter));
            sheet.getCells().get(row, 1).putValue(group1Amount.doubleValue());
            sheet.getCells().get(row, 2).putValue(group2Amount.doubleValue());
            sheet.getCells().get(row, 3).putValue(group3Amount.doubleValue());
            row++;
        }
        
        // 創建長條圖
        int chartIndex = sheet.getCharts().add(ChartType.COLUMN, 5, 0, 20, 10);
        Chart chart = sheet.getCharts().get(chartIndex);
        
        // 設置圖表數據系列
        chart.getNSeries().add("B2:B" + row, true); // 處理中金額
        chart.getNSeries().add("C2:C" + row, true); // 已付款金額
        chart.getNSeries().add("D2:D" + row, true); // 退款金額
        chart.getNSeries().setCategoryData("A2:A" + row); // 設置 X 軸為日期
        
        // 添加圖例
        chart.getNSeries().get(0).setName("處理中金額");
        chart.getNSeries().get(1).setName("已付款金額");
        chart.getNSeries().get(2).setName("退款金額");  
        
        chart.getLegend().setPosition(com.aspose.cells.LegendPositionType.BOTTOM);
        
        // 設置圖表標題和 X, Y 軸標題
        chart.getTitle().setText("訂單狀態金額統計");
        // 將工作簿輸出到流中
        workbook.save(outputFilePath);
    }
}
