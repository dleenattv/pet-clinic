package me.study.petclinic.visit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import me.study.petclinic.pet.entity.Pet;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate visitDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    @JsonBackReference
    private Pet pet;

    public Visit() {
    }

    public Visit(LocalDate visitDate, String description, Pet pet) {
        this.visitDate = visitDate;
        this.description = description;
        this.pet = pet;
    }

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


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
