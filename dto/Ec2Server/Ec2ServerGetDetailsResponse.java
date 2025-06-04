package com.codingbc.runmydocker.dto.Ec2Server;

import lombok.Data;

@Data
public class Ec2ServerGetDetailsResponse {
    private String ec2Address;
    private String appName;
    private int port;
    private String ec2Type;
    private String status;

    public Ec2ServerGetDetailsResponse(String ec2Address, String appName, int port, String ec2Type, String status) {
        this.ec2Address = ec2Address;
        this.appName = appName;
        this.port = port;
        this.ec2Type = ec2Type;
        this.status = status;
    }
}
