package com.dbd.dbd.assassins.Repositories;

import com.dbd.dbd.assassins.Models.Killer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KillerRepository extends JpaRepository<Killer,String> {
}
