package me.study.petclinic.owner.service;

import me.study.petclinic.owner.dto.OwnerCreateDto;
import me.study.petclinic.owner.dto.OwnerUpdateDto;
import me.study.petclinic.owner.entity.Owner;
import me.study.petclinic.owner.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner createOwnerBy(OwnerCreateDto ownerCreateDto) {

        Owner owner = new Owner(
                ownerCreateDto.getFirstName(),
                ownerCreateDto.getLastName(),
                ownerCreateDto.getAddress(),
                ownerCreateDto.getCity(),
                ownerCreateDto.getTelephone()
        );

        // 1. 우리는 query 를 작성하지 않았다. --> JPA 가 해줌
        // 2. 우리는 DB Table 을 만들지 않았다. --> JPA, DB : H2
        return ownerRepository.save(owner); // 알아서 INSERT 쿼리 생성, 실행해줌
    }

    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> getOwner(Long id) {
        return ownerRepository.findById(id);
    }
}

// ORM : Object Relational Mapping : 자바 객체와 DB 테이블을 매핑시켜줌
    // 1. 객체를 생성한다.
    // 2. JPA 한테 이 객체를 저장하라고 요청한다.
    // 3. JPA 는 Query 를 생성한다.
    // 4. JPA 는 Query 를 실행한다.

// JPA : Java Persistence API
    // : ORM 을 하기 위한 Java 표준 스펙
    // JPA 가 ORM 을 해준다.
