package br.com.hostpet.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hostpet.springbootapi.entity.Pet;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    public Optional<Pet> findByNameIgnoreCase(String name);
}