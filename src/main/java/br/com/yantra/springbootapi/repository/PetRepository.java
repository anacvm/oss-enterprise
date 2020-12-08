package br.com.yantra.springbootapi.repository;

import br.com.yantra.springbootapi.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    public Optional<Pet> findByNameIgnoreCase(String name);
}