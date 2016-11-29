package es.palmademallorca.imi.proyecto4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.palmademallorca.imi.proyecto4.dto.AjaxResponseDto;
import es.palmademallorca.imi.proyecto4.dto.ArticleDto;
import es.palmademallorca.imi.proyecto4.dto.ItemDto;
import es.palmademallorca.imi.proyecto4.service.ArticleService;

@RestController
//@Controller + Mime respuesta: application/json
public class AjaxController {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/ajax/request")
	public AjaxResponseDto ajax(){
		return new AjaxResponseDto(
				System.currentTimeMillis(), 
				"Primera petición Ajax");
	}
	
	@RequestMapping("/ajax/search")
	public List<ItemDto> search(@RequestParam("term")String term){
		Page<ArticleDto> articles = 
				articleService
					.getArticles(term, null, true, new PageRequest(0, 5));
		
		List<ItemDto> result = new ArrayList<>();
		for (ArticleDto dto : articles){
			result.add(new ItemDto(
					dto.getTitle(), //label
					dto.getId().toString())); //value
		}
		
		return result;
//		
//		// Java 8
//		Page<ItemDto> pageResult = 
//				articles.map(
//						dto -> new ItemDto(
//								dto.getTitle(), 
//								dto.getId().toString()));
//		
//		//Java 7
//		pageResult = 
//				articles.map(
//					new Converter<ArticleDto,ItemDto>(){
//						public ItemDto convert(ArticleDto source){
//							return new ItemDto(
//									source.getTitle(), 
//									source.getId().toString());
//						}
//					});
//						
		
	}
	
	@RequestMapping("/ajax/search2")
	public Page<ArticleDto> search2(@RequestParam("term")String term){
		Page<ArticleDto> articles = 
				articleService
					.getArticles(term, null, true, new PageRequest(0, 5));
		
		return articles;
	}
}
