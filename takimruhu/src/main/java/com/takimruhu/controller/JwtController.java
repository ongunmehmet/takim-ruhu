package com.takimruhu.controller;

import com.takimruhu.application.business.StandartJwtApplication;
import com.takimruhu.dto.request.jwt.JwtRequest;
import com.takimruhu.dto.response.jwt.JwtResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class JwtController {

    private StandartJwtApplication standartJwtApplication;

    public JwtController(StandartJwtApplication standartJwtApplication) {
        this.standartJwtApplication = standartJwtApplication;
    }


    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    return standartJwtApplication.createJwtToken(jwtRequest);
    }
}
