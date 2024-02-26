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

    private double speed;
    private int terrorRadius;


    public static  void main(String[] args){

    }

    public Killer() {
    }

    public Killer(String name, String skill,  byte[] img,String height, double speed, int terrorRadius) {
        this.name = name;
        this.skill = skill;
        this.height = height;
        this.img = img;
        this.speed = speed;
        this.terrorRadius = terrorRadius;
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


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getHorrorRadio() {
        return terrorRadius;
    }

    public void setHorrorRadio(int horrorRadio) {
        this.terrorRadius = horrorRadio;
    }



}
