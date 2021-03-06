package com.java.login.webUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail (String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " + "SET a.enable = TRUE WHERE a.email = ?1")

    int enableUser(String email);
}
