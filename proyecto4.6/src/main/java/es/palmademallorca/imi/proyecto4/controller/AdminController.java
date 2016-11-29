package es.palmademallorca.imi.proyecto4.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.palmademallorca.imi.proyecto4.dto.AjaxResponseDto;
import es.palmademallorca.imi.proyecto4.dto.ArticleDto;
import es.palmademallorca.imi.proyecto4.service.ArticleService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired 
	private ArticleService articleService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
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
		return "admin/list";
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public String edit(
			Model model,
			@PathVariable("id") Long articleId){
		ArticleDto article = articleService.getArticle(articleId);
		return gotoEdit(model, article);
	}

	private String gotoEdit(Model model, ArticleDto article) {
		model.addAttribute("article", article);
		model.addAttribute("authors", articleService.findAllAuthors());
		return "admin/edit";
	}
	
	@RequestMapping(value = "", method=RequestMethod.POST)
	public String save(
			Model model,
			@Valid @ModelAttribute("article") ArticleDto article,
			BindingResult results){
		if (results.hasErrors()){
			return gotoEdit(model, article);
		} else {
			articleService.saveArticle(article);
			return "redirect:/admin/"+article.getId()+"?msg=ok";
		}
	}
	
	@RequestMapping(value = "/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("id")Long articleId){
		articleService.removeArticle(articleId);
		return "redirect:/admin";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/ajax", produces="application/json")
	public AjaxResponseDto ajax(){
		return new AjaxResponseDto(
				System.currentTimeMillis(), 
				"Primera petición Ajax");
	} 
}
