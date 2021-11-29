package keep.learning.repaircarshop.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private Set<Car> cars;
//Set the rest of variables and methods
    public Owner() {
    }

    public Owner(Long id, Set<Car> cars) {
        this.id = id;
        this.cars = cars;
    }
}
