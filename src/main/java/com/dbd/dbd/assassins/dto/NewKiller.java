package com.dbd.dbd.assassins.dto;

import java.util.Set;

public record NewKiller(String name, String skill , byte[] img,Set perks, String height,double speed, int horrorRadio) {
}
