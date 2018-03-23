
public class LongestIncreasingSubsequence {
	public static void main(String args[]){
		int arr[] = {2,5,1,8,3};
		int n = arr.length;
		int ans[] = new int[n];
		ans[0] = 1;
		for(int i=1;i<n;i++){
			int max = 0;
			for(int j=0;j<i;j++){
				if(arr[j]<arr[i]){
					if(ans[j]>max){
						max = ans[j];
					}
				}
			}
			if(max==0)ans[i] = 1;
			else
			ans[i] = max+1;
		}
		int m = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(ans[i]>m) m = ans[i];
		}
		System.out.println("LongestIncreasingSubsequence : "+m);
	}
}
