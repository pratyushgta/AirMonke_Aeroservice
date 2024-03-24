package com.novemberecho.Authentication.Repository;

import com.novemberecho.Authentication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //method will retrieve user from DB by email
    User findByEmail(String email);
}
