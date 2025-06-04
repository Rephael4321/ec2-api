package com.codingbc.runmydocker.dto.Ec2Server;

import lombok.Data;

@Data
public class Ec2ServerActionResponse {
    private String actionResult;

    public Ec2ServerActionResponse(String actionResult) {
        this.actionResult = actionResult;
    }
}
