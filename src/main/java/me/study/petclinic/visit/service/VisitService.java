package me.study.petclinic.visit.service;

import me.study.petclinic.owner.service.OwnerService;
import me.study.petclinic.pet.entity.Pet;
import me.study.petclinic.pet.service.PetService;
import me.study.petclinic.visit.dto.VisitCreateDto;
import me.study.petclinic.visit.dto.VisitUpdateDto;
import me.study.petclinic.visit.entity.Visit;
import me.study.petclinic.visit.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    private VisitRepository visitRepository;
    private OwnerService ownerService;
    private PetService petService;

    public VisitService(VisitRepository visitRepository, OwnerService ownerService, PetService petService) {
        this.visitRepository = visitRepository;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    public Visit createVisit(VisitCreateDto visitCreateDto) {

        //Optional<Owner> owner = ownerService.getOwner(visitCreateDto.getOwner().getId());
        Optional<Pet> pet = petService.getPet(visitCreateDto.getPetId());
        // null 체크
        Visit visit = new Visit(visitCreateDto.getVisitDate()
                , visitCreateDto.getDescription()
                , pet.get());

        return visitRepository.save(visit);
    }

    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }

    public Optional<Visit> getVisit(Long id) {
        return visitRepository.findById(id);
    }

    public void updateVisit(Long id, VisitUpdateDto visitUpdateDto) {
        Optional<Visit> visit = visitRepository.findById(id);
        visit.get().setDescription(visitUpdateDto.getDescription());
        visit.get().setVisitDate(visitUpdateDto.getVisitDate());
        visitRepository.save(visit.get());
    }

    public void deleteVisit(Long id) {
        visitRepository.deleteById(id);
    }
}
