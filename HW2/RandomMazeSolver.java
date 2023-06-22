
public class RandomMazeSolver {

	RandomMazeSolver() {
		
	}
	
	static SolverResult solve(World world, int experimentCount) {
		SolverResult solverResult = new SolverResult();
		// In these lines robots trial number per experiment is determined in direct proportional with maze's area.
		int trialFactor = 100;
		int maximumTrialCount = trialFactor * world.getArea();
		
		// Print . once in 256 experiment to indicate program is working..
		for (int i=0; i<experimentCount; i++) {
			if (i % 256 == 0) {
				System.out.print(".");
			}
			
			executeExperiment(world, maximumTrialCount);
			// If our robot is dead in the end of the experiment, increment deadCount by one.(see SolverResult class)
			if (world.isRobotDead())
				solverResult.incrementDead(); 
			else {
				// If our robot is not dead and succesfully reached to the end point, increment succesCount by one.
				if (world.isRobotAtEnd())
					solverResult.incrementSuccess();
				// If our robot is not dead and couldn't reach to the end point, increment failureCount by one.
				else
					solverResult.incrementFailure();
			}
		}
		
		System.out.println("\n");
		// Print result 
		return solverResult;
	}
	
	static void executeExperiment(World world, int maximumTrialCount) {
		// Restart the world at the beginning of the each experiment
		world.restartTheWorld();
		int count = 0;
		
		// Experiment overs in 3 scenarios:
		// 1) If our robot dies ---> isRobotDead() method in World.java will be helpful.
		// 2) If our robot succesfully reaches to the end. (But we need to be sure that our robot is alive!)
		// 3) If our robot don't die and however can't reach to the end point ---> if count reaches to the maximumTrialCount
		while(count < maximumTrialCount) {
			world.moveRobotRandomly(); // move robot randomly
			if(world.isRobotDead()) {
				break;
			}
			else if(world.isRobotAtEnd()) {
				break;
			}
			count++;
		}
	}
}
