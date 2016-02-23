public class Program {

	/**
	 * Determines whether the absolute value of the difference between d1 and a
	 * value in arr is less than eps
	 * 
	 * @param arr
	 *            an array of doubles
	 * @param eps
	 *            some double
	 * @param d1
	 *            some double
	 * @return true if there is an element d2 in the array such that |d1 - d2| <
	 *         eps, otherwise returns false
	 */
	public static boolean contains(double[] arr, double eps, double d1) {
		if (arr.length == 0) {
			throw new IllegalArgumentException();
		}
		for (double val : arr) {
			if (Math.abs(d1 - val) < eps) {
				return true;
			}
		}
		return false;
	}

	/**
	 * evaluates and returns the value of the first argument raised to the power 
	 * of the second argument recursively
	 * 
	 * @param x
	 *            an integer
	 * @param y
	 *            a non-negative integer
	 * @return the integer value of x^y
	 */

	public static int fastExp(int x, int y) {
		if (y == 0) {
			return 1;
		}
		int val;
		if (y % 2 == 0) {
			val = fastExp(x, y / 2); 
			return val * val;
		} else {
			val = fastExp(x, (y - 1) / 2);
			return x * val * val;
		}
	}

	/**
	 * returns a list of all possible pairs of integers in the array parameter.
	 * Throws exception if arr is null.
	 * 
	 * @param arr
	 *            an integer array
	 * @return a pair list with all possible integer pairs
	 */
	public static Pair[] allPairs(int[] arr) {
		if (arr.length == 0) {
			throw new IllegalArgumentException();
		}
		Pair[] pairArr = new Pair[arr.length * arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				pairArr[(i * 3) + j] = new Pair(arr[i], arr[j]);
			}
		}
		return pairArr;
	}

	/**
	 * returns a new string with each each element in arr added n times
	 * consecutively. Throws exception if arr is null.
	 * 
	 * @param arr
	 *            a String array
	 * @param n
	 *            int number of replicates of each String element
	 * @return
	 */
	public static String concatAndReplicateAll(String[] arr, int n) {
		if (arr.length == 0) {
			throw new IllegalArgumentException();
		}
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < n; j++) {
				str += arr[i];
			}
		}
		return str;
	}

	/**
	 * returns the mode of the bounded integer array Throws exception if arr is
	 * null.
	 * 
	 * @param arr
	 *            an integer array containing integers from 0-100 inclusive
	 * @return the mode integer
	 */
	public static int boundedMode(int[] arr) {
		if (arr.length == 0) {
			throw new IllegalArgumentException();
		}
		int[] auxArr = new int[101];
		for (int i = 0; i < arr.length; i++) {
			auxArr[arr[i]]++;
		}
		int mode = arr[0];
		for (int j = 0; j < auxArr.length; j++) {
			if (auxArr[mode] < auxArr[j]) {
				mode = j;
			}
		}
		return mode;
	}

	/**
	 * returns the mode of the unbounded integer array Throws exception if arr
	 * is null.
	 * 
	 * @param arr
	 *            an integer array
	 * @return the mode integer
	 */
	public static int unboundedMode(int[] arr) {
		if (arr.length == 0) {
			throw new IllegalArgumentException();
		}
		int counts = 0;
		int maxCounts = 0;
		int item;
		int mode = arr[0];
		for (int i = 0; i < arr.length; i++) {
			item = arr[i];
			for (int j = 0; j < arr.length; j++) {
				if (item == arr[j]) {
					counts++;
				}
			}
			if (counts > maxCounts) {
				maxCounts = counts;
				mode = item;
			}
			counts = 0;
		}
		return mode;
	}

	public static void main(String[] args) {
		/*
		 * // contains double[] arr5 = { 2.0, 5.0, 6.0, 7.0 };
		 * System.out.println(contains(arr5, 1.0, 1.0));
		 */
		// pow
		System.out.println(Math.pow(2, 10) + " " + fastExp(2, 10));
		/*
		 * // pairArr int[] arr1 = { 1, 2, 3 }; Pair[] pair1 = allPairs(arr1);
		 * for (int i = 0; i < pair1.length; i++) { System.out.println("(" +
		 * pair1[i].getFst() + ", " + pair1[i].getSnd() + ")"); } // concat
		 * String[] arr2 = { "hello", "world", "!" };
		 * System.out.println(concatAndReplicateAll(arr2, 3)); // mode int[]
		 * arr3 = { 0, 5, 2, 3, 3, 5, 5, 9 }; System.out.println("mode: " +
		 * boundedMode(arr3)); System.out.println("mode: " +
		 * unboundedMode(arr3));
		 */
	}

}
