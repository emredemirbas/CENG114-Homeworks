package BusTicketSystem;

public class Seat {

    private int seatNumber;
    private Ticket ticket;
    private Seat neighborSeat;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    protected boolean isAvailable() {
        return ticket == null;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
        if (ticket != null) {
            ticket.setTicketNumber(seatNumber);
        }
    }

    public Seat getNeighborSeat() {
        return neighborSeat;
    }

    public void setNeighborSeat(Seat neighborSeat) {
        this.neighborSeat = neighborSeat;
    }

    @Override
    public String toString() {
        if (this.ticket == null) {
            return "" + seatNumber;
        } else if (ticket.getPassenger().getGender() == true) {
            return (seatNumber <= 9) ? "M" : "M ";
        } else if (ticket.getPassenger().getGender() == false) {
            return (seatNumber <= 9) ? "F" : "F ";
        } else {
            return "";
        }
    }

}
