package com.codingbc.runmydocker.models;

import com.codingbc.runmydocker.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Digits(integer = 12, fraction = 2)
    @Column(name = "amount", nullable = false, precision = 14, scale = 2)
    private BigDecimal amount;

    @NotBlank
    @Size(max = 100)
    @Column(name = "service_type", nullable = false)
    private String serviceType;

    @NotNull
    @Column(name = "paid", nullable = false)
    private Boolean paid;
}
