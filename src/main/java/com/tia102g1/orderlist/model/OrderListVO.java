package com.tia102g1.orderlist.model;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.tia102g1.county.model.CountyVO;
import com.tia102g1.coupon.Coupon;
import com.tia102g1.dist.model.DistVO;
import com.tia102g1.event.model.EventVO;
import com.tia102g1.member.model.Member;
import com.tia102g1.membercoin.model.MemberCoinVO;
import com.tia102g1.orderlistinfo.model.OrderListInfoVO;

@Entity
@Table(name = "OrderList")
public class OrderListVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderListId")
	private Integer orderListId;

	@ManyToOne
	@JoinColumn(name = "memberId", referencedColumnName = "memberId")
	private Member member;
//	@Column(name = "memberId")
//	private Integer memberId;

	@ManyToOne
	@JoinColumn(name = "couponId", referencedColumnName = "couponId")
	private Coupon coupon;
//	@Column(name = "couponId")
//	private Integer couponId;

	@ManyToOne
	@JoinColumn(name = "eventId", referencedColumnName = "eventId")
	private EventVO eventVO;
//	@Column(name = "eventId")
//	private Integer eventId;

	@Column(name = "orderDt")
	private Timestamp orderDt;

	@Column(name = "orderAmount")
	private Integer orderAmount;

	@Column(name = "couponUsedAmount")
	private Integer couponUsedAmount;

	@Column(name = "coinUsedAmount")
	private Integer coinUsedAmount;

	@Column(name = "payAmount")
	private Integer payAmount;

	@Column(name = "orderStatus")
	private Integer orderStatus;

	@Column(name = "paymentMethod")
	private Integer paymentMethod;

	@Column(name = "paymentStatus")
	private Integer paymentStatus;

	@Column(name = "pickupMethod")
	private Integer pickupMethod;

	@Column(name = "useCoupon")
	private Integer useCoupon;

	@Column(name = "useCoin")
	private Integer useCoin;

	@Column(name = "cardHolder")
	private String cardHolder;

	@Column(name = "cardNumber")
	private String cardNumber;

	@Column(name = "cardYy")
	private Integer cardYy;

	@Column(name = "cardMm")
	private String cardMm;

	@Column(name = "cardVerifyCode")
	private String cardVerifyCode;

	@Column(name = "invoiceWay")
	private Integer invoiceWay;

	@Column(name = "invoiceTaxNo")
	private String invoiceTaxNo;

	@Column(name = "invoiceMobileCode")
	private String invoiceMobileCode;

	@Column(name = "recipientName")
	@NotEmpty(message = "收件人姓名: 請勿空白")
	private String recipientName;

	@Column(name = "recipientPhone")
	@Pattern(regexp = "\\d+", message = "收件人電話: 請輸入數字")
	private String recipientPhone;

	@ManyToOne
	@JoinColumn(name = "recipientCnt", referencedColumnName = "cntCode")
	private CountyVO countyVO;
//	@Column(name = "recipientCnt")
//	private Integer recipientCnt;

	@ManyToOne
	@JoinColumn(name = "recipientDist", referencedColumnName = "distCode")
	private DistVO distVO;
//	@Column(name = "recipientDist")
//	private Integer recipientDist;

	@NotBlank(message = "收件人地址: 請勿空白")
	@Column(name = "recipientAddress")
	private String recipientAddress;

	@Column(name = "createdBy")
	private String createdBy;

	@Column(name = "dateCreated")
	private Timestamp dateCreated;

	@Column(name = "lastUpdatedBy")
	@NotEmpty(message = "最後更新者: 請勿空白")
	private String lastUpdatedBy;

	@Column(name = "lastUpdated")

	private Timestamp lastUpdated;

	// 此訂單主檔下關聯的購物金持有紀錄
	@OneToMany(mappedBy = "orderListVO", fetch = FetchType.EAGER)
	@OrderBy("memCoinId asc")
	private Set<MemberCoinVO> memCoins = new HashSet<MemberCoinVO>();

	// 此訂單主檔下關聯的訂單紀錄
	@OneToMany(mappedBy = "orderListVO", fetch = FetchType.EAGER)
	@OrderBy("orderListInfoId asc")
	private Set<OrderListInfoVO> orderListInfoVO = new HashSet<OrderListInfoVO>();

	public OrderListVO() {
		super();
	}

	public OrderListVO(Integer orderListId, Member member, Coupon coupon, EventVO eventVO, Timestamp orderDt,
			Integer orderAmount, Integer couponUsedAmount, Integer coinUsedAmount, Integer payAmount,
			Integer orderStatus, Integer paymentMethod, Integer paymentStatus, Integer pickupMethod, Integer useCoupon,
			Integer useCoin, String cardHolder, String cardNumber, Integer cardYy, String cardMm, String cardVerifyCode,
			Integer invoiceWay, String invoiceTaxNo, String invoiceMobileCode,
			@NotEmpty(message = "收件人姓名: 請勿空白") String recipientName,
			@Pattern(regexp = "\\d+", message = "收件人電話: 請輸入數字") String recipientPhone, CountyVO countyVO, DistVO distVO,
			@NotBlank(message = "收件人地址: 請勿空白") String recipientAddress, String createdBy, Timestamp dateCreated,
			@NotEmpty(message = "最後更新者: 請勿空白") String lastUpdatedBy, Timestamp lastUpdated, Set<MemberCoinVO> memCoins,
			Set<OrderListInfoVO> orderListInfoVO) {
		super();
		this.orderListId = orderListId;
		this.member = member;
		this.coupon = coupon;
		this.eventVO = eventVO;
		this.orderDt = orderDt;
		this.orderAmount = orderAmount;
		this.couponUsedAmount = couponUsedAmount;
		this.coinUsedAmount = coinUsedAmount;
		this.payAmount = payAmount;
		this.orderStatus = orderStatus;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.pickupMethod = pickupMethod;
		this.useCoupon = useCoupon;
		this.useCoin = useCoin;
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
		this.cardYy = cardYy;
		this.cardMm = cardMm;
		this.cardVerifyCode = cardVerifyCode;
		this.invoiceWay = invoiceWay;
		this.invoiceTaxNo = invoiceTaxNo;
		this.invoiceMobileCode = invoiceMobileCode;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.countyVO = countyVO;
		this.distVO = distVO;
		this.recipientAddress = recipientAddress;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdated = lastUpdated;
		this.memCoins = memCoins;
		this.orderListInfoVO = orderListInfoVO;
	}

	public Integer getOrderListId() {
		return orderListId;
	}

	public void setOrderListId(Integer orderListId) {
		this.orderListId = orderListId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

	public EventVO getEventVO() {
		return eventVO;
	}

	public void setEventVO(EventVO eventVO) {
		this.eventVO = eventVO;
	}

	public Timestamp getOrderDt() {
		return orderDt;
	}

	public void setOrderDt(Timestamp orderDt) {
		this.orderDt = orderDt;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getCouponUsedAmount() {
		return couponUsedAmount;
	}

	public void setCouponUsedAmount(Integer couponUsedAmount) {
		this.couponUsedAmount = couponUsedAmount;
	}

	public Integer getCoinUsedAmount() {
		return coinUsedAmount;
	}

	public void setCoinUsedAmount(Integer coinUsedAmount) {
		this.coinUsedAmount = coinUsedAmount;
	}

	public Integer getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Integer payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getPickupMethod() {
		return pickupMethod;
	}

	public void setPickupMethod(Integer pickupMethod) {
		this.pickupMethod = pickupMethod;
	}

	public Integer getUseCoupon() {
		return useCoupon;
	}

	public void setUseCoupon(Integer useCoupon) {
		this.useCoupon = useCoupon;
	}

	public Integer getUseCoin() {
		return useCoin;
	}

	public void setUseCoin(Integer useCoin) {
		this.useCoin = useCoin;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getCardYy() {
		return cardYy;
	}

	public void setCardYy(Integer cardYy) {
		this.cardYy = cardYy;
	}

	public String getCardMm() {
		return cardMm;
	}

	public void setCardMm(String cardMm) {
		this.cardMm = cardMm;
	}

	public String getCardVerifyCode() {
		return cardVerifyCode;
	}

	public void setCardVerifyCode(String cardVerifyCode) {
		this.cardVerifyCode = cardVerifyCode;
	}

	public Integer getInvoiceWay() {
		return invoiceWay;
	}

	public void setInvoiceWay(Integer invoiceWay) {
		this.invoiceWay = invoiceWay;
	}

	public String getInvoiceTaxNo() {
		return invoiceTaxNo;
	}

	public void setInvoiceTaxNo(String invoiceTaxNo) {
		this.invoiceTaxNo = invoiceTaxNo;
	}

	public String getInvoiceMobileCode() {
		return invoiceMobileCode;
	}

	public void setInvoiceMobileCode(String invoiceMobileCode) {
		this.invoiceMobileCode = invoiceMobileCode;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	public CountyVO getCountyVO() {
		return countyVO;
	}

	public void setCountyVO(CountyVO countyVO) {
		this.countyVO = countyVO;
	}

	public DistVO getDistVO() {
		return distVO;
	}

	public void setDistVO(DistVO distVO) {
		this.distVO = distVO;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
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

	public Set<MemberCoinVO> getMemCoins() {
		return memCoins;
	}

	public void setMemCoins(Set<MemberCoinVO> memCoins) {
		this.memCoins = memCoins;
	}

	public Set<OrderListInfoVO> getOrderListInfoVO() {
		return orderListInfoVO;
	}

	public void setOrderListInfoVO(Set<OrderListInfoVO> orderListInfoVO) {
		this.orderListInfoVO = orderListInfoVO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderListVO [orderListId=" + orderListId + ", member=" + member + ", coupon=" + coupon + ", eventVO="
				+ eventVO + ", orderDt=" + orderDt + ", orderAmount=" + orderAmount + ", couponUsedAmount="
				+ couponUsedAmount + ", coinUsedAmount=" + coinUsedAmount + ", payAmount=" + payAmount
				+ ", orderStatus=" + orderStatus + ", paymentMethod=" + paymentMethod + ", paymentStatus="
				+ paymentStatus + ", pickupMethod=" + pickupMethod + ", useCoupon=" + useCoupon + ", useCoin=" + useCoin
				+ ", cardHolder=" + cardHolder + ", cardNumber=" + cardNumber + ", cardYy=" + cardYy + ", cardMm="
				+ cardMm + ", cardVerifyCode=" + cardVerifyCode + ", invoiceWay=" + invoiceWay + ", invoiceTaxNo="
				+ invoiceTaxNo + ", invoiceMobileCode=" + invoiceMobileCode + ", recipientName=" + recipientName
				+ ", recipientPhone=" + recipientPhone + ", countyVO=" + countyVO + ", distVO=" + distVO
				+ ", recipientAddress=" + recipientAddress + ", createdBy=" + createdBy + ", dateCreated=" + dateCreated
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdated=" + lastUpdated + ", memCoins=" + memCoins
				+ ", orderListInfoVO=" + orderListInfoVO + "]";
	}

	
}
