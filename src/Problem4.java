import java.util.Random;

class Problem4 {
	public static void main(String[] args) {
		int k = 7;
		System.out.println(k + "th largest element: " + deleteMax(k));
	}

	@SuppressWarnings("unchecked")
	public static Integer deleteMax(int k) {
		int[] N = new int[10];
		Integer[] kvals = new Integer[k];

		for (int i = 0; i < N.length; i++) {
			N[i] = (int) (Math.random() * k * 10);
		}

		for (int i = 0; i < k; i++) {
			kvals[i] = N[i];
		}

		MyBinaryHeap lrgstKVals = new MyBinaryHeap<Integer>(kvals);

		int heapMin = (int) lrgstKVals.findMin();

		for (int i = k; i < N.length; i++) {
			if (N[i] > heapMin) {
				lrgstKVals.deleteMin();
				lrgstKVals.insert(N[i]);
				heapMin = (int) lrgstKVals.findMin();
			}
		}

		System.out.println("Largest " + k + " numbers in the Array stored in the Heap:");
		System.out.println(lrgstKVals);
		return (Integer) lrgstKVals.findMin();
	}
}