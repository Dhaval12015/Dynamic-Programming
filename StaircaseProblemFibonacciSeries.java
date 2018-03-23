import java.util.*;
// This method also stands for numbers without Consecutive ones in Binary.
public class StaircaseProblemFibonacciSeries {
	public static void main(String args[]){
		int a = 1;
		int b = 2;
		int n = 5;
		int arr[] = new int[n];
		arr[0] = 1;
		arr[1] = 2;
		for(int i=2;i<n;i++){
			arr[i] = arr[i-1] + arr[i-2]; 
		}
		System.out.println(arr[n-1]);
	}
}
