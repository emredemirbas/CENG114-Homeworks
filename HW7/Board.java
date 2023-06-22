// Emre Demirbaş
// ID : 21050111069

import java.util.*;

public class Board {
    private final static int X = 0;
    private final static int Y = 1;
    private final static int neighbors[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public final int size;
    private final Set<Integer> pieces = new TreeSet<>();
    private final List<Integer> list = new ArrayList<>();

    Board(int size) {
        this.size = size;
    }

    Board(Board board) {
        this.size = board.size;
        this.pieces.addAll(board.pieces);
    }

    Board(int size, int[] xs, int[] ys) {
        this.size = size;

        for (int i = 0; i < xs.length; i++) {
            addPiece(xs[i], ys[i]);
        }
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    public boolean hasPiece(int x, int y) {
        if (isInside(x, y)) {
            int key = y * size + x;
            return pieces.contains(key);
        } else return false;
    }

    public void addPiece(int x, int y) {
        if (isInside(x, y)) {
            int key = y * size + x;
            pieces.add(key);
        }
    }

    public void removePiece(int x, int y) {
        if (isInside(x, y)) {
            int key = y * size + x;
            pieces.remove(key);
        }
    }

    public Collection<Board> getSuccessors() {
        Collection<Board> successors = new HashSet<>();
        addProperNeighborsToList();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i) % size;
            int y = list.get(i) / size;
            Board successor = new Board(this);
            successor.addPiece(x, y);
            successors.add(successor);
        }
        return successors;
    }

    private int[][] allNeighborsOfXY(int x, int y) {
        int[][] neighborsArray = new int[neighbors.length][neighbors[0].length];
        for (int i = 0; i < neighborsArray.length; i++) {
            neighborsArray[i][X] = neighbors[i][X] + x;
            neighborsArray[i][Y] = neighbors[i][Y] + y;
        }
        return neighborsArray;
    }

    private boolean hasNeighborPiece(int x, int y) {
        if (hasPiece(x, y)) {
            return false;
        }
        int[][] neighborsOfXY = allNeighborsOfXY(x, y);
        for (int i = 0; i < neighborsOfXY.length; i++) {
            int neighborX = neighborsOfXY[i][X];
            int neighborY = neighborsOfXY[i][Y];
            if (isInside(neighborX, neighborY) && hasPiece(neighborX, neighborY)) {
                return true;
            }
        }
        return false;
    }

    private void addProperNeighborsToList() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (hasNeighborPiece(x, y)) {
                    int key = y * size + x;
                    list.add(key);
                }
            }
        }
    }

    @Override
    public int hashCode() {
        return pieces.hashCode() + size;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Board) {
            Board anotherBoardObject = (Board) o;
            return this.size == anotherBoardObject.size && this.pieces.equals(anotherBoardObject.pieces);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (hasPiece(x, y)) sb.append("#");
                else sb.append(".");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
