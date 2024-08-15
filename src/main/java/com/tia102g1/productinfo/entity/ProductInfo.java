package com.tia102g1.productinfo.entity;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.tia102g1.addon.model.AddOn;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;
import com.tia102g1.productcomment.model.ProductCommentVO;
import com.tia102g1.producttype.model.ProductTypeVO;

@Entity // 要加上@Entity才能成為JPA的一個Entity類別
@Table(name = "productinfo") // 標示此永續類別對應到何Table
public class ProductInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id // 描述此屬性為表格PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 欄位值為Auto Increatement機制
	@Column(name = "productId", updatable = false)
	private Integer productId;

	@ManyToOne
	@JoinColumn(name = "PRODUCTTYPEID", referencedColumnName = "PRODUCTTYPEID")
	private ProductTypeVO productTypeVO;
//	@Column(name = "productTypeId")
//	@NotNull(message="商品類型: 請勿空白")
//	private Integer productTypeId;

	@Column(name = "proName")
	@Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "商品名稱: 請輸入中文")
	@NotEmpty(message = "商品名稱: 請勿空白")
	private String proName;

	@Column(name = "proPrice")
	@NotNull(message = "商品單價: 請勿空白")
	@DecimalMin(value = "1", message = "商品單價: 不能小於{value}")
	private Integer proPrice;

	@Column(name = "proSafetyStock")
	@NotNull(message = "商品安全存量: 請勿空白")
	private Integer proSafetyStock;

	@Column(name = "totalCount")
	@NotNull(message = "商品結餘量: 請勿空白")
	private Integer totalCount;

	@Column(name = "commentUsers")
	private Integer commentUsers;

	@Column(name = "commentStars")
	private Integer commentStars;

	@Column(name = "proPic", columnDefinition = "longblob")
	private byte[] proPic;

	@Column(name = "proStatus")
	@NotNull(message = "商品狀態: 請勿空白")
	private Integer proStatus;

	@Column(name = "proDesc", columnDefinition = "longtext")
	@NotEmpty(message = "商品描述: 請勿空白")
	private String proDesc;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "dateCreated")
	private Timestamp dateCreated;

	@Column(name = "lastUpdatedBy")
	@NotEmpty(message = "最後更新者: 請勿空白")
	private String lastUpdatedBy;

	@Column(name = "lastUpdated")
	private Timestamp lastUpdated;

	// 此商品下關聯的訂單紀錄
	@OneToMany(mappedBy = "productInfo", fetch = FetchType.EAGER)
	@OrderBy("orderListInfoId asc")
	private Set<OrderListInfoVO> orderListInfoVO = new HashSet<OrderListInfoVO>();

	// 此商品下關聯的商品評價紀錄
	@OneToMany(mappedBy = "productInfo", fetch = FetchType.EAGER)
	@OrderBy("proCommentId asc")
	private Set<ProductCommentVO> productCommentVO = new HashSet<ProductCommentVO>();

	// 此商品下關聯的加購商品紀錄
	@OneToMany(mappedBy = "productInfoMain", fetch = FetchType.EAGER)
	@OrderBy("addOnId asc")
	private Set<AddOn> addOnMain = new HashSet<AddOn>();

	// 此商品下關聯的被加購商品紀錄
	@OneToMany(mappedBy = "productInfoAdd", fetch = FetchType.EAGER)
	@OrderBy("addOnId asc")
	private Set<AddOn> addOnAdd = new HashSet<AddOn>();

	//商品資訊RowMapper中的相關擴充欄位
	//商品類型id(無關聯的)
	@Transient
	private Integer ProductTypeIdRM;
	
	public ProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInfo(Integer productId, ProductTypeVO productTypeVO,
			@Pattern(regexp = "^[\\u4e00-\\u9fa5]+$", message = "商品名稱: 請輸入中文") @NotEmpty(message = "商品名稱: 請勿空白") String proName,
			@NotNull(message = "商品單價: 請勿空白") @DecimalMin(value = "1", message = "商品單價: 不能小於{value}") Integer proPrice,
			@NotNull(message = "商品安全存量: 請勿空白") Integer proSafetyStock,
			@NotNull(message = "商品結餘量: 請勿空白") Integer totalCount, Integer commentUsers, Integer commentStars,
			byte[] proPic, @NotNull(message = "商品狀態: 請勿空白") Integer proStatus,
			@NotEmpty(message = "商品描述: 請勿空白") String proDesc, String createdBy, Timestamp dateCreated,
			@NotEmpty(message = "最後更新者: 請勿空白") String lastUpdatedBy, Timestamp lastUpdated,
			Set<OrderListInfoVO> orderListInfoVO, Set<ProductCommentVO> productCommentVO, Set<AddOn> addOnMain,
			Set<AddOn> addOnAdd) {
		super();
		this.productId = productId;
		this.productTypeVO = productTypeVO;
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
		this.orderListInfoVO = orderListInfoVO;
		this.productCommentVO = productCommentVO;
		this.addOnMain = addOnMain;
		this.addOnAdd = addOnAdd;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public ProductTypeVO getProductTypeVO() {
		return productTypeVO;
	}

	public void setProductTypeVO(ProductTypeVO productTypeVO) {
		this.productTypeVO = productTypeVO;
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

	public Set<OrderListInfoVO> getOrderListInfoVO() {
		return orderListInfoVO;
	}

	public void setOrderListInfoVO(Set<OrderListInfoVO> orderListInfoVO) {
		this.orderListInfoVO = orderListInfoVO;
	}

	public Set<ProductCommentVO> getProductCommentVO() {
		return productCommentVO;
	}

	public void setProductCommentVO(Set<ProductCommentVO> productCommentVO) {
		this.productCommentVO = productCommentVO;
	}

	public Set<AddOn> getAddOnMain() {
		return addOnMain;
	}

	public void setAddOnMain(Set<AddOn> addOnMain) {
		this.addOnMain = addOnMain;
	}

	public Set<AddOn> getAddOnAdd() {
		return addOnAdd;
	}

	public void setAddOnAdd(Set<AddOn> addOnAdd) {
		this.addOnAdd = addOnAdd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getProductTypeIdRM() {
		return ProductTypeIdRM;
	}

	public void setProductTypeIdRM(Integer productTypeIdRM) {
		ProductTypeIdRM = productTypeIdRM;
	}

	
	
}
