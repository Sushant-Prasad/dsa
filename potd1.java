//Given an array Arr of N positive integers and an integer K, find K largest elements
// from the array.  The output elements should be printed in decreasing order
import java.util.*;

public class potd1 {
    // JAVA CODE

    int[] kLargest(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
	        pq.add(arr[i]);
	    }
	    for(int i=k;i<n;i++){
	        if(pq.peek()<arr[i]){
	            pq.poll();
	            pq.add(arr[i]);
	        }
	    }
	    int ans[]=new int[k];
	    int i=k-1;
	    while(pq.size()!=0){
	        ans[i--]=pq.peek();
	        pq.poll();
	    }
	    return ans;
    }
