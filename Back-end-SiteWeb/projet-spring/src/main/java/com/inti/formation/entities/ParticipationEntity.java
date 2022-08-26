package com.inti.formation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="participation_entity")
public class ParticipationEntity {
	
	private long participationId;
	

	private UserEntity user;
	

	private DemandEntity demand;
	
	private boolean isAccepted;
	


	public ParticipationEntity() {
		super();
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getParticipationId() {
		return participationId;
	}

	public void setParticipationId(long participationId) {
		this.participationId = participationId;
	}
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	public UserEntity getUser() {
		return user;
	}



	public void setUser(UserEntity user) {
		this.user = user;
	}


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="demand_id")
	public DemandEntity getDemand() {
		return demand;
	}



	public void setDemand(DemandEntity demand) {
		this.demand = demand;
	}



	public ParticipationEntity(long participationId, UserEntity user, DemandEntity demand, boolean isAccepted) {
		super();
		this.participationId = participationId;
		this.user = user;
		this.demand = demand;
		this.isAccepted = isAccepted;
	}



	@Override
	public String toString() {
		return "ParticipationEntity [participationId=" + participationId + ", user=" + user + ", demand=" + demand
				+ ", isAccepted=" + isAccepted + "]";
	}



	@Column
	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	

}
