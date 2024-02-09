package com.dbd.dbd.assassins.Repositories;

import com.dbd.dbd.assassins.Models.Perk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerkRepositories extends JpaRepository<Perk, String> {
}
