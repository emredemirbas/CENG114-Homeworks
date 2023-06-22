
public class Location {
	int x;
	int y;
	
	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Location(Location location) {
		this.x = location.x;
		this.y = location.y;
	}
	
	boolean equals(int x, int y) {
		return this.x == x && this.y == y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else {
			if (obj instanceof Location) {
				Location objLocation = (Location)obj;
				return this.x == objLocation.x && this.y == objLocation.y;
			}
			else
				return false;
		}
	}

	@Override
	public String toString() {
		return "P(" + x + ", " + y + ")";
	}
}
