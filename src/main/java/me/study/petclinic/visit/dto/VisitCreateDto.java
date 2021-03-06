package me.study.petclinic.visit.dto;

import me.study.petclinic.owner.entity.Owner;
import me.study.petclinic.pet.entity.Pet;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VisitCreateDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate visitDate;

    @NotNull
    private String description;

//    @NotNull
//    private Owner owner;
//
//    @NotNull
//    private Pet pet;
    @NotNull
    private Long petId;

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }
}
