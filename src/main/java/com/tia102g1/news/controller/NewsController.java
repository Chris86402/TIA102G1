package com.tia102g1.news.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tia102g1.news.model.NewsService;
import com.tia102g1.news.model.NewsVO;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	Timestamp now = Timestamp.valueOf(LocalDateTime.now());
	
	@Autowired
	NewsService newsSvc;
	
	@GetMapping("addNews")
	public String addNews(ModelMap model) {
		NewsVO newsVO = new NewsVO();
		model.addAttribute("newsVO", newsVO);
		return "news/addNews";
	}
	
	@PostMapping("insert")
	public String insert(@Valid NewsVO newsVO, BindingResult result, ModelMap model, @RequestParam("newsDate") String newsDateStr, @RequestParam("startDt") String startDtStr,@RequestParam("endDt") String endDtStr,@RequestParam("newsPic") MultipartFile[] parts, HttpSession session) throws IOException{
		
		result = removeFieldError(newsVO, result, "newsDate");
		result = removeFieldError(newsVO, result, "startDtStr");
		result = removeFieldError(newsVO, result, "endDt");
		result = removeFieldError(newsVO, result, "newsPic");
		
		if(newsDateStr == null || newsDateStr.trim().length() == 0) {
			model.addAttribute("errorMessage1", "公告日期:請勿空白");
		} else if(newsDateStr.compareTo(endDtStr) > 0) {
			model.addAttribute("errorMessage1", "公告日期不得晚於公告結束日");
		} 
		
		if(startDtStr == null || startDtStr.trim().length() == 0) {
			model.addAttribute("errorMessage2", "公告起始日期:請勿空白");
		}else if(newsDateStr.compareTo(startDtStr) > 0) {
			model.addAttribute("errorMessage1", "公告日期不得晚於公告起始日");
		}
		
		if(endDtStr == null || endDtStr.trim().length() == 0) {
			model.addAttribute("errorMessage3", "公告結束日期:請勿空白");
		}else if(endDtStr.compareTo(startDtStr) < 0) {
			model.addAttribute("errorMessage3", "公告結束日期不得早於公告起始日");
		}
		
		byte[] buf = null;
		if(parts[0].isEmpty()) {
			model.addAttribute("errorMessage4", "公告圖片:請勿空白");
		}else {
			for(MultipartFile multipartFile : parts) {
				buf = multipartFile.getBytes();
			}
		}
		
		if(result.hasErrors() || parts[0].isEmpty() || model.containsAttribute("errorMessage1") || model.containsAttribute("errorMessage2") || model.containsAttribute("errorMessage3") || model.containsAttribute("errorMessage4")) {
			return "/news/addNews";
		}
		
		newsVO.setNewsPic(buf);
		newsVO.setDateCreated(now);
		newsVO.setLastUpdated(now);
		String createdBy = (String) session.getAttribute("staffId");

		newsVO.setCreatedBy(createdBy);
		newsVO.setLastUpdatedBy(createdBy);
		
		newsSvc.addNews(newsVO);
		
		List<NewsVO> list = newsSvc.getAll();
		model.addAttribute("newsListData", list);
		return "redirect:/news/listAllNews";
	}
	
	@PostMapping("getOne_For_Display")
	public String getOne_For_Display(@RequestParam("newsId") String newsIdStr, ModelMap model) {
		NewsVO newsVO = newsSvc.getOneNews(Integer.valueOf(newsIdStr));
		
		model.addAttribute("newsVO", newsVO);
		return "news/listOneNews";
	}
	
	@PostMapping("getOne_For_Update")
	public String getOne_For_Update(@RequestParam("newsId") String newsIdStr, ModelMap model) {
		NewsVO newsVO = newsSvc.getOneNews(Integer.valueOf(newsIdStr));
		
		model.addAttribute("newsVO", newsVO);
		return "news/updateNews";
	}
	
	@PostMapping("update")
	public String update(@Valid NewsVO newsVO, BindingResult result, ModelMap model, @RequestParam("newsDate") String newsDateStr, @RequestParam("startDt") String startDtStr,@RequestParam("endDt") String endDtStr,@RequestParam("newsPic") MultipartFile[] parts, HttpSession session) throws IOException{
		
		Date newsDate = null;
		Date startDt = null;
		Date endDt = null;
		
		result = removeFieldError(newsVO, result, "newsDate");
		result = removeFieldError(newsVO, result, "startDt");
		result = removeFieldError(newsVO, result, "endDt");
		result = removeFieldError(newsVO, result, "newsPic");

		if(newsDateStr != null && newsDateStr.trim().length() != 0) {
			try {
				newsDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(newsDateStr).getTime());
			}catch(ParseException e) {
				e.printStackTrace();
			}
		} else {
			model.addAttribute("errorMessage1", "公告日期:請勿空白");
		}	
		
		if (startDtStr != null && startDtStr.trim().length() != 0) {
			 try {
				 startDt = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(startDtStr).getTime());
			 } catch (ParseException e) {
		         e.printStackTrace();
		     }
		} else {
			model.addAttribute("errorMessage2", "公告起始日期:請勿空白");
		}
		
		
		if(endDtStr != null && endDtStr.trim().length() != 0) {
			try {
				endDt = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(endDtStr).getTime());
			}catch(ParseException e) {
				e.printStackTrace();
			}
		}else {
			model.addAttribute("errorMessage3", "公告結束日期:請勿空白");

		}

		if(newsDate !=null && newsDate.compareTo(endDt) > 0) {
			model.addAttribute("errorMessage1", "公告日期不得晚於公告結束日");
		}
		
		if(newsDate !=null && newsDate.compareTo(startDt) > 0) {
			model.addAttribute("errorMessage1", "公告日期不得晚於公告起始日");
		}
		
		if(endDt !=null && endDt.compareTo(startDt) < 0) {
			model.addAttribute("errorMessage3", "公告結束日期不得早於公告起始日");
		}
		
		if(parts[0].isEmpty()) {
			byte[] newsPic = newsSvc.getOneNews(newsVO.getNewsId()).getNewsPic();
			newsVO.setNewsPic(newsPic);
		} else {
			for(MultipartFile multipartFile : parts) {
				byte[] newsPic = multipartFile.getBytes();
				newsVO.setNewsPic(newsPic);
			}
		}
		
		
		if(result.hasErrors() || model.containsAttribute("errorMessage1") || model.containsAttribute("errorMessage2") || model.containsAttribute("errorMessage3") || model.containsAttribute("errorMessage4")) {
			return "/news/updateNews";
		}
		
		String lastUpdatedBy = (String) session.getAttribute("staffId");
		
		newsVO.setLastUpdatedBy(lastUpdatedBy);
		
		newsVO.setNewsDate(newsDate);
	    newsVO.setStartDt(startDt);
		newsVO.setEndDt(endDt);
		newsVO.setLastUpdated(now);
		
		newsSvc.updateNews(newsVO);
		
		newsVO = newsSvc.getOneNews(Integer.valueOf(newsVO.getNewsId()));
		model.addAttribute("newsVO", newsVO);
		return "news/listOneNews";
	}
	
	@PostMapping("listNews_ByCompositeQuery")
	public String listAllNews(HttpServletRequest req, Model model) {
		Map<String, String[]> map = req.getParameterMap();
		List<NewsVO> list = newsSvc.getAll(map);
		model.addAttribute("newsListData", list);
		return "news/listAllnews";
	}
	
	@GetMapping("DBGifReader")
	public void dBGifReader(@RequestParam("newsId") String newsId, HttpServletResponse res) throws IOException{
		
		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();
		
		out.write(newsSvc.getOneNews(Integer.valueOf(newsId)).getNewsPic());
	}
	
	
	
	public BindingResult removeFieldError(NewsVO newsVO, BindingResult result, String removedFieldname) {
		List<FieldError> errorsListToKeep = result.getFieldErrors().stream().filter(fieldname -> !fieldname.getField().equals(removedFieldname)).collect(Collectors.toList());
		result = new BeanPropertyBindingResult(newsVO, "newsVO");
		for(FieldError fieldError : errorsListToKeep) {
			result.addError(fieldError);
		}
		return result;
	}
}
