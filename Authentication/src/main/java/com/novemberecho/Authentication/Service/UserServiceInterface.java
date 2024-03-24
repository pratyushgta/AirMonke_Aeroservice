package com.novemberecho.Authentication.Service;

import com.novemberecho.Authentication.DTO.UserRegistrationDto;
import com.novemberecho.Authentication.Entity.User;

public interface UserServiceInterface {
    User save(UserRegistrationDto registrationDto);
}
