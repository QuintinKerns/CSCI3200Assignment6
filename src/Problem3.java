import java.util.Random;

class Problem3 {
    public static void main(String[] args) {
    	System.out.println("kth smallest: " + kSmallest(10,0));
    }

    public static <E> E kSmallest(int n, int k) {
        Integer[] item = new Integer[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) item[i] = r.nextInt(50) + 1;

        System.out.println("Numbers for heap: ");

        for (int i = 0; i < item.length; i++) System.out.println(item[i] + " ");

        MyBinaryHeap <Integer> myHeap = new MyBinaryHeap <> (item);

        for (int i = 1; i < k; i++) myHeap.deleteMin();

        return (E) myHeap.deleteMin();
    }
}
