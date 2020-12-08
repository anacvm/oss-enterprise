package br.com.yantra.springbootapi.controller;

import br.com.yantra.springbootapi.entity.Tatuador;
import br.com.yantra.springbootapi.repository.TatuadorRepository;
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
public class TatuadorController {

    @Autowired
    private TatuadorRepository tatuadorRepository;

    @ApiOperation(value = "Retorna uma lista de tatuadores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de tatuadores"),
            @ApiResponse(code = 404, message = "Tatuadores não encontrados"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(value = "/tatuador", method = RequestMethod.GET, produces = "application/json")
    public List<Tatuador> Get() {
        return tatuadorRepository.findAll();
    }

    @RequestMapping(value = "/tatuador/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Tatuador> GetByLogin(@PathVariable(value = "id") Long id) {
        Optional<Tatuador> tattoo = tatuadorRepository.findById(id);
        return tattoo.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/tatuador", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Tatuador Post(@Valid @RequestBody Tatuador pessoa) {
        return tatuadorRepository.save(pessoa);
    }


    @RequestMapping(value = "/tatuador/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id) {
        Optional<Tatuador> tattoo = tatuadorRepository.findById(id);
        if (tattoo.isPresent()) {
            tatuadorRepository.delete(tattoo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}