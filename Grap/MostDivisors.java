package Grap;
import java.util.ArrayList;
import java.util.List;

/**
 * This program finds an integer between 1 and 10000 that has the largest number
 * of divisors. It prints out the maximum number of divisors and an integer that
 * has that many divisors.
 */

public class MostDivisors {
	class NewThread extends Thread {
		private int n;
		private int k;

		public NewThread(int n, int k) {
			this.n = n;
			this.k = k;
		}

		public void run() {
			list.add(findMaxDivisors(1000000 / n * k, 1000000 / n * (k + 1)));
		}
	}

	List<int[]> list = new ArrayList<int[]>();

	public int[] findMaxDivisors(int first, int end) {
		int[] arr = { 1, 1 };
		for (int N = 1 + first; N <= end; N++) {
			int D; // A number to be tested to see if it's a divisor of N.
			int divisorCount = 0;
			for (D = 1; D <= Math.sqrt(N); D++) { // Count the divisors of N.
				if (N % D == 0)
					divisorCount++;
			}

			if (divisorCount > arr[1]) {
				arr[1] = divisorCount;
				arr[0] = N;
			}
		}
		return arr;
	}

	public void executeK(int k) throws Exception {
		List<NewThread> listThread = new ArrayList<NewThread>(k);
		for (int i = 0; i < k; i++)
			listThread.add(new NewThread(k, i));

		for (NewThread th : listThread)
			th.start();
		for (NewThread th : listThread)
			th.join();
	}

	public static void main(String[] args) throws Exception {
		double timeStart = System.currentTimeMillis();
		MostDivisors md = new MostDivisors();
		md.executeK(10);
		int[] max = md.list.get(0);
		for (int[] arr : md.list)
			if (arr[1] > max[1])
				max = arr;
		System.out.println("Among integers between 1 and 1000000,");
		System.out.println("The maximum number of divisors is " + max[1]);
		System.out.println("A number with " + max[1] + " divisors is " + max[0]);
		double timeEnd = System.currentTimeMillis();
		System.out.println("time with 10 threads = " + (timeEnd - timeStart));
		System.out.println("--------------------------------------------------");
		timeStart = System.currentTimeMillis();
		md.executeK(1);
		max = md.list.get(0);
		for (int[] arr : md.list)
			if (arr[1] > max[1])
				max = arr;
		timeEnd = System.currentTimeMillis();
		System.out.println("Among integers between 1 and 1000000,");
		System.out.println("The maximum number of divisors is " + max[1]);
		System.out.println("A number with " + max[1] + " divisors is " + max[0]);
		System.out.println("time with 1 thread = " + (timeEnd - timeStart));
	} // end main()
}