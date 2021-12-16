package keep.learning.carshop.model;

import javax.persistence.*;

@Entity
public class PersonDetails {

    @Id
    @Column(name = "person_id") //Set the column name to use it below
    private Long id;

    @OneToOne
    @MapsId //Maps the "Car" id with this class id(person_id)
    @JoinColumn(name = "person_id") //Set the column name to use in the mapping
    private Owner owner;

    @OneToOne
    @MapsId
    @JoinColumn(name = "person_id")
    private Worker worker;

    private String firstName;
    private String lastName;

    public PersonDetails() {
    }

    public PersonDetails(Long id, Owner owner, Worker worker, String firstName, String lastName) {
        this.id = id;
        this.owner = owner;
        this.worker = worker;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDetails that = (PersonDetails) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "id=" + id +
                ", owner=" + owner +
                ", worker=" + worker +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
