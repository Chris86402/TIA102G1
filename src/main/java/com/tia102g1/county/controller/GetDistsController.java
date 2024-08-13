package com.tia102g1.county.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tia102g1.county.model.CountyService;
import com.tia102g1.county.model.CountyVO;

@RestController
public class GetDistsController {

	@Autowired
	CountyService countySvc;
	
	//查詢鄉鎮區
    @GetMapping("/dists")
    public String getDists(@RequestParam Integer cntCode){
    	
    	CountyVO countyVO = countySvc.getOneCounty(cntCode);
    	
    	//建立Gson物件
    	Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); //排除沒貼的欄位
    					
    	//將Java物件轉換成JSON字串
    	String jsonStr = gson.toJson(countyVO);
    	System.out.println(jsonStr);

    	return jsonStr;
    }
}
