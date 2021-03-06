package me.study.petclinic.pet.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PetCreateDto {

    @NotNull
    private Long ownerId;

    @NotEmpty
    private String name;

    @NotNull
    private Character gender;

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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
