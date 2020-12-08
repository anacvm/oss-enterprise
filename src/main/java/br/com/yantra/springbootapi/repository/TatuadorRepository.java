package br.com.yantra.springbootapi.repository;

import br.com.yantra.springbootapi.entity.Tatuador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TatuadorRepository extends JpaRepository<Tatuador, Long> {
}