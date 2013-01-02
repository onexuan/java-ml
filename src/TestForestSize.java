import java.io.FileNotFoundException;
import java.io.IOException;


public class TestForestSize {
	public static void main(String[] argv) throws FileNotFoundException, IOException {
		if (argv.length < 4) {
            System.err.println("argument: filestem forestMin forestMax numTrials");
            return;
        }
		
		// data set from filestem
		DataSet d = new DiscreteDataSet(argv[0]);
		// min and max sizes for decision forest
		int forestMin = Integer.parseInt(argv[1]);
		int forestMax = Integer.parseInt(argv[2]);
		// number of trials to be run per forest size
		int numTrials = Integer.parseInt(argv[3]);
		
		System.out.println("Data set contains " + d.numTrainExs + " examples.");
		System.out.println("[forest size], [trialNum], [training error], [cross-set error]");
		for (int i = forestMin; i <= forestMax; i++) {
			double[][] error = TestHarness.computeError(d, numTrials);
			for (int j = 0; j < numTrials; j++) {
				System.out.printf("%d, %d, %f, %f\n", i, j, error[j][0], error[j][1]);
			}
		}
	}
}
