package me.study.petclinic.owner.controller;

import me.study.petclinic.owner.dto.OwnerCreateDto;
import me.study.petclinic.owner.entity.Owner;
import me.study.petclinic.owner.service.OwnerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/owners")
    // Valid : 유효성 검사를 하겠다고 표시
    public Owner createOwner(@Valid OwnerCreateDto ownerCreateDto) {
        // DTO --> Data Transfer Object
        // DAO --> Data Access Object
        return ownerService.createOwnerBy(ownerCreateDto);
    }

    @GetMapping("/owners")
    public List<Owner> getOwners() {    // Java Collection Framework 에 정의된 List
        return ownerService.getOwners();
    }

    @GetMapping("/owners/{id}")
    public Optional<Owner> getOwner(@PathVariable Long id) {
        // Optional : Java 8에 추가된 기능
        // if value is null, wrapping by Optional class
        // null checking 편리하게 하기 위해서!
        return ownerService.getOwner(id);
    }

    // TODO : Update

    // TODO : Delete

}
