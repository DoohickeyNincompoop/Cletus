public class QuickSortTester
{
    public static void main(String[] args){
	for(int i = 1; i < 200000; i += 100){
	    long past,current;
	    int[] x = QuickSort.buildArray(i,i);
	    QuickSort.shuffle(x);
	    past = System.nanoTime();
	    QuickSort.qsort(x);
	    current = System.nanoTime();
	    System.out.print(i);
	    System.out.print(" , ");
	    System.out.println(current - past);
	}
    }

}
