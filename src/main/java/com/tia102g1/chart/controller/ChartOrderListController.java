package com.tia102g1.chart.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tia102g1.chart.model.ChartOrderListRepository;
import com.tia102g1.chart.model.ChartService;

@Controller
@RequestMapping("/report")
public class ChartOrderListController {
	
//	@Autowired
//	private ChartDataService dataSvc;
	
	@Autowired
	private ChartService chartSvc;
	
	@Autowired
	private ChartOrderListRepository repo;
	
	@GetMapping("generateChart")
	public String generateChart(Model model) {
		List<Object[]> orderList = repo.findOrderSummary();
		
		String outputFilePath = "upload/salesChart.png";
		
		try {
			chartSvc.generateChart(orderList, outputFilePath);
			model.addAttribute("chartPath", outputFilePath);
		} catch (Exception e) {
			e.printStackTrace();
	        model.addAttribute("errorMessage", "報表生成失敗：" + e.getMessage());  // 錯誤信息顯示在頁面
System.out.println(e);
		}
		
		return "/report/mainPageReport";
	}
	
	@GetMapping("upload/{filename}")
	public ResponseEntity<Resource> getImage(@PathVariable String filename) {
	    // 指向圖片在伺服器上的存儲位置
	    Path filePath = Paths.get("upload/" + filename);
	    Resource resource = new FileSystemResource(filePath.toFile());

	    if (!resource.exists()) {
	        return ResponseEntity.notFound().build();
	    }

	    // 返回圖片給前端
	    return ResponseEntity.ok()
	        .contentType(MediaType.IMAGE_PNG)
	        .body(resource);
	}

}
