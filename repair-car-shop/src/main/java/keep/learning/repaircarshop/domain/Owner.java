package keep.learning.repaircarshop.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "owner")
    private Set<CarId> carsId;

    @OneToOne(mappedBy = "owner")
    @PrimaryKeyJoinColumn
    private PersonDetails personDetails;
    private String address;
    private String city;
    private int phoneNumber;

    public Owner() {
    }

    public Owner(Long id, Set<CarId> carsId, PersonDetails personDetails, String address, String city, int phoneNumber) {
        this.id = id;
        this.carsId = carsId;
        this.personDetails = personDetails;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CarId> getCarsId() {
        return carsId;
    }

    public void setCarsId(Set<CarId> carsId) {
        this.carsId = carsId;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        return id != null ? id.equals(owner.id) : owner.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", personDetails=" + personDetails +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
