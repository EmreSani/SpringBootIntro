package com.tpe.service;

import com.tpe.domain.Role;
import com.tpe.domain.User;
import com.tpe.domain.enums.UserRole;
import com.tpe.dto.UserRequest;
import com.tpe.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public void saveUser(UserRequest userRequest) {
        User myUser = new User();

        myUser.setFirstName(userRequest.getFirstName());
        myUser.setLastName(userRequest.getLastName());
        myUser.setUserName(userRequest.getUserName());
        //myUser.setPassword(userRequest.getPassword());
        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
        myUser.setPassword(encodedPassword);
        // User a rol bilgisi setleniyor
        Role role = roleService.getRoleByType(UserRole.ROLE_ADMIN);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        myUser.setRoles(roles);

        userRepository.save(myUser);
    }
}
