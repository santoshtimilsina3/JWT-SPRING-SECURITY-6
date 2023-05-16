package com.ons.securitylayerJwt.controller;


import com.ons.securitylayerJwt.businessLogic.IUserService;
import com.ons.securitylayerJwt.dto.LoginDto;
import com.ons.securitylayerJwt.dto.RegisterDto;
import com.ons.securitylayerJwt.security.JwtUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserService iUserService;

    private final JwtUtilities jwtUtilities;

    //http://localhost:8087/api/user/register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {
        return iUserService.register(registerDto);
    }

    //http://localhost:8087/api/user/authenticate
    @PostMapping("/authenticate")
    public ResponseEntity authenticate(@RequestBody LoginDto loginDto) {
        return iUserService.authenticate(loginDto);
    }

    //http://localhost:8087/api/user/login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
        try {
            if (loginDto.getEmail() == null || loginDto.getPassword() == null) {
                throw new UsernameNotFoundException("UserName or Password is Empty");
            }
            return iUserService.authenticate(loginDto);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
