package keep.learning.carshop.model;

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

    @ManyToMany
    private Set<Worker> worker;

    @ManyToOne()
    private Owner owner;

    public CarId() {

    }

    public CarId(Long id, Car car, Set<Worker> worker, Owner owner) {
        this.id = id;
        this.car = car;
        this.worker = worker;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Worker> getWorker() {
        return worker;
    }

    public void setWorker(Set<Worker> worker) {
        this.worker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarId carId = (CarId) o;

        return id != null ? id.equals(carId.id) : carId.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CarId{" +
                "id=" + id +
                ", car=" + car +
                ", owner=" + owner +
                '}';
    }
}
