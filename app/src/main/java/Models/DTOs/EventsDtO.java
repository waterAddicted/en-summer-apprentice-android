package Models.DTOs;
public class EventsDtO{
    private String eventName;
    private String eventDescription;
    private int imageName; // Câmp pentru numele imaginii

    private String TicketCategory;

    private int numberOfTickets;
    public EventsDtO(String eventName, String eventDescription, int imageName,String ticketCategory,int numberOfTickets) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.imageName = imageName;
        this.TicketCategory = ticketCategory;
        this.numberOfTickets = numberOfTickets;
    }

    // Getters și setters pentru a accesa și seta valorile câmpurilor.

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String name) {
        this.eventName = name;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String description) {
        this.eventDescription = description;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    public String getTicketCategory() {
        return TicketCategory;
    }

    public void setTicketCategory(String ticketCategory){
        this.TicketCategory = ticketCategory;
    }

    public int getNumberOfTickets()
    {
        return this.numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets)
    {
        this.numberOfTickets=numberOfTickets;
    }
}