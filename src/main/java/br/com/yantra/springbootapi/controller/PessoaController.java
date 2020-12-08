package br.com.yantra.springbootapi.controller;

import br.com.yantra.springbootapi.entity.Login;
import br.com.yantra.springbootapi.entity.Pessoa;
import br.com.yantra.springbootapi.repository.PessoaRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
            @ApiResponse(code = 404, message = "Pessoa não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET, produces = "application/json")
    public List<Pessoa> Get() {
        return pessoaRepository.findAll();
    }

    @RequestMapping(value = "/pessoa/{login}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Pessoa> GetByLogin(@PathVariable(value = "login") String login) {
        Optional<Pessoa> pessoa = pessoaRepository.findByEmailIgnoreCase(login);
        return pessoa.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Pessoa Post(@Valid @RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    @RequestMapping(value = "/pessoa/{login}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "login") String login) {
        Optional<Pessoa> pessoa = pessoaRepository.findByEmailIgnoreCase(login);
        if (pessoa.isPresent()) {
            pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pessoa/logar/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Pessoa> logar(@Valid @RequestBody Login login) {
        Optional<Pessoa> pessoaLogada = pessoaRepository.findByEmailIgnoreCaseAndSenhaIgnoreCase(login.getLogin(), login.getSenha());
        return pessoaLogada.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}