import java.util.*;
public class Minimumjumptoreachend {
	public static void main(String args[]){
		int arr[] = {2,3,1,1,2,4,2,0,1,1};
		int n = arr.length;
		int ans[] = new int[n];
		ans[0] = 0;
		ans[1] = 1;
		int ele[] = new int[n];
		ele[0] = -1;
		ele[1] = 0;
	for(int i=2;i<n;i++){
		int min = Integer.MAX_VALUE;
		int ind = 0;
		for(int j=0;j<i;j++){
			int temp = 0;
			int diff = i-j;
			if(arr[j]<diff){
				continue;
			}
			else{
				temp = ans[j] + 1;
				if(temp<min){
					min = temp;
					ind = j;
				}
			}
		}
		ans[i] = min;
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
	System.out.println("Maximum jump to reach till the end are : " + ans[n-1]);
	System.out.print("And the Elements are : ");
	for(int i=n-1;i>=0;){
		System.out.print(arr[i]+" ");
		i = ele[i];
	}
	}

}
