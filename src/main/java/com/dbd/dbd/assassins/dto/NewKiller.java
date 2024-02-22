package com.dbd.dbd.assassins.dto;

import java.util.Set;

public record NewKiller(String name, String skill , byte[] img, String height,double speed, int terrorRadius) {

    public String imageInfo() {
        return "Image size: " + (img != null ? img.length : 0) + " bytes";
    }
}
