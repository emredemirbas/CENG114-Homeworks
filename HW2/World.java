import java.util.Random;

public class World {
	static Random rand = new Random();
	public final int initialLifeCount = 100; // no need to add a setter method for initialLifeCount since it's final.
	// we don't want to allow user to change robotLifeCount, robot, start and end.
	// Therefore, these fields must be private.
	private int robotLifeCount;
	private Location robot = null;
	private Location start;
	private Location end;
	double holeProbability;
	double wallProbability;
	
	public Location getRobot() {
		return robot;
	}

	enum CellType {
		Wall, Corridor;

		// Walls are symbolized with "#" while corridors are symbolized with "."
		@Override
		public String toString() {
			return this == Wall ? "#" : ".";
		}

		// Create a random CellType according to the wallProbability
		static CellType random(double wallProbability) {
			return (rand.nextDouble() < wallProbability ? Wall : Corridor);
		}
	}

	// two-dimensional CellType array which shows if there is wall or corridor in
	// the maze.
	final CellType[][] cells;

	// the constructor which initializes the world
	World(int width, int height, double holeProbability, double wallProbability, Location start, Location end) {
		this.holeProbability = holeProbability;
		this.wallProbability = wallProbability;
		this.start = start;
		this.end = end;

		cells = new CellType[height][width];

		restartTheWorld();
	}

	void restartTheWorld() {
		createRandomMaze(holeProbability, wallProbability);
		rebootTheRobot();
	}

	// createRandomMaze method basically fills the cells[][] with Corridor, Wall.
	// Note that if nothing is assigned to cells[a][b], default value will be
	// assigned. (which is null)
	// so if cells[a][b] = null ---> it means that there is a hole in P(a, b) in our
	// maze.
	void createRandomMaze(double holeProbability, double wallProbability) {
		for (int y = 0; y < cells.length; y++) {
			CellType[] row = cells[y];

			for (int x = 0; x < row.length; x++) {
				if (start.equals(x, y) || end.equals(x, y))
					row[x] = CellType.Corridor;
				else {
					if (rand.nextDouble() > holeProbability)
						row[x] = CellType.random(wallProbability);
					else
						row[x] = null;
				}
			}
		}
	}

	// this method returns the area of the maze
	int getArea() {
		return cells.length * cells[0].length;
	}

	// this method re-assigns initial life count to the robots life count.
	// and sets robot's location to the starting location (which is (0, 0)).
	void rebootTheRobot() {
		robotLifeCount = initialLifeCount;

		this.robot = new Location(start);
	}

	boolean isRobotDead() {
		return (robotLifeCount <= 0);
	}

	// note that it is important to remember if we are looking to find -
	// our robot is at the starting location or not, we have to make sure that -
	// our robot is alive.
	boolean isRobotAtStart() {
		return !isRobotDead() && robot.equals(start);
	}

	boolean isRobotAtEnd() {
		return !isRobotDead() && robot.equals(end);
	}

	// returns the CellType of the robots current location.
	CellType robotAt() {
		return robot == null ? null : cells[robot.y][robot.x];
	}

	void moveRobotRandomly() {
		// since rand.nextInt(-1,2) returns an integer value in interval [-1,2),
		// possible values for deltaX and deltaY (separately) : -1, 0, 1
		// this do-while loop creates deltaX and deltaY until their sum of the absolute
		// values equal to 1.
		// So possible ordered pairs for (deltaX, deltaY): (1,0), (0,1), (-1,0), (0,-1)
		// Therefore, it means that this robot can only move in one dimension at a time
		// interval. (either in x or y direction.)
		int deltaX, deltaY;
		do {
			deltaX = rand.nextInt(-1, 2); //
			deltaY = rand.nextInt(-1, 2);

		} while (Math.abs(deltaX) + Math.abs(deltaY) != 1);

		int newX = robot.x + deltaX; // assign newX
		int newY = robot.y + deltaY; // assign newY

		// Note that since we are working with two-dimensional CellType array,
		// we need to prevent ArrayOutOfBounds exception.
		// hence, newX must be in interval [0, width).
		// newY must be in interval [0, length).

		// Since a robot can't move through the wall,
		// we also need to be sure that there is no wall
		// at the new possible location of the robot. ---> cells[newY][newX] !=
		// CellType.Wall
		boolean canMove = (newY >= 0 && newY < cells.length && newX >= 0 && newX < cells[newY].length
				&& cells[newY][newX] != CellType.Wall);
		if (canMove) {
			// if our robot can move to the new location, assign new X and new Y.
			robot.x = newX;
			robot.y = newY;
		
			// If our robot encounters with a hole, decrement robotLifeCount by 1.
			if (cells[robot.y][robot.x] == null) {
				robotLifeCount--;
			}
		}
	}

	// toString() method basically returns the map of the maze.
	// Since Strings are immutable, we could use StringBuilder
	// and finally in order to return a String result, we used sb.toString().

	// S ---> Start
	// E ---> End
	// * ---> Position of the robot
	// . ---> Corridor
	// # ---> Wall
	// X ---> Hole

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int y = 0; y < cells.length; y++) {
			CellType[] row = cells[y];

			for (int x = 0; x < row.length; x++) {
				if (robot != null && robot.equals(x, y))
					sb.append("*");
				else {
					if (row[x] == null)
						sb.append("x");
					else {
						if (start.equals(x, y))
							sb.append("S");
						else if (end.equals(x, y))
							sb.append("E");
						else
							sb.append(row[x]);
					}
				}
			}
			sb.append("\n");
		}

		return sb.toString();
	}

}
