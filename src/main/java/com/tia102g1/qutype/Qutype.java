package com.tia102g1.qutype;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "qutype")
public class Qutype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUTYPEID", columnDefinition = "int UNSIGNED not null")
    private Integer quTypeId;

    @Size(max = 50)
    @NotNull
    @Column(name = "QUTYPEDESC", nullable = false, length = 50)
    private String quTypeDesc;

    @Size(max = 50)
    @NotNull
    @Column(name = "CREATEDBY", nullable = false, length = 50)
    private String createdBy;

    @NotNull
    @Column(name = "DATECREATED", nullable = false)
    private Instant dateCreated;

    @Size(max = 50)
    @NotNull
    @Column(name = "LASTUPDATEDBY", nullable = false, length = 50)
    private String lastUpdatedBy;

    @NotNull
    @Column(name = "LASTUPDATED", nullable = false)
    private Instant lastUpdated;

}