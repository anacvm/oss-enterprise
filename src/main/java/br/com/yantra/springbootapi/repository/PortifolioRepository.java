package br.com.yantra.springbootapi.repository;

import br.com.yantra.springbootapi.entity.Portifolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortifolioRepository extends JpaRepository<Portifolio, Long> {
}