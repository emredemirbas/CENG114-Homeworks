// Name: Emre
// Surname: Demirbaş
// ID: 21050111069

// Name: Ömer Faruk
// Surname: Özüyağlı
// ID: 21050111047
public class NPuzzleRecursiveSolver {
    protected Board solutionBoard;

    Board solve(Board board) {
        initializeSearch();

        searchSolution(new Board(board));

        return solutionBoard;
    }

    void initializeSearch() {
        solutionBoard = null;
    }

    private void searchSolution(Board boardConfiguration) {
        // base case
        if (boardConfiguration.isFull()) {
            solutionBoard = boardConfiguration;
        }

        // if board is not full search for solution..
        else {
            int columnIndex = boardConfiguration.getFirstEmptyColumn();

            // iterate all rows in the columnIndex'th column
            for (int rowIndex = 0; rowIndex < boardConfiguration.height; rowIndex++) {

                // if square (columnIndex, rowIndex) is not attackable by any other queens in chessboard..
                if (!boardConfiguration.canAttackOtherQueens(columnIndex, rowIndex)) {
                    boardConfiguration.addQueen(columnIndex, rowIndex); // add queen to square (columnIndex, rowIndex)

                    searchSolution(boardConfiguration); // keep searching solution, until our board is full (see base case)

                    // if queen in square (columnIndex, rowIndex) doesn't lead to a possible solution,
                    // remove the queen from columnIndex'th column.
                    if (!boardConfiguration.isFull()) {
                        boardConfiguration.removeQueen(columnIndex);
                    }
                }
            }

        }

    }
}
