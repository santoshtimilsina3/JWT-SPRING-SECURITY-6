package com.ons.securitylayerJwt.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    //it's a Data transfer Object for Login
    private String email ;
    private String password ;
}
