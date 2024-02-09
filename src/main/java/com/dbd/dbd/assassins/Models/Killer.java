package com.dbd.dbd.assassins.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Killer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name, skill,height;

    private byte[] img;
    private Set<Perk> perks = new HashSet<>();


    private double speed;
    private int horrorRadio;


    public static  void main(String[] args){

    }
    public Killer() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Set<Perk> getPerks() {
        return perks;
    }

    public void setPerks(Set<Perk> perks) {
        this.perks = perks;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getHorrorRadio() {
        return horrorRadio;
    }

    public void setHorrorRadio(int horrorRadio) {
        this.horrorRadio = horrorRadio;
    }



}
