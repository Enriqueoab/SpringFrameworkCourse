package keep.learning.repaircarshop.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private Set<CarId> carsId;

    //CascadeType.ALL propagates all operations from a parent to a child entity.
    @OneToOne(mappedBy = "worker", cascade = CascadeType.ALL)
    //Set the parameter which is going to be set with the other entity
    // id value(Shared primary key)
    @PrimaryKeyJoinColumn
    private PersonDetails personDetails;
}
