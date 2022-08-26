package com.article.articlewebservice.web;

import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.article.articlewebservice.domaine.Article;
import com.article.articlewebservice.repository.ArticleRepository;
@Component
@Path("/articles")
public class ArticleJAXRS {
    @Autowired
    private ArticleRepository articleRepository;
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}
    // C
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Article addArticle( Article article){
        article.setDateCreation(new Date());
        article.setDateModification(new Date());
        return articleRepository.save(article);
    }
    // R one
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

	public Article getArticle(@PathParam("id") int id){
		return articleRepository.findById(id).orElse(null);
	}

	// R many
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

	public List<Article> getManyArticle(@QueryParam("order") boolean order){
        // ,@QueryParam("categorie") int categorie
		// if(order)
        return articleRepository.findAll(Sort.by(Sort.Direction.ASC,"categorie"));

    }
    //U 
	@PUT
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})

    public Article updateArticle(@RequestBody Article article,@PathParam("id")int id) {
        article.setId(id);
        article.setDateModification(new Date());
        return articleRepository.save(article);

	}
	// D
    @Path("/{id}")
    @DELETE
	public void deleteArticletById(@PathParam("id") int id) {
		articleRepository.deleteById(id);
	}
	
}