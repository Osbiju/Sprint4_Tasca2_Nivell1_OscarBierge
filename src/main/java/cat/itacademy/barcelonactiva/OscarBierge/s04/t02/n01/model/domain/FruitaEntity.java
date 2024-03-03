package cat.itacademy.barcelonactiva.OscarBierge.s04.t02.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "FruitaDB")
public class FruitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "quantitatQuilos")
    private int quantitatQuilos;

    public FruitaEntity(){}

    public FruitaEntity(String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    } no volem permetre setejar el id, ja que es genera auto

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantitatQuilos() {
        return quantitatQuilos;
    }

    public void setQuantitatQuilos(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
    }


    @Override
    public String toString() {
        return "FruitaEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantitatQuilos=" + quantitatQuilos +
                '}';
    }
}
