package BusTicketSystem;

public class Passenger {
    private String name;
    private String surname;
    private boolean gender;
    private double balance;
    private int ticketNumber;

    public Passenger(String name, String surname, boolean gender, double balance) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.gender = gender;
        this.ticketNumber = -1; // -1 ---> has no ticket
    }

    public double getBalance() {
        return balance;
    }

    public boolean getGender() {
        return gender;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            balance = 0;
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
