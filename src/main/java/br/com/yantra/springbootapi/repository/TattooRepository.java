package br.com.yantra.springbootapi.repository;

import br.com.yantra.springbootapi.entity.Pessoa;
import br.com.yantra.springbootapi.entity.Tattoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TattooRepository extends JpaRepository<Tattoo, Long> {
}