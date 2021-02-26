package me.study.petclinic.pet.dto;

import javax.validation.constraints.NotEmpty;

public class PetCreateDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private char gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
