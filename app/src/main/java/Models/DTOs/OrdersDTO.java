package Models.DTOs;

import java.util.Date;

public class OrdersDTO {
    private long orderID;
    private String customerName;
    private String ticketCategoryDescription;
    private Date orderedAt;
    private int numberOfTickets;
    private int totalPrice;

    public OrdersDTO(long orderID, String customerName, String ticketCategoryDescription, Date orderedAt, int numberOfTickets, int totalPrice) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.ticketCategoryDescription = ticketCategoryDescription;
        this.orderedAt = orderedAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTicketCategoryDescription() {
        return ticketCategoryDescription;
    }

    public void setTicketCategoryDescription(String ticketCategoryDescription) {
        this.ticketCategoryDescription = ticketCategoryDescription;
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