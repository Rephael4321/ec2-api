package com.codingbc.runmydocker.models;

import com.codingbc.runmydocker.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "runtime_logs")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuntimeLog extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank
    @Size(max = 50)
    @Column(name = "ec2_type", nullable = false)
    private String ec2Type;

    @NotBlank
    @Size(max = 100)
    @Column(name = "status", nullable = false)
    private String status;
}
