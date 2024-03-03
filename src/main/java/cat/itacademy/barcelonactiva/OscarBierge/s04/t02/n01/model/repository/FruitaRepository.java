package cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.domain.FruitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitaRepository extends JpaRepository<FruitaEntity, Integer> {


}
