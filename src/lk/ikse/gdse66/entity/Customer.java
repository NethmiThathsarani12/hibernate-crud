package lk.ikse.gdse66.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_tp")
    private int tp;

    public Customer(){

    }

    public Customer(String id, String name, String address, int tp) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tp = tp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tp=" + tp +
                '}';
    }
}
