package me.study.petclinic.owner.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import me.study.petclinic.pet.entity.Pet;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// JPA로 매핑하려면 Entity 어노테이션이 필요하다. 그래야 인식함
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

    // JAP 어노테이션, 1대 다 관계임을 알려줌. cascade : owner 가 삭제되면 등록된 펫도 함께 삭제됨
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Pet> pets;  // Collection Framework --> list, queue, set, map (set 은 중복을 허용하지 않아서 set 을 씀)

    public Owner() {
    }

    public Owner(String firstName, String lastName, String address, String city, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public void add(Pet pet) {
        if (pets == null) {
            this.pets = new HashSet<>();
        }

        pets.add(pet);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
