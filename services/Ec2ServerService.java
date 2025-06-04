package com.codingbc.runmydocker.services;

import com.codingbc.runmydocker.dto.Ec2Server.*;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ec2ServerService {

    public Ec2ServerCreateResponse create(Ec2ServerCreateRequest request) {
        // TODO: implement
        return new Ec2ServerCreateResponse("IMPLEMENT ME!");
    }

    public Ec2ServerActionResponse start(Ec2ServerActionRequest request) {
        // TODO: implement
        return new Ec2ServerActionResponse("IMPLEMENT ME!");
    }

    public Ec2ServerActionResponse stop(Ec2ServerActionRequest request) {
        // TODO: implement
        return new Ec2ServerActionResponse("IMPLEMENT ME!");
    }

    public Ec2ServerActionResponse restart(Ec2ServerActionRequest request) {
        // TODO: implement
        return new Ec2ServerActionResponse("IMPLEMENT ME!");
    }

    public Ec2ServerActionResponse terminate(Ec2ServerActionRequest request) {
        // TODO: implement
        return new Ec2ServerActionResponse("IMPLEMENT ME!");
    }

    public Ec2ServerGetDetailsResponse getDetails(Ec2ServerGetDetailsRequest request) {
        // TODO: implement
        return new Ec2ServerGetDetailsResponse("63.185.21.23", "ec2_app", 45689, "t2.nano", "up");
    }
}
