
public class SolverResult {
	// In the very end of our program, when all of the experiments are done,
	// since we don't want user to manipulate these attributes,
	// we encapsulated these attributes and didn't add setter methods for them.
	private int deadCount = 0;
	private int failureCount = 0;
	private int successCount = 0;
	
	int getTotal() {
		return deadCount + failureCount + successCount;
	}
	
	void incrementDead() {
		deadCount++;
	}
	
	
	int getDeadCountCount() {
		return deadCount;
	}
	
	// Note about the methods that returns percentage for the attributes:
	// Any percentage must be greater or equal than 0.
	// to prevent mistakes in our program, we need to check if sum of the each attributes of this class
	// is greater than 0. If it's not, we must return 0.0, which is the minimum value that any percentage may get.
	double getDeadPercentage() {
		int total = getTotal();
		
		return total > 0 ? (100.0 * deadCount) / total : 0.0;
	}	
	
	void incrementFailure() {
		failureCount++;
	}
	
	int getFailureCount() {
		return failureCount;
	}
	
	double getFailurePercentage() {
		int total = getTotal();
		
		return total > 0 ? (100.0 * failureCount) / total : 0.0;
	}	
	
	void incrementSuccess() {
		successCount++;
	}
	
	int getSuccessCount() {
		return successCount;
	}	
	
	double getSuccessPercentage() {
		int total = getTotal();
		
		return total > 0 ? (100.0 * successCount) / total : 0.0;
	}	
	
	@Override
	public String toString() {
		return  "Dead percentage: " + getDeadPercentage() + "%\n" +
				"Failure percentage: " + getFailurePercentage() + "%\n" +
				"Success percentage: " + getSuccessPercentage() + "%";
	}
}
