package com.ons.securitylayerJwt.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/superadmin")
@RequiredArgsConstructor
public class SuperadminRestController {


    //http://localhost:8087/api/superadmin/hi
    @GetMapping("/hi")
    @Secured({"SUPERADMIN"})
    public String sayHi ()
    {
        return "Hi" ;
    }


}
