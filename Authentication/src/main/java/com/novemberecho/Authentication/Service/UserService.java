package com.novemberecho.Authentication.Service;

import com.novemberecho.Authentication.DTO.UserRegistrationDto;
import com.novemberecho.Authentication.Entity.Role;
import com.novemberecho.Authentication.Entity.User;
import com.novemberecho.Authentication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(UserRegistrationDto registrationDto) {
        String r = "";
        if (registrationDto.getEmail().contains("admin"))
            r = "ROLE_ADMIN";
        else
            r = "ROLE_USER";
        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
                registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getGender(), registrationDto.getDob(), Arrays.asList(new Role(r)));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Optional<User> user = userRepository.findByEmail(username);
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("UserService41: Invalid Username or Password");
        }
        //return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
        return new CustomUserDetails(user);
        //return user.map(CustomUserDetails::new).get();
    }

    //method which will map roles to authorities
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
