package cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.domain.FruitaEntity;
import cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitaController {

    private final FruitaService fruitaService;

    @Autowired
    public FruitaController(FruitaService fruitaService) {
        this.fruitaService = fruitaService;
    }

    @PostMapping("/add")
    public ResponseEntity<FruitaEntity> addFruita(@RequestBody FruitaEntity fruita) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(fruitaService.addFruita(fruita));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FruitaEntity> updateFruita(@PathVariable int id,
                                                     @RequestParam String nouNom,
                                                     @RequestParam int novaQuantitatKg){
        FruitaEntity updatedFruita = fruitaService.updateFruita(id, nouNom, novaQuantitatKg);
        if (updatedFruita != null) {
            return ResponseEntity.ok(updatedFruita);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FruitaEntity> deleteFruitaById(@PathVariable int id) {
        Optional<FruitaEntity> fruitaGetOne = fruitaService.getOneFruita(id);
        if(fruitaGetOne.isEmpty()) {
            return new ResponseEntity<FruitaEntity>(HttpStatus.NOT_FOUND);
        }else {
            fruitaService.deleteFruita(id);
            return new ResponseEntity<FruitaEntity>(HttpStatus.OK);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FruitaEntity> getFruitaById(@PathVariable int id) {
        Optional<FruitaEntity> fruitaGetOne = fruitaService.getOneFruita(id);
        if(fruitaGetOne.isEmpty()) {
            return new ResponseEntity<FruitaEntity>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<FruitaEntity>(fruitaGetOne.get(),HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FruitaEntity>> getAllFruites(){
        if(fruitaService.getAllFruites().size()==0) {
            return new ResponseEntity<List<FruitaEntity>>(HttpStatus.NO_CONTENT);
        }else
            return new ResponseEntity<List<FruitaEntity>>(fruitaService.getAllFruites(), HttpStatus.OK);
    }
}


