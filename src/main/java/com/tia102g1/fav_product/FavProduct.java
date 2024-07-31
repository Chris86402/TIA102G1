package com.tia102g1.fav_product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "favProduct")
public class FavProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAVPRODUCTID", columnDefinition = "int UNSIGNED not null")
    private Integer favProductId;


//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "MEMBERID", nullable = false)
//    private Member memberId;
    @NotNull
    @Column(name = "memberId")
    private Integer memberId;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "PRODUCTID", nullable = false)
//    private ProductInfo productId;
    @NotNull
    private Integer productId;

    @NotNull
    @Column(name = "JOINDT", nullable = false)
    private LocalDate joinDt;

}