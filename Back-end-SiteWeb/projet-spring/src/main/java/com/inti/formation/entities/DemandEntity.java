package com.inti.formation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="demand_entity")
public class DemandEntity {
	
	private long demandId;
	private String title;
	private String description;
	private String category;
	private String postalCodeDemand;
	

	private UserEntity user;
	
	private int maxParticipation;
	private boolean isAccepted;
	private boolean valid;
	

	
	@Column
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}




	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public DemandEntity(long demandId, String title, String description, String category, String postalCodeDemand,
			UserEntity user, int maxParticipation, boolean isAccepted, boolean valid) {
		super();
		this.demandId = demandId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.postalCodeDemand = postalCodeDemand;
		this.user = user;
		this.maxParticipation = maxParticipation;
		this.isAccepted = isAccepted;
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "DemandEntity [demandId=" + demandId + ", title=" + title + ", description=" + description
				+ ", category=" + category + ", postalCodeDemand=" + postalCodeDemand + ", user=" + user
				+ ", maxParticipation=" + maxParticipation + ", isAccepted=" + isAccepted + ", valid=" + valid + "]";
	}

	@Column
	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	

	public DemandEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public long getDemandId() {
		return demandId;
	}

	public void setDemandId(long demandId) {
		this.demandId = demandId;
	}
	@Column
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column
	public String getPostalCodeDemand() {
		return postalCodeDemand;
	}

	public void setPostalCodeDemand(String postalCodeDemand) {
		this.postalCodeDemand = postalCodeDemand;
	}



	@Column
	public int getMaxParticipation() {
		return maxParticipation;
	}

	public void setMaxParticipation(int maxParticipation) {
		this.maxParticipation = maxParticipation;
	}
	
	

}
