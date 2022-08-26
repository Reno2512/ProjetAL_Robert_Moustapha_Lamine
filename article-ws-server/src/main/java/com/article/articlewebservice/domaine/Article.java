package com.article.articlewebservice.domaine;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="article")
@Data @ToString @NoArgsConstructor @AllArgsConstructor
@XmlRootElement
public class Article {
    @Id @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;
    private String titre;
    private String contenu;
    private int categorie;
    @Column(name="dateCreation")
    private Date dateCreation;
    private Date dateModification;
    

	public Article() {
	}
	
	
	public Article(int id, String titre, String contenu, int categorie, Date dateCreation, Date dateModification) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.categorie = categorie;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public int getCategorie() {
		return categorie;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
   
}