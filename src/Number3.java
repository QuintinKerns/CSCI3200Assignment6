
public class Number3<E implements Comparable> {
	public static void main(String[] args){
		
	}
	
	E[] array = null;
	int k = 0;
	MyBinaryHeap heap = null;
	
	Number3(int N, int k){
		array = new E[](N);
		this.k = k;
		heap = new MyBinaryHeap(array);
	}
}
