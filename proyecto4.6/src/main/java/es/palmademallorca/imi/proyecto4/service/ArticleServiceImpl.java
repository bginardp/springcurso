package es.palmademallorca.imi.proyecto4.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import es.palmademallorca.imi.proyecto4.dao.ArticleDao;
import es.palmademallorca.imi.proyecto4.dto.ArticleDto;
import es.palmademallorca.imi.proyecto4.model.Article;
import es.palmademallorca.imi.proyecto4.model.Author;
import es.palmademallorca.imi.proyecto4.model.Label;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	public Page<ArticleDto> getArticles(String term, Set<String> labels, Boolean visibles, Pageable pageRequest) {
		Page<Article> page = articleDao.findAllArticles(term, labels, visibles, pageRequest);
		List<ArticleDto> content = new ArrayList<>();
		for (Article art : page){
			content.add(new ArticleDto(art));
		}
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}

	public ArticleDto getArticle(Long articleId) {
		Article article = articleDao.findOneArticle(articleId);
		return new ArticleDto(article);
	}

	public void removeArticle(Long articleId) {
		articleDao.deleteArticle(articleId);
	}


	@PreAuthorize("hasRole('ADMIN')")
	public void saveArticle(ArticleDto articleDto) {
		Author author = articleDao.findOneAuthor(articleDto.getAuthorId());
		String[] label = articleDto.getLabels().split(",");
		Set<Label> labels = getOrCreateLabels(label);
		Article result = new Article(articleDto, labels, author);
		articleDao.saveArticle(result);
	}

	@Override
	public List<Label> findAllLabels() {
		return articleDao.findAllLabels();
	}

	@Override
	public List<Author> findAllAuthors() {
		return articleDao.findAllAuthors();
	}

	@Override
	public Set<Label> getOrCreateLabels(String[] labels) {
		Set<Label> result = new HashSet<>();
		if (labels!=null){
			for(String label : labels){
				label = label.trim();
				Label lbl = articleDao.findOneLabel(label);
				if (lbl == null){
					lbl = new Label(label);
					articleDao.saveLabel(lbl);
				}
				result.add(lbl);
			}
		}
		return result;
	}

}
