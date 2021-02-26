package me.study.petclinic.pet.controller;

import me.study.petclinic.pet.dto.PetCreateDto;
import me.study.petclinic.pet.entity.Pet;
import me.study.petclinic.pet.service.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PetController {
    // TODO : CRUD 만들기
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // TODO : Create
    @PostMapping("/pets")
    public Pet createPet(PetCreateDto petCreateDto) {
        return petService.createPetBy(petCreateDto);
    }
    // TODO : Read
    @GetMapping("/pets")
    public List<Pet> getPets() {
        return petService.getPets();
    }

    @GetMapping("/pets/{id}")
    public Optional<Pet> getPetBy(@PathVariable Long id) {
        return petService.getPet(id);
    }

    // TODO : Update

    // TODO : Delete
}
