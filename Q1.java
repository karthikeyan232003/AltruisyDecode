import java.util.*;

public class RealEstate {
    static int computeProfit(int prices[],int properties)
    {
      int profit = 0;
      int min_value = Integer.MAX_VALUE;
      for(int i=0;i<properties;i++)
      {
          //compute min value for each interation
          min_value = Math.min(min_value,prices[i]);
          //find the max profit 
          profit = Math.max(profit,prices[i]-min_value);
      }
      //return profit obtained so far   
      return profit;
    }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      //take the number of properties as input  
      int properties = sc.nextInt();
      //create a array of prices  
      int prices[] = new int[properties];
      for(int i=0;i<properties;i++)
      {
           prices[i] = sc.nextInt();
      }
      System.out.println(computeProfit(prices,properties));
  }
}
