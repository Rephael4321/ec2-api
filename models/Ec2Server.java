package com.codingbc.runmydocker.models;

import com.codingbc.runmydocker.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ec2_servers")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ec2Server extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank
    @Size(max = 50)
    @Column(name = "ec2_instance_id", nullable = false)
    private String ec2InstanceId;

    @NotNull
    @Min(1)
    @Column(name = "exposed_port", nullable = false)
    private Integer exposedPort;

    @NotBlank
    @Size(max = 100)
    @Column(name = "app_name", nullable = false)
    private String appName;
}
