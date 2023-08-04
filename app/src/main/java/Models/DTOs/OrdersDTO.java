package Models.DTOs;

import java.util.Date;

public class OrdersDTO {
    private long orderId;
    private String userName;
    private String description;
    private Date orderedAt;
    private int numberOfTickets;
    private int totalPrice;

    public OrdersDTO(long orderId, String userName, String description, Date orderedAt, int numberOfTickets, int totalPrice) {
        this.orderId = orderId;
        this.userName = userName;
        this.description = description;
        this.orderedAt = orderedAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public long getOrderID() {
        return orderId;
    }

    public void setOrderID(long orderID) {
        this.orderId = orderID;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}