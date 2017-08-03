public class PrimeGen {
	private static boolean[] crossOut;
	private static int[] result;

	public static int[] generatePrimeNumbers(final int maxVal) {
		if(maxVal < 2) return int[0];
		init(maxVal);
		crossOut();
		save();
		return result;
	}

	private static void init(int maxVal) {
		crossOut = new boolean[maxVal + 1];
		for(int i=2; i<crossOut.length; i++) {
			crossOut[i] = false;
		}
	}

	private static void crossOut() {
		int limit = getLimit();
		for (int i=2; i<=limit; i++) {
			if(notCrossed(i)) {
				crossOutOf(i);
			}
		}
	}

	private static int getLimit() {
		return Integer.valueOf(Math.sqrt(crossOut.length)).intValue();
	}

	private static void crossOutOf(int i) {
		for(int mult=2*i; mult<crossOut.length; mult+=i) {
			crossOut[mult] = true;
		}
	}

	private static boolean notCrossed(int i) {
		return false == crossOut[i];
	}

	private static void save() {
		result = new int[getResultSet()];
		for(int j=0, i=2; i<crossOut.length; i++) {
			if(notCrossed(i)) {
				result[j++] = i;
			}
		}
	}

	private static int getResultSet() {
		int count = 0;
		for(int i=2; i<crossOut.length; i++) {
			if(notCrossed(i)) {
				count++;
			}
		}
		return count;
	}
}