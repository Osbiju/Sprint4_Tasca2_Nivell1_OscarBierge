package cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.domain.FruitaEntity;

import java.util.List;
import java.util.Optional;

public interface iFruitaService {
    FruitaEntity addFruita(FruitaEntity fruita);
    FruitaEntity updateFruita(int id, String nouNom, int novaQuantitatKg);
    void deleteFruita(int id);
    Optional<FruitaEntity> getOneFruita(int id);
    List<FruitaEntity> getAllFruites();
}
