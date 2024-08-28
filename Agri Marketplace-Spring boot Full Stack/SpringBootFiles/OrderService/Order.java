package Tayyab.Project.entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private Integer commodityId;
    private Integer userId;
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING, CONFIRMED, DELIVERED
    }

    public Order() {
    }

    public Order(Integer commodityId, Integer userId, Date orderDate, Status status) {
        this.commodityId = commodityId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
