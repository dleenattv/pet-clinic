package me.study.petclinic.pet.service;

import me.study.petclinic.owner.entity.Owner;
import me.study.petclinic.owner.service.OwnerService;
import me.study.petclinic.pet.dto.PetUpdateDto;
import me.study.petclinic.pet.dto.PetCreateDto;
import me.study.petclinic.pet.entity.Pet;
import me.study.petclinic.pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private PetRepository petRepository;
    private OwnerService ownerService;

    public PetService(PetRepository petRepository, OwnerService ownerService) {
        this.petRepository = petRepository;
        this.ownerService = ownerService;
    }

    public Pet createPetBy(PetCreateDto petCreateDto) {
        Owner owner = ownerService.getOwner(petCreateDto.getOwnerId()).get();

        Pet pet = new Pet();
        pet.setName(petCreateDto.getName());
        pet.setGender(petCreateDto.getGender());
        pet.setOwner(owner);

        owner.add(pet);

        return petRepository.save(pet);
    }

    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    public Optional<Pet> getPet(Long id) {
        return petRepository.findById(id);
    }

    public void updatePetBy(Long id, PetUpdateDto petUpdateDto) {
        Optional<Pet> pet = petRepository.findById(id);
        pet.get().setGender(petUpdateDto.getGender());
        pet.get().setName(petUpdateDto.getName());
        petRepository.save(pet.get());
    }

    public void deletePetBy(Long id) {
        petRepository.deleteById(id);
    }
}
