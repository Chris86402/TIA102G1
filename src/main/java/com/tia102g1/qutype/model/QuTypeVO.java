package com.tia102g1.qutype.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.tia102g1.csform.model.CsFormVO;

@Entity
@Table(name = "QUTYPE")
public class QuTypeVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUTYPEID")
	public Integer quTypeId;
	
	@NotEmpty(message = "問題類型描述:請勿空白")
	@Pattern(regexp="^[\\u4e00-\\u9fa5\\u0041-\\u005a\\u0061-\\u007a\\u0030-\\u0039\\u0020-\\u002f\\u003a-\\u0040\\u005b-\\u0060\\u007b-\\u007e]{2,20}$", message = "問題類型描述: 只能是中、英文、數字及標點符號 , 且長度必需在2到20之間")
	public String quTypeDesc;
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@Column(name = "DATECREATED")
	private Timestamp dateCreated;
	
	@Column(name = "LASTUPDATEDBY")
	private String lastUpdatedBy;
	
	@Column(name = "LASTUPDATED")
	private Timestamp lastUpdated;
	
	//屬於該問題類型的客服表單紀錄
	@OneToMany(mappedBy = "quTypeVO", fetch=FetchType.EAGER)
	private Set<CsFormVO> csforms = new HashSet<CsFormVO>();

	public QuTypeVO() {
		super();
	}

	public Integer getQuTypeId() {
		return quTypeId;
	}

	public void setQuTypeId(Integer quTypeId) {
		this.quTypeId = quTypeId;
	}

	public String getQuTypeDesc() {
		return quTypeDesc;
	}

	public void setQuTypeDesc(String quTypeDesc) {
		this.quTypeDesc = quTypeDesc;
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
	
	
	
}
