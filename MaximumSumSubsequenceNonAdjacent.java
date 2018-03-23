import java.util.*;

public class MaximumSumSubsequenceNonAdjacent {
	public static void main(String args[]){
		int arr[] = {1,4,1,4,2,1};
		int n = arr.length;
		int ans[] = new int[n];
		ans[0] = arr[0];
		int ele[] = new int[n];
		ele[0] = -1;
		ele[1] = -1;
		ans[1] = Math.max(arr[0],arr[1]);
	
	//	System.out.println(ele[0]);
		for(int i=2;i<n;i++){
			int max = Integer.MIN_VALUE;
			int ind = 0;
			for(int j=0;j<i-1;j++){
				int temp = Math.max(ans[j]+arr[i],ans[i-1]);
				if(temp>max){
					ind = j;
					max = temp;
				}
			}
			ans[i] = max;
			ele[i] = ind;
		}
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.print(ans[i]+" ");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.print(ele[i]+" ");
		}
		System.out.println();
		for(int i=n-1;i>=0;){
			System.out.print(arr[i]+" ");
			i = ele[i];	
		}
	}
}
