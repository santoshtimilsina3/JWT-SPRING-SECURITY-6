package com.ons.securitylayerJwt;

import com.ons.securitylayerJwt.businessLogic.IUserService;
import com.ons.securitylayerJwt.models.Role;
import com.ons.securitylayerJwt.enums.RoleName;
import com.ons.securitylayerJwt.models.User;
import com.ons.securitylayerJwt.repository.IRoleRepository;
import com.ons.securitylayerJwt.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityLayerJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityLayerJwtApplication.class, args);
    }

    @Bean
    CommandLineRunner run(IUserService iUserService, IRoleRepository iRoleRepository, IUserRepository iUserRepository, PasswordEncoder passwordEncoder) {
        return args ->
        {
            iUserService.saveRole(new Role(RoleName.ROLE_USER));
            iUserService.saveRole(new Role(RoleName.ROLE_ADMIN));
            iUserService.saveRole(new Role(RoleName.ROLE_SUPERADMIN));
            iUserService.saverUser(new User("admin@gmail.com", passwordEncoder.encode("adminPassword"), new ArrayList<>()));
            iUserService.saverUser(new User("superadminadmin@gmail.com", passwordEncoder.encode("superadminPassword"), new ArrayList<>()));

            Role role = iRoleRepository.findByRoleName(RoleName.ROLE_ADMIN);
            User user = iUserRepository.findByEmail("admin@gmail.com").orElse(null);
            user.getRoles().add(role);
            iUserService.saverUser(user);

            User userr = iUserRepository.findByEmail("superadminadmin@gmail.com").orElse(null);
            Role rolee = iRoleRepository.findByRoleName(RoleName.ROLE_SUPERADMIN);
            userr.getRoles().add(rolee);
            iUserService.saverUser(userr);

        };
    }

}

