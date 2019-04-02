import java.util.Scanner;

public class Problem5 {
	@SuppressWarnings({"rawtypes", "unchecked"}) // Goodbye annoying underlines
	public static void main(String[] args){
		MyBinaryHeap heap;
		int oboCount, allCount;
		int[] N = new int[]{25, 50, 75, 100, 200, 300, 400, 500, 1000, 10000};
		Integer[] rands;
		for (int n : N){
			heap = new MyBinaryHeap(n);
			rands = new Integer[n];
			
			// Generate random nums
			System.out.println("Generating random numbers...");
			String output = "  ";
			for (int i = 0; i < n; i++){
				rands[i] = (int) (Math.random() * n);
				output += rands[i] + ", ";
			}
			System.out.println(output + "\n");
			
			// Build heap by inserting one by one
			System.out.println("Building heap one by one...");
			for (int m : rands){
				heap.insert(m);
			}
			System.out.println(heap);
			heap.printOpCount();
			oboCount = heap.getOpCount();
			
			// Build heap using buildHeap
			System.out.println("Building heap all at once...");
			heap = new MyBinaryHeap(rands);
			System.out.println(heap);
			heap.printOpCount();
			allCount = heap.getOpCount();
			
			// Test results
			System.out.println(oboCount > allCount ? "One By One took " + (oboCount - allCount) + " fewer operations than All at Once" : "All at Once took " + (allCount - oboCount) + " fewer operations than One By One");
			
			// Wait to run next test
			System.out.println(n != N[N.length-1] ? "Press any key to run next test...":"");
			new Scanner(System.in).nextLine();
			System.out.println("----------------------------------------");
		}
	}
	
	
}
