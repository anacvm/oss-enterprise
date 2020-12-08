package br.com.yantra.springbootapi.repository;

import br.com.yantra.springbootapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    public Optional<Pessoa> findByEmailIgnoreCase(String email);
    public Optional<Pessoa> findByEmailIgnoreCaseAndSenhaIgnoreCase(String email, String senha);
}