import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

class SortTimer 
{ 


      /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    int partition(double arr[], int low, int high) 
    { 
        double pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                double temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        double temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(double arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
  // Test program 
  public static void main(String args[]) 
  { 
    SortTimer st = new SortTimer(); 
    Scanner myScanner = new Scanner(System.in);  // to read in the number of elements
    
    System.out.println("How many items would you like to sort?"); 
    int numNums = myScanner.nextInt();
    myScanner.close();
    
    if (numNums < 1 || numNums > 1000000) {
      System.out.println("Invalid # please try again from 1 to 1000000");
      return;
    }
    
    System.out.println("Creating a random array of doubles of length " + numNums);
    double arr[] = new double[numNums];
    Random randomno = new Random();
    for (int i = 0; i < numNums; i++) {
      arr[i] = randomno.nextDouble() * 20000000 - 10000000;
    }
    
    // only print out the array if there are less than 10 (for testing)
    if (numNums <= 10) {
      System.out.println(Arrays.toString(arr));
    }
    
    System.out.println("Starting sort"); 
    long startTime = System.nanoTime();                // get the starting time
    st.sort(arr, 0, arr.length - 1);                   // This calls your sort method from the st object on the array arr
    long duration = (System.nanoTime() - startTime);   // calculates how long your method ran
    double durSecs = ((double)duration) / 1000000000;  // converts the time to seconds
    
    if (duration / 1000000 > 0) {
      System.out.println("It took: " + durSecs + " seconds, or " + duration / 1000000 + " MILLIseconds to sort " + numNums + " items");
    } else if (duration / 1000 > 0) {
      System.out.println("It took: " + durSecs + " seconds, or " + duration / 1000 + " MICROseconds to sort " + numNums + " items");
    } else {
      System.out.println("It took: " + durSecs + " seconds, or " + duration + " NANOseconds to sort " + numNums + " items");
    }
    
    // only print out the sorted array if there are less than 10 elements (for testing)
    if (numNums <= 10) {
      System.out.println(Arrays.toString(arr));
    }
  } 
} 