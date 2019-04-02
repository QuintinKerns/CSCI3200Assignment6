import java.util.Random;

class Problem4 {
    public static void main(String[] args) {
    	int n = 10;
    	int k = 7;
    	System.out.println(k + "th largest: " + kLargest(n,k));
    }

    public static <E> E kLargest(int n, int k) {
        Integer[] item = new Integer[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) item[i] = r.nextInt(50) + 1;

        System.out.println("Numbers for heap: ");

        for (int i = 0; i < item.length; i++) System.out.println(item[i] + " ");

        MyBinaryHeap <Integer> myHeap = new MyBinaryHeap <> (item);
        
        System.out.println("Heap: " + myHeap.toString());

        for (int i = 1; i < k; i++) myHeap.deleteMax();

        return (E) myHeap.deleteMax();
    }
}