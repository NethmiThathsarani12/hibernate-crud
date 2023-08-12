package lk.ikse.gdse66.dto;

public class OrderDto {

    private String oid;
    private String itemCode;
    private int qty;
    private double unitPrice;
    private String customerId;
    private double total;

    public OrderDto(){

    }

    public OrderDto(String oid, String itemCode, int qty, double unitPrice, String customerId, double total) {
        this.oid = oid;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.customerId = customerId;
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
        return "OrderDto{" +
                "oid='" + oid + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", customerId='" + customerId + '\'' +
                ", total=" + total +
                '}';
    }
}
