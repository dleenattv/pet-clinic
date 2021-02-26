package me.study.petclinic.pet.service;

import me.study.petclinic.pet.dto.PetCreateDto;
import me.study.petclinic.pet.entity.Pet;
import me.study.petclinic.pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet createPetBy(PetCreateDto petCreateDto) {

        Pet pet = new Pet(petCreateDto.getName()
                        , petCreateDto.getGender());
        return petRepository.save(pet);
    }

    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPet(Long id) {
        return petRepository.findById(id);
    }
}
