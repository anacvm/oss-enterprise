package br.com.yantra.springbootapi.controller;

import br.com.yantra.springbootapi.entity.Preco;
import br.com.yantra.springbootapi.repository.PrecoRepository;
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
public class PrecoController {

    @Autowired
    private PrecoRepository precoRepository;

    @ApiOperation(value = "Retorna uma lista de tattoos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de Precos"),
            @ApiResponse(code = 404, message = "Preco não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(value = "/preco", method = RequestMethod.GET, produces = "application/json")
    public List<Preco> Get() {
        return precoRepository.findAll();
    }

    @RequestMapping(value = "/preco/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Preco> GetByLogin(@PathVariable(value = "id") Long id) {
        Optional<Preco> preco = precoRepository.findById(id);
        return preco.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/preco", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Preco Post(@Valid @RequestBody Preco preco) {
        return precoRepository.save(preco);
    }


    @RequestMapping(value = "/preco/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id) {
        Optional<Preco> preco = precoRepository.findById(id);
        if (preco.isPresent()) {
            precoRepository.delete(preco.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}