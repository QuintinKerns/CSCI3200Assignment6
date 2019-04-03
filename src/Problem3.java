import java.util.Random;

class Problem3 {
    public static void main(String[] args) {
    	System.out.println("kth smallest: " + kSmallest(10,0));
    }

    public static <E> E kSmallest(int n, int k) {
        Integer[] items = new Integer[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) items[i] = r.nextInt(50) + 1;

        System.out.println("Numbers for heap: ");

        for (int i = 0; i < items.length; i++) System.out.println(items[i] + " ");

        MyBinaryHeap <Integer> myHeap = new MyBinaryHeap <> (items);

        for (int i = 1; i < k; i++) myHeap.deleteMin();

        return (E) myHeap.deleteMin();
    }
}
