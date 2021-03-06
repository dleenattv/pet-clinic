package me.study.petclinic.pet.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import me.study.petclinic.owner.entity.Owner;
import me.study.petclinic.visit.entity.Visit;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Character gender;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Owner owner;

    // JAP 어노테이션, 1대 다 관계임을 알려줌. cascade : pet 이 삭제되면 등록된 예약도 삭제
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Visit> visits;

    public Pet() {
    }

    public Pet(String name, Character gender) {
        this.name = name;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
