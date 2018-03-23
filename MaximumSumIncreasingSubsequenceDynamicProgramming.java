
public class MaximumSumIncreasingSubsequenceDynamicProgramming {
	public static void main(String args[]){
		int arr[] = {10,4,6,1,3,8,4,6};
		int n = arr.length;
		int ans[] = new int[n];
		ans[0] = arr[0];
		int ele[] = new int[n];
		ele[0] = -1;
		ans[1] = Math.max(arr[0],arr[1]);
	
	//	System.out.println(ele[0]);
		for(int i=1;i<n;i++){
			int max = Integer.MIN_VALUE;
			int ind = 0;
			for(int j=0;j<i;j++){
				if(arr[j]<=arr[i]){
					int temp = Math.max(ans[j]+arr[i],arr[i]);
					if(temp>max){
					ind = j;
					max = temp;
					}
				}
				else{
					max = arr[i];
					ind = i;
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
		int m = Integer.MIN_VALUE;
		int indx = 0;
		for(int i=0;i<n;i++){
			if(ans[i]>m){
				m = ans[i];
				indx = i;
			}
		}
		System.out.println(m+" "+indx);
		for(int i=indx;i>=0;){
			if(i==ele[i]){System.out.print(arr[i]+" ");break;}
			System.out.print(arr[i]+" ");
			i = ele[i];	
		}
	}
}
