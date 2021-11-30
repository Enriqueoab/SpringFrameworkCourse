package keep.learning.repaircarshop.domain;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String brand;
    private String plate;
    private int miles;
    private String problemToFix;
    private Date registerDate;

    //CascadeType.ALL propagates all operations from a parent to a child entity.
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    //Set the parameter which is going to be set with the other entity
    // id value(Shared primary key)
    @PrimaryKeyJoinColumn
    private CarId carId;

    public Car() {
    }


    public Car(Long id, String brand, String plate, int miles, String problemToFix, Date registerDate, CarId carId) {
        this.id = id;
        this.brand = brand;
        this.plate = plate;
        this.miles = miles;
        this.problemToFix = problemToFix;
        this.registerDate = registerDate;
        this.carId = carId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public String getProblemToFix() {
        return problemToFix;
    }

    public void setProblemToFix(String problemToFix) {
        this.problemToFix = problemToFix;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id != null ? id.equals(car.id) : car.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", plate='" + plate + '\'' +
                ", miles=" + miles +
                ", problemToFix='" + problemToFix + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
