//Kerwin Chen
//APCS2 pd1
//HW18 -- QuickSort
//2018-03-13
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
 *Essentially, what you are doing is that you are partiitoning the array into two sections, one sectiont hat is lower and one section that is higher, and then you recursively do that with each of the left and right parts, picking partitions and sorting them into the "biger" and "smaller" piles".
 * 2a. Worst pivot choice and associated runtime: 
 *The worst pivot choice would be to choose really bad paritions where when you sort them into "biger" or "smaller" it is always only one or the other. The runtime would be O(n^2).
 * 2b. Best pivot choice and associated runtime:
 *The best pivot is if you choose the dab center of each of the paritions. The runtime would be O(nlogn).
 * 3. Approach to handling duplicate values in array:
 *I'm not too sure, but I guess you can put it on either side and just continue using the same algorithm.
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
      int tmp = o[x];
      o[x] = o[y];
      o[y] = tmp;
  }

    public static void swap(int[] arr, int x, int y) {

	int temp = arr[x];

	arr[x] = arr[y];

	arr[y] = temp;

    }
    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
  {
      qsort(d,0,d.length-1);
  }

  //you may need a helper method...
    public static void qsort(int[] arr, int left, int right){
	if (left < right){
	    int pvtPos = partition(arr, left, right, (left+right)/2);
	    qsort(arr,left,pvtPos - 1);
	    qsort(arr,pvtPos + 1,right);
	}
    }
     public static int partition(int[] arr, int left, int right, int pvtPos) {
	//System.out.println("\n\tInitial array: " + stringify(arr));	
	int pvtVal = arr[pvtPos];
        swap(arr, pvtPos, right); //move pivot point to end
	int storePos = left;
	for (int i = left; i < right; i ++) {
	    if (arr[i] < pvtVal) {
	        swap(arr,storePos,i);
		storePos += 1;
	    }
	}	
	swap(arr,right,storePos); //move pivot point to final resting place
	//System.out.println("\tArray after function is run: " + stringify(arr))
	return storePos;
    }				    
  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );	
    System.out.println("arr1 after qsort: " );
    printArr(arr1);
    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;
       
    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);





    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );	
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
       
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
   

  }//end main

}//end class QuickSort
