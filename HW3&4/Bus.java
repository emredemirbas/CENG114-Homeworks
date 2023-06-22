package BusTicketSystem;

public abstract class Bus {
    private String busType;
    private String plateNumber;
    private final int numberOfSeats;
    private int seatsPerRow;
    protected Seat[][] seats;

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public String getBusType() {
        return busType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Bus(String busType, String plateNumber, int rowOfMiddleDoor, int numberOfSeats) {
        this.busType = busType;
        this.plateNumber = plateNumber;
        this.numberOfSeats = numberOfSeats;
        generateSeats(rowOfMiddleDoor, numberOfSeats);
    }

    protected abstract void generateSeats(int rowOfMiddleDoor, int numberOfSeats);

    public void sellSeat(Passenger passenger, double rowChoiceFactor) {
        if (getNumberOfFreeSeats() == 0) {
            System.out.println("You can't buy a seat since all of the seats are occupied!");
            return;
        }
        int rowIndex = (int) (rowChoiceFactor * (seats.length - 1));
        boolean isCurrentSeatSold = false;
        // Note that generateNewRowIndex method returns -1 if all the seats in bus is occupied.
        // Therefore, we need to be sure that rowIndex mustn't be equal to -1.
        while (!isCurrentSeatSold && rowIndex != -1) {
            for (int j = 0; j < seats[rowIndex].length; j++) {
                Seat currentSeat = seats[rowIndex][j];
                if (currentSeat != null && currentSeat.getTicket() == null) { // if currentSeat is not a middle door and currentSeat is not sold yet
                    // We sell currentSeat to single passenger in some cases:
                    // 1) if currentSeat has no neighborSeat (in other words, if currentSeat is a single seat)
                    // 2) if currentSeat has neighborSeat and this neighborSeat is empty
                    // 3) if currentSeat has neighborSeat and neighborSeat is sold to
                    // a passenger with same gender with the passenger in parameter
                    if ((currentSeat.getNeighborSeat() == null) ||
                            (currentSeat.getNeighborSeat().getTicket() == null) ||
                            (currentSeat.getNeighborSeat().getTicket().getPassenger().getGender() == passenger.getGender())) {
                        currentSeat.setTicket(new Ticket(passenger));
                        if (passenger.getBalance() >= currentSeat.getTicket().getPrice()) {
                            passenger.withdraw(currentSeat.getTicket().getPrice());
                            passenger.setTicketNumber(currentSeat.getSeatNumber());
                            isCurrentSeatSold = true;
                        } else {
                            currentSeat.setTicket(null);
                            passenger.setTicketNumber(-1);
                            System.out.println("Passenger " + passenger + " has no enough balance!");
                            System.out.println("Balance of " + passenger + ": " + passenger.getBalance() + "\n");
                            return;
                        }
                        break;
                    }
                }
            }
            // if we couldn't sell seat to passenger in current row,
            // we update rowIndex by using generateNewRowIndex method.
            if (!isCurrentSeatSold) {
                rowIndex = generateNewRowIndex(rowIndex);
            }
        }
    }

    private int generateNewRowIndex(int rowIndex) {
        for (int i = 1; i < seats.length; i++) {
            int leftRowIndex = Math.max(rowIndex - i, 0); // leftIndex shouldn't be less than 0, in order not to get ArrayIndexOutOfBoundsException
            int rightRowIndex = Math.min(rowIndex + i, seats.length - 1); // and rightIndex shouldn't be greater than seats.length - 1
            if (!isRowFullyOccupied(rightRowIndex)) {
                return rightRowIndex;
            } else if (!isRowFullyOccupied(leftRowIndex)) {
                return leftRowIndex;
            }
        }
        return -1; // return -1 if there is no available row in bus
    }

    private int countEmptySeatsInAnyRow(int rowIndex) {
        int count = 0;
        for (int j = 0; j < seats[rowIndex].length; j++) {
            if (seats[rowIndex][j] != null && seats[rowIndex][j].getTicket() == null) {
                count++;
            }
        }
        return count;
    }

    private boolean isRowFullyOccupied(int rowIndex) {
        return countEmptySeatsInAnyRow(rowIndex) == 0;
    }

    public void sellSeat(Passenger[] passengers, double rowChoiceFactor) {
        if (getNumberOfFreeSeats() == 0) {
            System.out.println("You can't buy a seat since all of the seats are occupied!");
            return;
        }
        for (Passenger passenger : passengers) {
            int rowIndex = (int) (rowChoiceFactor * (seats.length - 1));
            int sittableSeatIndex = -1;
            int upperSeatSearchLimit = (int) (seats.length / 2);
            int count = 0;
            //Search an empty seat until reaching to the upper limit.
            while (count != upperSeatSearchLimit) {
                int rightSittableSeatIndex = findSittableSeatInRow(passengers, passenger, Math.min(rowIndex + count, seats.length - 1));
                int leftSittableSeatIndex = findSittableSeatInRow(passengers, passenger, Math.max(rowIndex - count, 0));
                if (rightSittableSeatIndex == -1 && leftSittableSeatIndex == -1) {
                    count++;
                } else {
                    if (rightSittableSeatIndex != -1) {
                        sittableSeatIndex = rightSittableSeatIndex;
                        rowIndex = rowIndex + count;
                        break;
                    } else {
                        sittableSeatIndex = leftSittableSeatIndex;
                        rowIndex = rowIndex - count;
                        break;
                    }
                }
            }
            if (sittableSeatIndex != -1) {
                Seat currentSeat = seats[rowIndex][sittableSeatIndex];
                currentSeat.setTicket(new Ticket(passenger));
                if (passenger.getBalance() >= currentSeat.getTicket().getPrice()) {
                    passenger.withdraw(currentSeat.getTicket().getPrice());
                    passenger.setTicketNumber(currentSeat.getSeatNumber());
                } else {
                    currentSeat.setTicket(null);
                    passenger.setTicketNumber(-1);
                    System.out.println("Passenger " + passenger + " has no enough balance!");
                    System.out.println("Balance of " + passenger + ": " + passenger.getBalance() + "\n");
                }
            }
        }
    }

    private boolean isPassengerInArray(Passenger[] passengers, Passenger passenger) {
        for (Passenger p : passengers) {
            if (p == passenger) {
                return true;
            }
        }
        return false;
    }

    private int findSittableSeatInRow(Passenger[] passengers, Passenger passenger, int rowIndex) {
        // if rowIndex'th row is fully empty, it is sittable.
        if (countEmptySeatsInAnyRow(rowIndex) == seatsPerRow) {
            return 0;
        }
        // if rowIndex'th row is fully occupied, it is not sittable.
        else if (isRowFullyOccupied(rowIndex)) {
            return -1;
        }
        // if rowIndex'th row is neither fully occupied or fully empty...
        else {
            for (int i = 0; i < seats[rowIndex].length; i++) {
                // if seat is available:
                if (seats[rowIndex][i].isAvailable()) {
                    Seat neighborSeat = seats[rowIndex][i].getNeighborSeat();
                    // if current seat has no neighbor seats so if it's a single seat:
                    if (neighborSeat == null) {
                        return i;
                    }
                    //otherwise:
                    else {
                        // if it's neighbor seat is empty:
                        if (neighborSeat.isAvailable()) {
                            return i;
                        } else {
                            //if it's not empty but the person who sits there has the same gender with new passenger or
                            //they are in the same passenger group.
                            if (isPassengerInArray(passengers, neighborSeat.getTicket().getPassenger()) ||
                                    neighborSeat.getTicket().getPassenger().getGender() == passenger.getGender()) {
                                return i;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int getNumberOfFreeSeats() {
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] != null && seats[i][j].getTicket() == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public void makeSeatFree(Seat seat) {
        seat.setTicket(null);
    }

    public void makeSeatFree(Ticket ticket) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j].getTicket() == ticket) {
                    seats[i][j].setTicket(null);
                    return;
                }
            }
        }
    }

    public void makeSeatFree(Passenger passenger) {
        makeSeatFree(passenger.getTicketNumber());
    }

    public void makeSeatFree(int ticketNumber) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] != null && seats[i][j].getTicket() != null && seats[i][j].getSeatNumber() == ticketNumber) {
                    seats[i][j].setTicket(null);
                    return;
                }
            }
        }
    }

    public boolean isTicketNumberInArray(int ticketNumber, int[] ticketNumbers) {
        for (int i = 0; i < ticketNumbers.length; i++) {
            if (ticketNumber == ticketNumbers[i]) {
                return true;
            }
        }
        return false;
    }

    public void makeSeatFree(int[] ticketNumbers) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] != null && seats[i][j].getTicket() != null) {
                    if (isTicketNumberInArray(seats[i][j].getSeatNumber(), ticketNumbers)) {
                        seats[i][j].setTicket(null);
                    }
                }
            }
        }
    }

    @Override
    public abstract String toString();
}
