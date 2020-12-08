package br.com.yantra.springbootapi.controller;

import br.com.yantra.springbootapi.entity.Tattoo;
import br.com.yantra.springbootapi.repository.TattooRepository;
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
public class TattooController {

    @Autowired
    private TattooRepository tattooRepository;

    @ApiOperation(value = "Retorna uma lista de tattoos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de tattoos"),
            @ApiResponse(code = 404, message = "Tattoo não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(value = "/tattoo", method = RequestMethod.GET, produces = "application/json")
    public List<Tattoo> Get() {
        return tattooRepository.findAll();
    }

    @RequestMapping(value = "/tattoo/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Tattoo> GetByLogin(@PathVariable(value = "id") Long id) {
        Optional<Tattoo> tattoo = tattooRepository.findById(id);
        return tattoo.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/tattoo", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Tattoo Post(@Valid @RequestBody Tattoo pessoa) {
        return tattooRepository.save(pessoa);
    }


    @RequestMapping(value = "/tattoo/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id) {
        Optional<Tattoo> tattoo = tattooRepository.findById(id);
        if (tattoo.isPresent()) {
            tattooRepository.delete(tattoo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}