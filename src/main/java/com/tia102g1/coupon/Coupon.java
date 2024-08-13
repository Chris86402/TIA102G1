package com.tia102g1.coupon;

import com.tia102g1.orderlist.model.OrderListVO;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon")
public class Coupon implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUPONID", columnDefinition = "int UNSIGNED not null")
    private Integer couponId;

    @Size(max = 15, message = "優惠券代碼長度不能超過15個字符")
    @Column(name = "COUPONCODE", nullable = false, length = 20)
    private String couponCode;

    @Size(max = 30, message = "優惠券名稱長度不能超過30個字符")
    @Column(name = "COUPONNAME", nullable = false)
    private String couponName;

    @Column(name = "COUPONSTATUS", nullable = false)
    private Integer couponStatus;

    @Column(name = "STARTDT", nullable = false)
    private Date startDt;

    @Column(name = "ENDDT", nullable = false)
    private Date endDt;

    @Column(name = "DISCTYPE", nullable = false)
    private Integer discType;

    @Min(value = 0, message = "抵用金額必須介於0~500")
    @Max(value = 500, message = "抵用金額必須介於0~500")
    @Column(name = "DISCAMOUNT")
    private Integer discAmount;

    @DecimalMin(value = "0.00", inclusive = true, message = "折扣百分比必須為0~1之間的2位小數")
    @DecimalMax(value = "1.00", inclusive = true, message = "折扣百分比必須為0~1之間的2位小數")
    @Digits(integer = 1, fraction = 2, message = "折扣百分比必須為0~1之間的2位小數")
    @Column(name = "DISCPERCENTAGE", precision = 3, scale = 2)
    private BigDecimal discPercentage;

    @Column(name = "CREATEDBY", updatable = false)
    private String createdBy;

    @Column(name = "DATECREATED", insertable = false, updatable = false)
    private Timestamp dateCreated;

    @Column(name = "LASTUPDATEDBY")
    private String lastUpdatedBy;

    @Column(name = "LASTUPDATED", insertable = false, updatable = false)
    private Timestamp lastUpdated;

    // 此優惠券下關聯的訂單明細紀錄
    @OneToMany(mappedBy = "coupon", fetch = FetchType.EAGER)
    @OrderBy("orderListId asc")
    private Set<OrderListVO> orderLists = new HashSet<OrderListVO>();

}