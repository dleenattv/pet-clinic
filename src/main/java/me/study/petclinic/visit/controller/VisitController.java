package me.study.petclinic.visit.controller;

import me.study.petclinic.visit.dto.VisitCreateDto;
import me.study.petclinic.visit.dto.VisitUpdateDto;
import me.study.petclinic.visit.entity.Visit;
import me.study.petclinic.visit.service.VisitService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class VisitController {

    private VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @PostMapping("/visits")
    public Visit createVisit(@Valid VisitCreateDto visitCreateDto) {
        return visitService.createVisit(visitCreateDto);
    }

    @GetMapping("/visits")
    public List<Visit> getVisits() {
        return visitService.getVisits();
    }

    @GetMapping("/visits/{id}")
    public Optional<Visit> getVisit(@PathVariable Long id) {
        return visitService.getVisit(id);
    }

    @PutMapping("/visits/{id}")
    public void updateVisit(@PathVariable Long id, VisitUpdateDto visitUpdateDto) {
        visitService.updateVisit(id, visitUpdateDto);
    }

    @DeleteMapping("/visits/{id}")
    public void deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
    }
}
