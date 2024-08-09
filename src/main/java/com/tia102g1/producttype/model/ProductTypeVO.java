package com.tia102g1.producttype.model;

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

import com.tia102g1.productinfo.entity.ProductInfo;

@Entity
@Table(name = "PRODUCTTYPE")
public class ProductTypeVO implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L; 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCTTYPEID")
	private Integer productTypeId;
	
	@NotEmpty(message="商品類型名稱:請勿空白")
	@Pattern(regexp="^[\\u4e00-\\u9fa5]+$", message = "商品類型名稱:請輸入中文")
	@Column(name = "TYPENAME", unique = true)
	private String typeName;
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@Column(name = "DATECREATED")
	private Timestamp dateCreated;
	
	@Column(name = "LASTUPDATEDBY")
	private String lastUpdatedBy;
	
	@Column(name = "LASTUPDATED")
	private Timestamp lastUpdated;
	
	@OneToMany(mappedBy = "productTypeVO")
	private Set<ProductInfo> productInfos = new HashSet<ProductInfo>();
	
	public ProductTypeVO() {
	}
	
	public Integer getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public Set<ProductInfo> getProductInfos() {
		return productInfos;
	}

	public void setProductInfos(Set<ProductInfo> productInfos) {
		this.productInfos = productInfos;
	}

}
