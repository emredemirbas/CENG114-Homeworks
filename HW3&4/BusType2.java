package BusTicketSystem;

public class BusType2 extends Bus {

    public BusType2(String busType, String plateNumber, int rowOfMiddleDoor, int numberOfSeats) {
        super(busType, plateNumber, rowOfMiddleDoor, numberOfSeats);
    }

    protected void generateSeats(int rowOfMiddleDoor, int numberOfSeats) {
        setSeatsPerRow(4);
        int seatsPerRow = getSeatsPerRow();
        int rowNumber;
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
                seats[i][1] = new Seat(seatNumber++);
                for (int j = 2; j < seatsPerRow; j++) {
                    seats[i][j] = null;
                }
            } else {
                for (int j = 0; j < seats[i].length; j++) {
                    seats[i][j] = new Seat(seatNumber++);
                }
            }

            for (int j = 0; j < seats[i].length; j++) {
                if (j % 2 == 0 && seats[i][j] != null) {
                    seats[i][j].setNeighborSeat(seats[i][j + 1]);
                } else if (j % 2 == 1 && seats[i][j] != null) {
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
                if (i == 0 && j == 1) {
                    result += "\n";
                }
                if (seats[i][j] == null) {
                    result += "    ";
                } else {
                    result += seats[i][j].toString() + "  ";
                    if (seats[i][j].getSeatNumber()== 9) {
                        result += " ";
                    }
                }
            }
            result += "\n";
        }
        result += "\nNumber Of Empty Seats In This Bus : " + getNumberOfFreeSeats() + "\n" + "-".repeat(52) + "\n";
        return result;
    }

}
