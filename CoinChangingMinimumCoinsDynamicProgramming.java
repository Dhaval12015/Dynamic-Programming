
public class CoinChangingMinimumCoinsDynamicProgramming {
	public static void main(String args[]){
		int sum = 13;
		int arr[] = {7,2,3,6};
		int n = arr.length;
		int ans[] = new int[sum+1];
		ans[0] = 0;
		
		for(int i=1;i<=sum;i++) ans[i] = 1000;
		
		for(int i=0;i<n;i++){
			for(int j=1;j<=sum;j++){
				if(arr[i]<=j){
				//	System.out.println(j+" "+arr[i]);
					ans[j] = Math.min(ans[j],1+ans[j-arr[i]]);
				}
			}
		}
		for(int i=0;i<=sum;i++){
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		System.out.print("Minimum coin needed for "+sum+" is " + ans[sum]);
	}
}
