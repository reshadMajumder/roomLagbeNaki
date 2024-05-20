package com.roomLagbe.roomlagbenaki.dao;

import com.roomLagbe.roomlagbenaki.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.phone = : phone")
    public  User getUserByUserName(@Param("phone") String phone);


    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}
