package com.tia102g1.orderlistinfo.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;

import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.productcomment.model.ProductCommentVO;
import com.tia102g1.productinfo.entity.ProductInfo;


@Entity
@Table(name = "orderlistinfo")
public class OrderListInfoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderListInfoId", updatable = false)
	private Integer orderListInfoId;
	
//	@Column(name = "orderListId")
//	private Integer orderListId;
	@ManyToOne
	@JoinColumn(name = "orderListId", referencedColumnName = "orderListId")
	private OrderListVO orderListVO;
	
//	@Column(name = "productId")
//	private Integer productId;
	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private ProductInfo productInfo;
	
	
	@Column(name = "purchasedPrice")
	private Integer purchasedPrice;
	
	@Column(name = "proQuantity")
	@DecimalMin(value = "0", message = "商品數量 : 不能小於{value}")
	private Integer proQuantity;
	
	@Column(name = "createdBy", updatable = false)
	private String createdBy;
	
	@Column(name = "dateCreated", insertable = false, updatable = false)
	private Timestamp dateCreated;
	
	@Column(name = "lastUpdatedBy")
	private String lastUpdatedBy;
	
	@Column(name = "lastUpdated", insertable = false, updatable = false)
	private Timestamp lastUpdated;
	
	//此訂單商品明細下關聯的商品評價紀錄
	@OneToMany(mappedBy = "orderListInfoVO", fetch=FetchType.EAGER)
	@OrderBy("proCommentId asc")
	private Set<ProductCommentVO> productCommentVO = new HashSet<ProductCommentVO>();

	
	//訂單明細RowMapper中的商品資訊相關擴充欄位
	//訂單主檔ID(無關聯的)
	@Transient
	private Integer orderListIdRM;
	
	//商品資料ID(無關聯的)
	@Transient
	private Integer productIdRM;
	
	//商品名稱
	@Transient
	private String proName;
	
	//商品圖片
	@Transient
	private byte[] proPic;
	
	
	
	public OrderListInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderListInfoVO(Integer orderListInfoId, OrderListVO orderListVO, ProductInfo productInfo,
			Integer purchasedPrice, @DecimalMin(value = "0", message = "商品數量 : 不能小於{value}") Integer proQuantity,
			String createdBy, Timestamp dateCreated, String lastUpdatedBy, Timestamp lastUpdated,
			Set<ProductCommentVO> productCommentVO) {
		super();
		this.orderListInfoId = orderListInfoId;
		this.orderListVO = orderListVO;
		this.productInfo = productInfo;
		this.purchasedPrice = purchasedPrice;
		this.proQuantity = proQuantity;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
		this.productCommentVO = productCommentVO;
	}

	public Integer getOrderListInfoId() {
		return orderListInfoId;
	}

	public void setOrderListInfoId(Integer orderListInfoId) {
		this.orderListInfoId = orderListInfoId;
	}

	public OrderListVO getOrderListVO() {
		return orderListVO;
	}

	public void setOrderListVO(OrderListVO orderListVO) {
		this.orderListVO = orderListVO;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public Integer getPurchasedPrice() {
		return purchasedPrice;
	}

	public void setPurchasedPrice(Integer purchasedPrice) {
		this.purchasedPrice = purchasedPrice;
	}

	public Integer getProQuantity() {
		return proQuantity;
	}

	public void setProQuantity(Integer proQuantity) {
		this.proQuantity = proQuantity;
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

	public Set<ProductCommentVO> getProductCommentVO() {
		return productCommentVO;
	}

	public void setProductCommentVO(Set<ProductCommentVO> productCommentVO) {
		this.productCommentVO = productCommentVO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public Integer getOrderListIdRM() {
		return orderListIdRM;
	}

	public void setOrderListIdRM(Integer orderListIdRM) {
		this.orderListIdRM = orderListIdRM;
	}

	public Integer getProductIdRM() {
		return productIdRM;
	}

	public void setProductIdRM(Integer productIdRM) {
		this.productIdRM = productIdRM;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public byte[] getProPic() {
		return proPic;
	}

	public void setProPic(byte[] proPic) {
		this.proPic = proPic;
	}

	@Override
	public String toString() {
		return "OrderListInfoVO [orderListInfoId=" + orderListInfoId + ", orderListVO=" + orderListVO + ", productInfo="
				+ productInfo + ", purchasedPrice=" + purchasedPrice + ", proQuantity=" + proQuantity + ", createdBy="
				+ createdBy + ", dateCreated=" + dateCreated + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdated="
				+ lastUpdated + ", productCommentVO=" + productCommentVO + "]";
	}

}
