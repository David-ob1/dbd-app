package com.dbd.dbd.assassins.Controlles;

import com.dbd.dbd.assassins.Models.Killer;
import com.dbd.dbd.assassins.Repositories.KillerRepository;
import com.dbd.dbd.assassins.dto.NewKiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/killers")
public class KillerController {
    @Autowired
    private KillerRepository killerRepository;

            @PostMapping("")
            public ResponseEntity<String> RegisterKiller(@RequestBody NewKiller newKiller){

                Killer killer = new Killer(newKiller.name(),newKiller.skill(),newKiller.img(),newKiller.height()
                        ,newKiller.speed(),newKiller.terrorRadius());
                killerRepository.save(killer);
            return new ResponseEntity<>("Todo salio bien", HttpStatus.CREATED);
            }

    @GetMapping("")
    public List<Killer> getAll(){
        return killerRepository.findAll();
    }
}
