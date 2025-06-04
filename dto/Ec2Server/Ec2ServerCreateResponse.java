package com.codingbc.runmydocker.dto.Ec2Server;

import lombok.Data;

@Data
public class Ec2ServerCreateResponse {
    private String creationResult;

    public Ec2ServerCreateResponse(String creationResult) {
        this.creationResult = creationResult;
    }
}
