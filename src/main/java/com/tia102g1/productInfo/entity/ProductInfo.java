package com.tia102g1.productInfo.entity;

import com.tia102g1.productType.model.ProductTypeVO;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity //要加上@Entity才能成為JPA的一個Entity類別
@Table(name = "productinfo") //標示此永續類別對應到何Table
public class ProductInfo {
	@Id //描述此屬性為表格PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //欄位值為Auto Increatement機制
	@Column(name = "productId", updatable = false)
	private Integer productId;
	
	
//	@ManyToOne
//	@JoinColumn(name = "productTypeId", referencedColumnName = "productTypeId")
//	private Set<ProductType> productType;
	@Column(name = "productTypeId")
	@NotNull(message="商品類型: 請勿空白")
	private Integer productTypeId;
	
	@Column(name = "proName")
	@NotEmpty(message="商品名稱: 請勿空白")
	private String proName;
	
	@Column(name = "proPrice")
	@NotNull(message="商品單價: 請勿空白")
	@DecimalMin(value = "1", message = "商品單價: 不能小於{value}")
	private Integer proPrice;
	
	@Column(name = "proSafetyStock")
	@NotNull(message="商品安全存量: 請勿空白")
	private Integer proSafetyStock;
	
	@Column(name = "totalCount")
	@NotNull(message="商品結餘量: 請勿空白")
	private Integer totalCount;
	
	@Column(name = "commentUsers")
	private Integer commentUsers;
	
	@Column(name = "commentStars")
	private Integer commentStars;
	
	@Column(name = "proPic", columnDefinition = "longblob" )
	private byte[] proPic;
	
	@Column(name = "proStatus")
	@NotNull(message="商品狀態: 請勿空白")
	private Integer proStatus;
	
	@Column(name = "proDesc", columnDefinition = "longtext" )
	@NotEmpty(message="商品描述: 請勿空白")
	private String proDesc;
	
	@Column(name = "createdBy", updatable = false)
	private String createdBy;
	
	@Column(name = "dateCreated", updatable = false)
	private Timestamp dateCreated;
	
	@Column(name = "lastUpdatedBy")
	private String lastUpdatedBy;
	
	@Column(name = "lastUpdated")
	private Timestamp lastUpdated;
	
	

	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInfo(Integer productId, Integer productTypeId, String proName, Integer proPrice,
			Integer proSafetyStock, Integer totalCount, Integer commentUsers, Integer commentStars, byte[] proPic,
			Integer proStatus, String proDesc, String createdBy, Timestamp dateCreated, String lastUpdatedBy,
			Timestamp lastUpdated) {
		super();
		this.productId = productId;
		this.productTypeId = productTypeId;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proSafetyStock = proSafetyStock;
		this.totalCount = totalCount;
		this.commentUsers = commentUsers;
		this.commentStars = commentStars;
		this.proPic = proPic;
		this.proStatus = proStatus;
		this.proDesc = proDesc;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Integer getProPrice() {
		return proPrice;
	}

	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}

	public Integer getProSafetyStock() {
		return proSafetyStock;
	}

	public void setProSafetyStock(Integer proSafetyStock) {
		this.proSafetyStock = proSafetyStock;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getCommentUsers() {
		return commentUsers;
	}

	public void setCommentUsers(Integer commentUsers) {
		this.commentUsers = commentUsers;
	}

	public Integer getCommentStars() {
		return commentStars;
	}

	public void setCommentStars(Integer commentStars) {
		this.commentStars = commentStars;
	}

	public byte[] getProPic() {
		return proPic;
	}

	public void setProPic(byte[] proPic) {
		this.proPic = proPic;
	}

	public Integer getProStatus() {
		return proStatus;
	}

	public void setProStatus(Integer proStatus) {
		this.proStatus = proStatus;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
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
		return "ProductInfo [productId=" + productId + ", productTypeId=" + productTypeId + ", proName=" + proName
				+ ", proPrice=" + proPrice + ", proSafetyStock=" + proSafetyStock + ", totalCount=" + totalCount
				+ ", commentUsers=" + commentUsers + ", commentStars=" + commentStars + ", proPic="
				+ Arrays.toString(proPic) + ", proStatus=" + proStatus + ", proDesc=" + proDesc + ", createdBy="
				+ createdBy + ", dateCreated=" + dateCreated + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
	
}
