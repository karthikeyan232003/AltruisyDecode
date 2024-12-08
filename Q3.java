import java.util.*;

public class Q3 {
   static int findMinOfMax(int arr[],int N,int K)
   {
      PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>((a,b)->Integer.compare(b,a)); //create a max heap  
      for(int i=0;i<K;i++)
      {
          max_heap.add(arr[i]);
      }
      int min = max_heap.peek();
      int start = 0;
      for(int i=K;i<N;i++)
      {
           max_heap.remove(arr[start]);
           max_heap.add(arr[i]);
           min = Math.min(min,max_heap.peek()); 
           //slide the window
           start++;
      }
      return min;
   }
   public static void main(String ar[])
   {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //length of array 
        int K = sc.nextInt(); //length of sliding window 
        int arr[] = new int[N]; //declaring a array
        for(int i=0;i<N;i++)
        {
            arr[i] = sc.nextInt(); //getting array as input
        }
        //function to find minimum of maximums of all sliding windows of size K  
        System.out.println(findMinOfMax(arr,N,K));
   }
}
