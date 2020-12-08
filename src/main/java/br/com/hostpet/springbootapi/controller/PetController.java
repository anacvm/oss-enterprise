package br.com.hostpet.springbootapi.controller;

import br.com.hostpet.springbootapi.entity.Login;
import br.com.hostpet.springbootapi.entity.Pet;
import br.com.hostpet.springbootapi.repository.PetRepository;
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
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @ApiOperation(value = "Retorna uma lista de pets")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pets"),
            @ApiResponse(code = 404, message = "Pet não encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(value = "/pets", method = RequestMethod.GET, produces = "application/json")
    public List<Pet> Get() {
        return petRepository.findAll();
    }

    @RequestMapping(value = "/pet/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Pet> GetByLogin(@PathVariable(value = "name") String name) {
        Optional<Pet> pet = petRepository.findByNameIgnoreCase(name);
        return pet.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/pet", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Pet Post(@Valid @RequestBody Pet pet) {
        return petRepository.save(pet);
    }


    @RequestMapping(value = "/pet/{name}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "name") String name) {
        Optional<Pet> pet = petRepository.findByNameIgnoreCase(name);
        if (pet.isPresent()) {
            petRepository.delete(pet.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}