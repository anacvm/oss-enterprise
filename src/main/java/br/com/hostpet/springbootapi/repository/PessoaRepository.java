package br.com.hostpet.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hostpet.springbootapi.entity.Pessoa;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    public Optional<Pessoa> findByEmailIgnoreCase(String email);
    public Optional<Pessoa> findByEmailIgnoreCaseAndSenhaIgnoreCase(String email, String senha);
}