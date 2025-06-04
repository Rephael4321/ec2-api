package com.codingbc.runmydocker.dto.Ec2Server;

import lombok.Data;

@Data
public class Ec2ServerActionRequest {
    private String ec2Id;
    private String action;
}
