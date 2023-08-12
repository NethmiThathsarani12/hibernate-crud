package lk.ikse.gdse66.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    private String oid;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "qty")
    private int qty;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "total")
    private double total;

    public Order(){

    }

//    public Order(String oid, String itemCode, int qty, double unitPrice, String customerId, double total) {
//        this.oid = oid;
//        this.itemCode = itemCode;
//        this.qty = qty;
//        this.unitPrice = unitPrice;
//        this.customerId = customerId;
//        this.total = total;
//    }

    public Order(String oid, String customerId, String itemCode, int qty, double unitPrice, double total) {
        this.oid = oid;
        this.customerId = customerId;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", customerId='" + customerId + '\'' +
                ", total=" + total +
                '}';
    }
}
