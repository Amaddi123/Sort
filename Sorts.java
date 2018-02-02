/**
 * Write a description of class Sorts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Sorts{
    private long steps;

    /**
     *  Description of Constructor
     *+
     * @param  list  Description of Parameter
     */
    public Sorts(){
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(ArrayList <Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();
        int n = list.size();
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                steps+=3;    
                if (list.get(j) > list.get(j+1))
                {
                    // swap temp and arr[i]
                    steps+=4;
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }

        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(ArrayList <Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();
        int n = list.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++){
            
                // Find the minimum element in unsorted array
                int min_idx = i;
                for (int j = i+1; j < n; j++){
                    steps+=3;
                    if (list.get(j) < list.get(min_idx)){
                        min_idx = j;
                    }
                } // Swap the found minimum element with the first
                    // element
                    steps+=4;
                    int temp = list.get(min_idx);
                    list.set(min_idx,list.get(i));
                    list.set(i, temp);
                
            
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(ArrayList <Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();
        int n = list.size();
        for (int i=1; i<n; ++i)
        {
            steps++;
            int key = list.get(i);
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            steps+=2;
            while (j>=0 && list.get(j) > key)
            {
                steps+=2;
                list.set(j+1,list.get(j));
                j = j-1;
            }
            list.set(j+1, key);
            steps++;
        }
    }
     public void mergeSort(ArrayList <Integer> list, int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if( low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            //System.out.
            //System.out.println("low " + low + "middle " + middle + " high " + high);
            // Sort the left side of the array
            mergeSort(list, low, middle);
            // Sort the right side of the array
            mergeSort(list, middle + 1, high);
            // Combine them both
            merge(list, low, middle, high);
        }
    }

    private void merge(ArrayList <Integer> list, int low, int middle, int high) {
        ArrayList <Integer> helper = new ArrayList <Integer> ();

        int i = low;
        int j = middle + 1;
        // Copy the smallest values from either the left or the right side
        // to the helper
        while (i <= middle || j <= high) {
            
            if (i > middle) {
                helper.add(list.get(j));
                j++;
                steps+=2;
            }
            else if (j > high){
                helper.add(list.get(i));
                i++;
                steps+=2;
            }
            else if (list.get(i) <= list.get(j)) {
                helper.add(list.get(i));
                i++;
                steps+=5;
            } else {
                
                steps+=3;
                helper.add(list.get(j));
                j++;
                steps+=2;
            }
        }
        int m = low;
        // Copy the merged part back into the original list from low to high index
        for(int l = 0; l < helper.size(); l++) {
            list.set(m, helper.get(l));
            m++;
            steps+=2;
        }
    }
    
    public boolean seqSearch (ArrayList <Integer> list, int numb){
        for(int i=0;  i<list.size(); i++){
            if(list.get(i) == numb){
                return true;
            }
        }
        return false;
    }
    
    public boolean binSearch(ArrayList <Integer> list, int num, int first, int last){
        if(last<first){
         return false;   
        }
        else{
           int mid = (first+last)/2;
           if(list.get(mid) == num){
             return true;  
            }
           if(num< list.get(mid)){
             return binSearch(list, num, first, mid-1);
            }
           if(num> list.get(mid)){
             return binSearch(list, num, mid+1, last);
            }
        }     
        return false;
    }
    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount){
        steps = stepCount;
    }
}