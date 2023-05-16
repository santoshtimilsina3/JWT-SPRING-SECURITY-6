package com.ons.securitylayerJwt.businessLogic;


import com.ons.securitylayerJwt.dto.LoginDto;
import com.ons.securitylayerJwt.dto.RegisterDto;
import com.ons.securitylayerJwt.models.Role;
import com.ons.securitylayerJwt.models.User;
import org.springframework.http.ResponseEntity;


public interface IUserService {

   ResponseEntity<?> authenticate(LoginDto loginDto);
   ResponseEntity<?> register (RegisterDto registerDto);
   Role saveRole(Role role);

   User saverUser (User user) ;
}
