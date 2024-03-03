package cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.domain.FruitaEntity;
import cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService implements iFruitaService{

    private final FruitaRepository fruitaRepository; //nos permite utilizar los metodos JPA

    @Autowired //inyectamos dependencia
    public FruitaService(FruitaRepository fruitaRepository) {
        this.fruitaRepository = fruitaRepository;
    }

    //add
    public FruitaEntity addFruita(FruitaEntity fruita){
        return fruitaRepository.save(fruita);
    }
    //update
    public FruitaEntity updateFruita(int id, String nouNom, int novaQuantitatKg){
        Optional<FruitaEntity> fruitaCorrecta = fruitaRepository.findById(id);

        if (fruitaCorrecta.isPresent()){
            FruitaEntity fruitaPerUpdate = fruitaCorrecta.get();
            fruitaPerUpdate.setNom(nouNom);
            fruitaPerUpdate.setQuantitatQuilos(novaQuantitatKg);
            fruitaRepository.save(fruitaPerUpdate);
            return fruitaPerUpdate;
        } else {
            return null; //podriamos crear una excepcion personalizada para una fruitanotfound
        }
    }
    //Delete
    public void deleteFruita(int id){
        fruitaRepository.deleteById(id);
    }
    //getOne
    public Optional<FruitaEntity> getOneFruita(int id){
        return fruitaRepository.findById(Math.toIntExact(id));
    }
    //getAll
    public List<FruitaEntity> getAllFruites(){
        return fruitaRepository.findAll();
    }

}
