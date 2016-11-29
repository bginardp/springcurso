package es.palmademallorca.imi.proyecto4.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.querydsl.jpa.impl.JPAQuery;

import es.palmademallorca.imi.proyecto4.jpa.ArticleRepository;
import es.palmademallorca.imi.proyecto4.jpa.AuthorRepository;
import es.palmademallorca.imi.proyecto4.jpa.LabelRepository;
import es.palmademallorca.imi.proyecto4.model.Article;
import es.palmademallorca.imi.proyecto4.model.Author;
import es.palmademallorca.imi.proyecto4.model.Label;
import es.palmademallorca.imi.proyecto4.model.QArticle;

@Component
public class ArticleDao {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private LabelRepository labelRepository;

	@Autowired
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		Label label = new Label("pesca");
		Set<Label> labels = new HashSet<>();
		labels.add(label);
		labelRepository.save(label);

		Author author = new Author("Ramón", "Arnau", "Palma de Mallorca");
		authorRepository.save(author);
		authorRepository.save(new Author("José", "Arrecio", "Palma de Mallorca"));

		articleRepository.save(createArticle(labels, author, 1));
		articleRepository.save(createArticle(labels, author, 2));
		articleRepository.save(createArticle(labels, author, 3));
		
		Label newLabel = new Label("caza");
		labels.add(newLabel);
		labelRepository.save(newLabel);
		
		articleRepository.save(createArticle(labels, author, 4));
	}

	private Article createArticle(Set<Label> labels, Author author, int numArticle) {
		return new Article(true, "Artículo " + numArticle + " <script>alert('hacked!');</script>", new Date(),
				new Date(), author,
				"Descripción corta del artículo " + numArticle + " <b>bold</b> si se ve ne negrita mal",
				"Cuerpo del artículo " + numArticle + ", si e ve en <b>negrita</b> bien", labels);
	}

	public Page<Article> findAllArticles(String term, Set<String> labels, Boolean visibles, Pageable pageRequest) {
		// 1ª opción -> nombre de método complejo en el repositorio -> no
		// 2ª opción -> HQL -> consulta dentro de un string, no se compila!
		// List<Article> arts = entityManager.createQuery("from Articles where
		// ....");
		// 3ª opción -> QueryDSL -> permite que el compilador nos ayude a
		// escribir HQL.
		QArticle article = QArticle.article;

//		labels = new HashSet<>();
//		labels.add("caza");
		
		// creación de consulta
		JPAQuery<Article> query = new JPAQuery<>(entityManager);
		query.from(article);
		if (visibles != null) {
			query.where(article.visible.eq(visibles));
		}
		if (term != null ) {
			query.where(article.title.likeIgnoreCase("%" + term + "%")
					.or(article.content.likeIgnoreCase("%" + term + "%")));
		}
		if (labels != null && labels.size()>0) {
			for (String label : labels){
				Label elabel = new Label(label);
						//como conocemos el id de label, podemos instanciarlo
						//manualmente antes de pasarlo en el where.
						//labelRepository.findOne(id);
				if (elabel != null){
					query.where(article.labels.contains(elabel));
				}
			}
		}
		query.orderBy(article.creationDate.desc());

		// gestión de paginado
		long offset = pageRequest.getPageSize() * pageRequest.getPageNumber();
		query.limit(pageRequest.getPageSize());
		query.offset(offset);

		// preparación de resultado
		List<Article> list = query.fetch();
		Long total = query.fetchCount();
		PageImpl<Article> result = new PageImpl<>(list, pageRequest, total);
		return result;
	}

	public Article findOneArticle(Long articleId) {
		return articleRepository.findOne(articleId);
	}

	public void deleteArticle(Long articleId) {
		articleRepository.delete(articleId);
	}

	public void saveArticle(Article article) {
		articleRepository.save(article);
	}

	public List<Label> findAllLabels(){
		Iterable<Label> labels = labelRepository.findAll(
				new Sort(new Order(Direction.ASC,"text")));
		return convertItToList(labels);
	}

	public List<Author> findAllAuthors() {
		Iterable<Author> authors = authorRepository.findAll(
				new Sort(new Order(Direction.ASC,"name")));
		return convertItToList(authors);
	}

	private <T> List<T> convertItToList(Iterable<T> labels) {
		List<T> result = new ArrayList<>();
		for (T label : labels){
			result.add(label);
		}
		return result;
	}

	public Label findOneLabel(String label) {
		return labelRepository.findOne(label);
	}
	

	public void saveLabel(Label lbl) {
		labelRepository.save(lbl);
	}

	public Author findOneAuthor(Long authorId) {
		return authorRepository.findOne(authorId);
	}
}
