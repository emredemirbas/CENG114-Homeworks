package BusTicketSystem;

public class BusType1 extends Bus {

    public BusType1(String busType, String plateNumber, int rowOfMiddleDoor, int numberOfSeats) {
        super(busType, plateNumber, rowOfMiddleDoor, numberOfSeats);
    }

    protected void generateSeats(int rowOfMiddleDoor, int numberOfSeats) {
        int rowNumber;
        setSeatsPerRow(3);
        int seatsPerRow = getSeatsPerRow();
        int seatNumber = 1;
        if (numberOfSeats % seatsPerRow == 0) {
            rowNumber = numberOfSeats / seatsPerRow;
        } else {
            rowNumber = (numberOfSeats / seatsPerRow) + 1;
        }
        seats = new Seat[rowNumber][seatsPerRow];

        for (int i = 0; i < seats.length; i++) {
            if (i == rowOfMiddleDoor - 1) {
                seats[i][0] = new Seat(seatNumber++);
                for (int j = 1; j < seats[i].length; j++) {
                    seats[i][j] = null;
                }
            } else {
                for (int j = 0; j < seats[i].length; j++) {
                    seats[i][j] = new Seat(seatNumber++);
                }
            }
            for (int j = 0; j < seats[i].length; j++) {
                if (j == 1 && seats[i][j] != null) {
                    seats[i][j].setNeighborSeat(seats[i][j + 1]);
                } else if (j == 2 && seats[i][j] != null) {
                    seats[i][j].setNeighborSeat(seats[i][j - 1]);
                }
            }
        }
    }

    @Override
    public String toString() {
        String result = "Bus Type: " + getBusType() + "\tPlate Number: " + getPlateNumber() + "\n\n";
        for (int j = seats[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < seats.length; i++) {
                if (i == 0 && j == 0) {
                    result += "\n";
                }

                if (seats[i][j] == null) {
                    result += "    ";
                } else {
                    result += seats[i][j].toString() + "  ";
                }
            }
            result += "\n";
        }
        result += "\nNumber Of Empty Seats In This Bus : " + getNumberOfFreeSeats() + "\n" + "-".repeat(52) + "\n";
        return result;
    }

}
