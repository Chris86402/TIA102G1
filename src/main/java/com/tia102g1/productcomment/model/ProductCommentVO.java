package com.tia102g1.productcomment.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tia102g1.member.model.Member;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;
import com.tia102g1.productinfo.entity.ProductInfo;
import com.tia102g1.staff.model.StaffVO;

@Entity
@Table(name = "productComment")
public class ProductCommentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proCommentId", updatable = false)
	private Integer proCommentId;
	
	@ManyToOne
	@JoinColumn(name = "memberId", referencedColumnName = "memberId")
	private Member member;	
//	@Column(name = "memberId")
//	private Integer memberId;	
	
	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private ProductInfo productInfo;	
//	@Column(name = "productId")
//	private Integer productId;
	
	@ManyToOne
	@JoinColumn(name = "orderListInfoId", referencedColumnName = "orderListInfoId")
	private OrderListInfoVO orderListInfoVO;
//	@Column(name = "orderListInfoId")
//	private Integer orderListInfoId;
	
	@ManyToOne
	@JoinColumn(name = "staffId", referencedColumnName = "staffId")
	private StaffVO staffVO;
//	@Column(name = "staffId")
//	private Integer staffId;
	
	@Column(name = "storeReply", columnDefinition = "longtext")
	private String storeReply;
	
	@Column(name = "commentText", columnDefinition = "longtext")
	@NotEmpty(message="評論內容: 請勿空白")
	private String commentText;
	
	@Column(name = "commentPic", columnDefinition = "longblob")
	private byte[] commentPic;
	
	@Column(name = "commentRate")
	@NotNull(message="滿意度: 請勿空白")
	private Integer commentRate;
	
	@Column(name = "commentDate")
	private Timestamp commentDate;
	
	@Column(name = "replyTime")
	private Timestamp replyTime;
	
	@Column(name = "createdBy")
	private String createdBy;
	
	@Column(name = "dateCreated")
	private Timestamp dateCreated;
	
	@Column(name = "lastUpdatedBy")
	@NotEmpty(message="最後更新者: 請勿空白")
	private String lastUpdatedBy;
	
	@Column(name = "lastUpdated")
	private Timestamp lastUpdated;

	public ProductCommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCommentVO(Integer proCommentId, Member member, ProductInfo productInfo,
			OrderListInfoVO orderListInfoVO, StaffVO staffVO, String storeReply,
			@NotEmpty(message = "評論內容: 請勿空白") String commentText, byte[] commentPic,
			@NotNull(message = "滿意度: 請勿空白") Integer commentRate, Timestamp commentDate, Timestamp replyTime,
			String createdBy, Timestamp dateCreated, @NotEmpty(message = "最後更新者: 請勿空白") String lastUpdatedBy,
			Timestamp lastUpdated) {
		super();
		this.proCommentId = proCommentId;
		this.member = member;
		this.productInfo = productInfo;
		this.orderListInfoVO = orderListInfoVO;
		this.staffVO = staffVO;
		this.storeReply = storeReply;
		this.commentText = commentText;
		this.commentPic = commentPic;
		this.commentRate = commentRate;
		this.commentDate = commentDate;
		this.replyTime = replyTime;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
	}

	public Integer getProCommentId() {
		return proCommentId;
	}

	public void setProCommentId(Integer proCommentId) {
		this.proCommentId = proCommentId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public OrderListInfoVO getOrderListInfoVO() {
		return orderListInfoVO;
	}

	public void setOrderListInfoVO(OrderListInfoVO orderListInfoVO) {
		this.orderListInfoVO = orderListInfoVO;
	}

	public StaffVO getStaffVO() {
		return staffVO;
	}

	public void setStaffVO(StaffVO staffVO) {
		this.staffVO = staffVO;
	}

	public String getStoreReply() {
		return storeReply;
	}

	public void setStoreReply(String storeReply) {
		this.storeReply = storeReply;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public byte[] getCommentPic() {
		return commentPic;
	}

	public void setCommentPic(byte[] commentPic) {
		this.commentPic = commentPic;
	}

	public Integer getCommentRate() {
		return commentRate;
	}

	public void setCommentRate(Integer commentRate) {
		this.commentRate = commentRate;
	}

	public Timestamp getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}

	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	

}
