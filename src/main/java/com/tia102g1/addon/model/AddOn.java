package com.tia102g1.addon.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tia102g1.county.model.CountyVO;
import com.tia102g1.productinfo.entity.ProductInfo;

@Entity
@Table(name = "addOn")
public class AddOn implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addOnId", updatable = false)
	private Integer addOnId;
	
	
	@ManyToOne
	@JoinColumn(name = "mainProId", referencedColumnName = "productId")
	private ProductInfo productInfoMain;
//	@Column(name = "mainProId")
//	private Integer mainProId;
	
	
	@ManyToOne
	@JoinColumn(name = "addOnProId", referencedColumnName = "productId")
	private ProductInfo productInfoAdd;
//	@Column(name = "addOnProId")
//	private Integer addOnProId;
		
	@Column(name = "addOnPrice")
	@NotNull(message = "加購價: 請勿空白")
	@DecimalMin(value = "1", message = "加購價: 不能小於{value}")
	private Integer addOnPrice;
	
	@Column(name = "status")
	@NotNull(message = "啟用狀態: 請勿空白")
	private Integer status;
		
	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "dateCreated")
	private Timestamp dateCreated;

	@Column(name = "lastUpdatedBy")
	@NotEmpty(message = "最後更新者: 請勿空白")
	private String lastUpdatedBy;

	@Column(name = "lastUpdated")
	private Timestamp lastUpdated;

	public AddOn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddOn(Integer addOnId, ProductInfo productInfoMain, ProductInfo productInfoAdd,
			@NotNull(message = "加購價: 請勿空白") @DecimalMin(value = "1", message = "加購價: 不能小於{value}") Integer addOnPrice,
			@NotNull(message = "啟用狀態: 請勿空白") Integer status, String createdBy, Timestamp dateCreated,
			@NotEmpty(message = "最後更新者: 請勿空白") String lastUpdatedBy, Timestamp lastUpdated) {
		super();
		this.addOnId = addOnId;
		this.productInfoMain = productInfoMain;
		this.productInfoAdd = productInfoAdd;
		this.addOnPrice = addOnPrice;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
	}

	public Integer getAddOnId() {
		return addOnId;
	}

	public void setAddOnId(Integer addOnId) {
		this.addOnId = addOnId;
	}

	public ProductInfo getProductInfoMain() {
		return productInfoMain;
	}

	public void setProductInfoMain(ProductInfo productInfoMain) {
		this.productInfoMain = productInfoMain;
	}

	public ProductInfo getProductInfoAdd() {
		return productInfoAdd;
	}

	public void setProductInfoAdd(ProductInfo productInfoAdd) {
		this.productInfoAdd = productInfoAdd;
	}

	public Integer getAddOnPrice() {
		return addOnPrice;
	}

	public void setAddOnPrice(Integer addOnPrice) {
		this.addOnPrice = addOnPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "AddOn [addOnId=" + addOnId + ", productInfoMain=" + productInfoMain + ", productInfoAdd="
				+ productInfoAdd + ", addOnPrice=" + addOnPrice + ", status=" + status + ", createdBy=" + createdBy
				+ ", dateCreated=" + dateCreated + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdated=" + lastUpdated
				+ "]";
	}

	
	
}
