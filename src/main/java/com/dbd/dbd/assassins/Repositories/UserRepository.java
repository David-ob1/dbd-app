package com.dbd.dbd.assassins.Repositories;

import com.dbd.dbd.assassins.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,String>{

    User findByEmail(String email);

}
