package keep.learning.repaircarshop.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarId {

    @Id
    @Column(name = "car_id") //Set the column name to use it below
    private Long id;

    @OneToOne
    @MapsId //Maps the "Car" id with this class id(car_id)
    @JoinColumn(name = "car_id") //Set the column name to use in the mapping
    private Car car;

    @ManyToMany(mappedBy = "carsId")
    private Set<Worker> worker;

    @ManyToOne()
    private Owner owner;

    public CarId() {

    }

}
