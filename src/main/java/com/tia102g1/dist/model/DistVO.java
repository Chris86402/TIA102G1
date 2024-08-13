package com.tia102g1.dist.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.google.gson.annotations.Expose;
import com.tia102g1.county.model.CountyVO;
import com.tia102g1.store.model.StoreVO;

@Entity
@Table(name = "DISTRICT")
public class DistVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "DISTCODE")
	@Expose
	private Integer distCode;
	
//	@Column(name = "CNTCODE")
//	private Integer cntCode;
	
	@ManyToOne
	@JoinColumn(name = "CNTCODE", referencedColumnName = "CNTCODE")
	@OrderBy("cntCode asc")
	private CountyVO countyVO;
	
	@Column(name = "DISTNAME")
	@NotEmpty(message = "鄉鎮區名稱: 請勿空白")
	@Expose
	private String distName;
	
	@Column(name = "CREATEDBY", updatable = false)
	private String createdBy;
	
	@Column(name = "DATECREATED", insertable = false, updatable = false)
	private Timestamp dateCreated;
	
	@Column(name = "LASTUPDATEDBY")
	private String lastUpdatedBy;
	
	@Column(name = "LASTUPDATED", insertable = false, updatable = false)
	private Timestamp lastUpdated;
	
	@OneToMany(mappedBy = "distVO", fetch=FetchType.EAGER)
	private Set<StoreVO> stores = new HashSet<StoreVO>();

	public DistVO() {
		super();
	}

	public DistVO(Integer distCode, CountyVO countyVO, @NotEmpty(message = "鄉鎮區名稱: 請勿空白") String distName,
			String createdBy, Timestamp dateCreated, String lastUpdatedBy, Timestamp lastUpdated, Set<StoreVO> stores) {
		super();
		this.distCode = distCode;
		this.countyVO = countyVO;
		this.distName = distName;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
		this.stores = stores;
	}

	public Integer getDistCode() {
		return distCode;
	}

	public void setDistCode(Integer distCode) {
		this.distCode = distCode;
	}

	public CountyVO getCountyVO() {
		return countyVO;
	}

	public void setCountyVO(CountyVO countyVO) {
		this.countyVO = countyVO;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
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
	
	
}
