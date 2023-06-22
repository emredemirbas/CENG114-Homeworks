package BusTicketSystem;

public class Ticket {
    private double price;
    private Passenger passenger;
    private int ticketNumber;

    public Ticket(Passenger passenger) {
        this.passenger = passenger;
        price = 200;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return "Passenger : " + passenger;
    }
}
