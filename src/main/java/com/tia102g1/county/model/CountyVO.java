package com.tia102g1.county.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.google.gson.annotations.Expose;
import com.tia102g1.dist.model.DistVO;
import com.tia102g1.store.model.StoreVO;

@Entity
@Table(name = "COUNTY")
public class CountyVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CNTCODE")
	@Expose
	private Integer cntCode;
	
	@Column(name = "CNTNAME")
	@NotEmpty(message = "縣市名稱: 請勿空白")
	@Expose
	private String cntName;
	
	@Column(name = "CREATEDBY", updatable = false)
	private String createdBy;
	
	@Column(name = "DATECREATED", insertable = false, updatable = false)
	private Timestamp dateCreated;
	
	@Column(name = "LASTUPDATEDBY")
	private String lastUpdatedBy;
	
	@Column(name = "LASTUPDATED", insertable = false, updatable = false)
	private Timestamp lastUpdated;
	
	@OneToMany(mappedBy = "countyVO", fetch=FetchType.EAGER)
	private Set<StoreVO> stores = new HashSet<StoreVO>();
	
	@OneToMany(mappedBy = "countyVO", fetch=FetchType.EAGER)
	@OrderBy("distCode asc")
	@Expose
	private Set<DistVO> dists = new HashSet<DistVO>();

	public CountyVO() {
		super();
	}

	public CountyVO(Integer cntCode, @NotEmpty(message = "縣市名稱: 請勿空白") String cntName, String createdBy,
			Timestamp dateCreated, String lastUpdatedBy, Timestamp lastUpdated, Set<StoreVO> stores,
			Set<DistVO> dists) {
		super();
		this.cntCode = cntCode;
		this.cntName = cntName;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
		this.stores = stores;
		this.dists = dists;
	}

	public Integer getCntCode() {
		return cntCode;
	}

	public void setCntCode(Integer cntCode) {
		this.cntCode = cntCode;
	}

	public String getCntName() {
		return cntName;
	}

	public void setCntName(String cntName) {
		this.cntName = cntName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Set<StoreVO> getStores() {
		return stores;
	}

	public void setStores(Set<StoreVO> stores) {
		this.stores = stores;
	}

	public Set<DistVO> getDists() {
		return dists;
	}

	public void setDists(Set<DistVO> dists) {
		this.dists = dists;
	}

	@Override
	public String toString() {
		return "CountyVO [cntCode=" + cntCode + ", cntName=" + cntName + ", createdBy=" + createdBy + ", dateCreated="
				+ dateCreated + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdated=" + lastUpdated + ", stores="
				+ stores + ", dists=" + dists + "]";
	}
	
	
}
