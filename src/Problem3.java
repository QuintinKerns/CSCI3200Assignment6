import java.util.ArrayList;

public class Problem3<E> {
	public static void main(String[] args){
		Problem3 n3 = new Problem3(10, 5);
		Comparable comp = null;
		for (int i = 0; i < n3.k; i++) {
			comp = n3.heap.deleteMin();
			System.out.println("\n" + n3.heap.toString());
		}
		System.out.println("kth element: " + comp.toString());
	}
	
	Integer[] array;
	int k = 0;
	MyBinaryHeap heap = null;
	
	Problem3(int N, int k){
		generateArrayElements(N);
		this.k = k;
		heap = new MyBinaryHeap(array);
	}
	
	private void generateArrayElements(int N) {
		for (int i = 0; i < N; i++) {
			array[i] = (int) Math.random() * N;
		}
	}
}
