package keep.learning.repaircarshop.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "worker")
    private Set<CarId> carsId;

//Set the rest of the variables and methods
}
