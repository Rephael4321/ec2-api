package com.codingbc.runmydocker.dto.Ec2Server;

import lombok.Data;

@Data
public class Ec2ServerCreateRequest {
    private String ec2Type;
    private int port;
    private String appName;
}
