package br.com.yantra.springbootapi.repository;

import br.com.yantra.springbootapi.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long> {
}