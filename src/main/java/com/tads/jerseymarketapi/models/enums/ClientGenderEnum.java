package com.tads.jerseymarketapi.models.enums;

public enum ClientGenderEnum {
    DEFAULT(0),
    MASCULINE(1),
    FEMININE(2);
    private final int gender;

    ClientGenderEnum(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }
}
