package com.tia102g1.csform.model;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.tia102g1.member.model.Member;
import com.tia102g1.orderlist.model.OrderListVO;
import com.tia102g1.qutype.model.QuTypeVO;
import com.tia102g1.staff.model.StaffVO;

@Entity
@Table(name = "CSFORM")
public class CsFormVO {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CSFORMID")
	private Integer csFormId;
	
//	@Column(name = "MEMBERID")
//	private Integer memberId;
	
	@ManyToOne
	@JoinColumn(name = "MEMBERID", referencedColumnName = "MEMBERID")
	private Member member;
	
//	@Column(name = "ORDERID")
//	private Integer orderId;
	
	@ManyToOne
	@JoinColumn(name = "ORDERID", referencedColumnName = "orderListId")
	private OrderListVO orderListVO;
	
//	@Column(name = "STAFFID")
//	private Integer staffId;
	
	@ManyToOne
	@JoinColumn(name = "STAFFID", referencedColumnName = "STAFFID")
	private StaffVO staffVO;
	
//	@Column(name = "QUTYPEID")
//	private Integer quTypeId;
	
	@ManyToOne
	@JoinColumn(name = "QUTYPEID", referencedColumnName = "QUTYPEID")
	private QuTypeVO quTypeVO;
	
	@Column(name = "QUDATE")
	private Date quDate;
	
	@Column(name = "QUCONTENT")
	private String quContent;
	
	@Column(name = "QUPIC", updatable = false)
	private byte[] quPic;
	
	@Column(name = "QUAVTIME")
	private String quAvTime;
	
	@Column(name = "REPLYDT")
	private Date replyDt;
	
	@Column(name = "REPLYCONTENT")
	private String replyContent;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "CREATEDBY", updatable = false)
	private String createdBy;
	
	@Column(name = "DATECREATED", insertable = false, updatable = false)
	private Date dateCreated;
	
	@Column(name = "LASTUPDATEDBY")
	private String lastUpdatedBy;
	
	@Column(name = "LASTUPDATED", insertable = false, updatable = false)
	private Date lastUpdated;

	public CsFormVO() {
		super();
	}

	public CsFormVO(Integer csFormId, Member member, OrderListVO orderListVO, StaffVO staffVO, QuTypeVO quTypeVO,
			Date quDate, String quContent, byte[] quPic, String quAvTime, Date replyDt, String replyContent,
			Integer status, String createdBy, Date dateCreated, String lastUpdatedBy, Date lastUpdated) {
		super();
		this.csFormId = csFormId;
		this.member = member;
		this.orderListVO = orderListVO;
		this.staffVO = staffVO;
		this.quTypeVO = quTypeVO;
		this.quDate = quDate;
		this.quContent = quContent;
		this.quPic = quPic;
		this.quAvTime = quAvTime;
		this.replyDt = replyDt;
		this.replyContent = replyContent;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
	}

	public Integer getCsFormId() {
		return csFormId;
	}

	public void setCsFormId(Integer csFormId) {
		this.csFormId = csFormId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public OrderListVO getOrderListVO() {
		return orderListVO;
	}

	public void setOrderListVO(OrderListVO orderListVO) {
		this.orderListVO = orderListVO;
	}

	public StaffVO getStaffVO() {
		return staffVO;
	}

	public void setStaffVO(StaffVO staffVO) {
		this.staffVO = staffVO;
	}

	public QuTypeVO getQuTypeVO() {
		return quTypeVO;
	}

	public void setQuTypeVO(QuTypeVO quTypeVO) {
		this.quTypeVO = quTypeVO;
	}

	public Date getQuDate() {
		return quDate;
	}

	public void setQuDate(Date quDate) {
		this.quDate = quDate;
	}

	public String getQuContent() {
		return quContent;
	}

	public void setQuContent(String quContent) {
		this.quContent = quContent;
	}

	public byte[] getQuPic() {
		return quPic;
	}

	public void setQuPic(byte[] quPic) {
		this.quPic = quPic;
	}

	public String getQuAvTime() {
		return quAvTime;
	}

	public void setQuAvTime(String quAvTime) {
		this.quAvTime = quAvTime;
	}

	public Date getReplyDt() {
		return replyDt;
	}

	public void setReplyDt(Date replyDt) {
		this.replyDt = replyDt;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "CsFormVO [csFormId=" + csFormId + ", member=" + member + ", orderListVO=" + orderListVO + ", staffVO="
				+ staffVO + ", quTypeVO=" + quTypeVO + ", quDate=" + quDate + ", quContent=" + quContent + ", quAvTime=" + quAvTime + ", replyDt=" + replyDt + ", replyContent="
				+ replyContent + ", status=" + status + ", createdBy=" + createdBy + ", dateCreated=" + dateCreated
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdated=" + lastUpdated + ", quPic=" + Arrays.toString(quPic) + "]";
	}

	
	
	
}
