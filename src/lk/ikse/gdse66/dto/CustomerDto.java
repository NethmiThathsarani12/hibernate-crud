package lk.ikse.gdse66.dto;

public class CustomerDto {

    private  String id;
    private String name;
    private String address;
    private int tp;

    public CustomerDto(){

    }

    public CustomerDto(String id, String name, String address, int tp) {
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
        return "CustomerDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tp=" + tp +
                '}';
    }
}
