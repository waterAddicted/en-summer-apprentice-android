package Models.DTOs;
public class EventsDtO{
    private String name;
    private String description;
    private int imageName; // Câmp pentru numele imaginii

    private String TicketCategory;

    private int numberOfTickets;
    public EventsDtO(String name, String description, int imageName,String ticketCategory,int numberOfTickets) {
        this.name = name;
        this.description = description;
        this.imageName = imageName;
        this.TicketCategory = ticketCategory;
        this.numberOfTickets = numberOfTickets;
    }

    // Getters și setters pentru a accesa și seta valorile câmpurilor.

    public String getEventName() {
        return name;
    }

    public void setEventName(String name) {
        this.name = name;
    }

    public String getEventDescription() {
        return description;
    }

    public void setEventDescription(String description) {
        this.description = description;
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