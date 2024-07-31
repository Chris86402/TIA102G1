package com.tia102g1.cart.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARTID", columnDefinition = "int UNSIGNED not null")
    private Integer cartId;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "MEMBERID", nullable = false)
//    private Member memberId;
    @NotNull
    private Integer memberId;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "PRODUCTID", nullable = false)
//    private ProductInfo productId;
    @NotNull
    private Integer productId;

    @NotNull
    @Column(name = "PROAMOUNT", nullable = false)
    private Integer proAmount;

    @NotNull
    @Column(name = "JOINDT", nullable = false)
    private LocalDate joinDt;

}