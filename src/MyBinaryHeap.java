public class MyBinaryHeap <E extends Comparable<? super E>> {
	private int defaultSize = 4;
	private int currentSize = 0;
	private E[] heap;
	private int opCount = 0;
	
	public void printOpCount(){
		System.out.println("  N" + currentSize + " OpCount: " + opCount);
	}
	
	public int getOpCount(){
		return opCount;
	}
	
	private void opCount(int n){
		opCount += n;
	}

	public MyBinaryHeap()
	{
		heap = (E[])new Comparable[defaultSize];
		opCount(3);
	}
	public MyBinaryHeap(int size)
	{
		heap = (E[])new Comparable[this.nextSize(size)];
		opCount(3);
	}
	public MyBinaryHeap(E[] items)
	{
		heap = (E[])new Comparable[this.nextSize(items.length)];
		this.addAll(items);
		opCount(3);
	}

	public void addAll(E[] items)
	{
		//make sure there is room for all new items
		if(currentSize+items.length >= heap.length) //a >= b is a > b or a == b; opcount of 3
		{
			growArray(this.nextSize(currentSize+items.length));
			opCount(4);
		}
		opCount(4);

		for(E item : items)//copy new items in order
		{
			currentSize++;
			heap[currentSize] = item;
			opCount(3);
		}
		opCount(items.length);

		this.buildHeap();//fix heap order
		opCount(1);
	}
	private void buildHeap()
	{
		for(int i = currentSize >> 1; i > 0; i--)
		{
			percolateDown(i);
			opCount(4);
		}
		opCount(2);
	}

	public void insert(E val)
	{
		//make sure we have room for new item
		if(currentSize+1 >= heap.length)
		{
			growArray();
			opCount(1);
		}
		opCount(4);
		currentSize++;
		heap[0] = val;//temporary storage
		percolateUp(currentSize);
		opCount(4);
	}
	private void percolateUp(int pos)
	{
		//pos>>1 = pos/2 - getting to parent of empty space
		for(;heap[pos>>1].compareTo(heap[0]) > 0;pos = pos>>1)
		{
			heap[pos] = heap[pos>>1];//move parent down a level
			opCount(7);
		}
		heap[pos] = heap[0];//take value from initial insert and put in correct pos
		opCount(1);
	}

	public E findMin()
	{
		opCount(2);
		return (currentSize > 0)?heap[1]:null;
	}
	public E deleteMin()
	{
		if(currentSize > 0)
		{
			E temp = heap[1];

			heap[1] = heap[currentSize];//moved last value to top
			currentSize--;//decrease size
			percolateDown(1);//move top value down to final position

			opCount(7);
			return temp;
		}
		else
		{
			opCount(2);
			return null;//no items in heap
		}
	}
	private void percolateDown(int pos)
	{
		int firstChild = pos << 1;//pos * 2
		E temp = heap[pos];
		opCount(3);
		for(;pos<<1 <= currentSize; pos = firstChild, firstChild = pos<<1)
		{
			opCount(9);
			if(firstChild+1 <= currentSize)//there is a second child
			{
				opCount(3);
				if(heap[firstChild].compareTo(heap[firstChild+1]) > 0)
				{
					firstChild++;
					opCount(2);
				}
			}
			//firstChild is now the index of the smaller child
			if(temp.compareTo(heap[firstChild]) > 0)
			{
				heap[pos] = heap[firstChild];//move child up to parent and continue
				opCount(3);
			}
			else
			{
				opCount(3);
				break;//stop loop because we found correct position for temp
			}
		}
		heap[pos] = temp;
		opCount(1);
	}

	public String toString()
	{
		String output = "  Heap Size:"+heap.length+"\n  ";
		for(int i = 1; i <= currentSize; i++)
		{
			output += heap[i]+",";
		}
		return output;
	}

	public boolean isEmpty()
	{
		opCount(2);
		return currentSize == 0;
	}
	public void makeEmpty()
	{
		opCount(1);
		currentSize = 0;
	}

	private void growArray()//O(N)
	{
		opCount(2);
		growArray(heap.length << 1);//heap.length * 2
	}
	private void growArray(int size)
	{
		//new array that is twice as big
		E[] newArr = (E[])new Comparable[size];
		//Move values to new array
		for(int i = 1; i <= currentSize; i++)//O(N)
		{
			newArr[i] = heap[i];
			opCount(6);
		}
		//System.out.println(Arrays.toString(newArr));
		heap = newArr;//replace small array with new one
		opCount(4);
	}
	private int nextSize(int size)
	{
		opCount(5);
		return 1 << (Integer.toBinaryString(size).length() + 1);
	}
	
	public E deleteMax() {
		if(currentSize > 0)
		{
//			E[] S = new E[currentSize];
//			for (int i = 0; i < k; i++){
//				
//			}
			return null;
		}
		else
		{
			opCount(2);
			return null;//no items in heap
		}
	}
}
