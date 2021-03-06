package me.study.petclinic.pet.controller;

import me.study.petclinic.pet.dto.PetCreateDto;
import me.study.petclinic.pet.dto.PetUpdateDto;
import me.study.petclinic.pet.entity.Pet;
import me.study.petclinic.pet.service.PetService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Pet createPet(@Valid PetCreateDto petCreateDto) {
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
    @PutMapping("/pets/{id}")
    public void updatePetBy(@PathVariable Long id, PetUpdateDto petUpdateDto) {
        petService.updatePetBy(id, petUpdateDto);
    }

    // TODO : Delete
    @DeleteMapping("/pets/{id}")
    public void deletePetBy(@PathVariable Long id) {
        petService.deletePetBy(id);
    }
}
