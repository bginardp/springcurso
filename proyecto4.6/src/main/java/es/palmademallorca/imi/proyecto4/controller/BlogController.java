package es.palmademallorca.imi.proyecto4.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.palmademallorca.imi.proyecto4.dto.ArticleDto;
import es.palmademallorca.imi.proyecto4.service.ArticleService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired 
	private ArticleService articleService;
	
	@RequestMapping("")
	public String list(
			Model model,
			@PageableDefault(size=3) Pageable pageRequest,
			@RequestParam(value="term",required=false) String term,
			@RequestParam(value="labels",required=false) Set<String> labels){
		Page<ArticleDto> articles = articleService
				.getArticles(term, labels, true, pageRequest);
		model.addAttribute("articles", articles);
		model.addAttribute("term",term);
		model.addAttribute("userLabels",labels);
		model.addAttribute("labels",articleService.findAllLabels());
		return "blog/list";
	}
	
	@RequestMapping("/{id}")
	public String view(
			Model model,
			@PathVariable("id") Long articleId){
		ArticleDto article = articleService.getArticle(articleId);
		model.addAttribute("article", article);
		return "blog/view";
	}
}
