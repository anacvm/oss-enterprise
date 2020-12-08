package br.com.yantra.springbootapi.controller;

import br.com.yantra.springbootapi.entity.Portifolio;
import br.com.yantra.springbootapi.repository.PortifolioRepository;
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
public class PortifolioController {

    @Autowired
    private PortifolioRepository portifolioRepository;

    @ApiOperation(value = "Retorna uma lista de tatuadores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de desenhos do portifolio"),
            @ApiResponse(code = 404, message = "Desenhos do portifolio não encontrados"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @RequestMapping(value = "/portifolio", method = RequestMethod.GET, produces = "application/json")
    public List<Portifolio> Get() {
        return portifolioRepository.findAll();
    }

    @RequestMapping(value = "/portifolio/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Portifolio> GetByLogin(@PathVariable(value = "id") Long id) {
        Optional<Portifolio> portifolio = portifolioRepository.findById(id);
        return portifolio.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/portifolio", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Portifolio Post(@Valid @RequestBody Portifolio pessoa) {
        return portifolioRepository.save(pessoa);
    }


    @RequestMapping(value = "/tatuador/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") Long id) {
        Optional<Portifolio> tattoo = portifolioRepository.findById(id);
        if (tattoo.isPresent()) {
            portifolioRepository.delete(tattoo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}