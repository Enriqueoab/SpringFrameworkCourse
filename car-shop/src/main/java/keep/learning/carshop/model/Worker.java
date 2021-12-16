package keep.learning.carshop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Worker extends PersonDetails{

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

    private Date startDate;
    private int salary;

    @Column(columnDefinition = "varchar(12) default 'Full time'")
    private String contract;

    public Worker() {
    }

    public Worker(Long id, Set<CarId> carsId, PersonDetails personDetails, Date startDate, int salary, String contract) {
        this.id = id;
        this.carsId = carsId;
        this.personDetails = personDetails;
        this.startDate = startDate;
        this.salary = salary;
        this.contract = contract;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        return id != null ? id.equals(worker.id) : worker.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", personDetails=" + personDetails +
                ", startDate=" + startDate +
                ", salary=" + salary +
                ", contract='" + contract + '\'' +
                '}';
    }
}
