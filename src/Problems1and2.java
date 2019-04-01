import java.util.ArrayList;

public class Problems1and2 {
	public static void main(String[] args){
		MyBinaryHeap heap = new MyBinaryHeap();
		Integer[] items = new Integer[]{10,12,1,14,6,5,8,15,3,9,7,4,11,13,2};
		
		System.out.println("Add one by one:");
		for (int i : items){
			heap.insert(i);
			System.out.println(heap.toString());
		}
		
		System.out.println("----------");
		System.out.println("Add all at once:");
		MyBinaryHeap heap2 = new MyBinaryHeap(items);
		System.out.println(heap2.toString());
		
		System.out.println("----------");
		System.out.println("DeleteMin:");
		for (int i = 0; i < 4; i++){
			heap.deleteMin();
			System.out.println(heap.toString());
		}
	}
}
