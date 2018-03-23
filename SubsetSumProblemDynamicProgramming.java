
public class SubsetSumProblemDynamicProgramming {
	public static void main(String args[]){
		int arr[] = {2,3,7,8,10};
		int sum = 11;
		int n  = arr.length;
		boolean T[][] = new boolean[n+1][sum+1];
		for(int i=0;i<n+1;i++){
			T[i][0] = true;
		}
		for(int i=1;i<sum+1;i++){
			T[0][i] = false;
		}
		for(int i=1;i<n+1;i++){
			for(int j=1;j<sum+1;j++){
				if(j<arr[i-1]){
					T[i][j] = T[i-1][j];
				}
				else{
						T[i][j] = T[i-1][j] | T[i-1][j - arr[i-1]];
					}
			}
		}
		
		if(T[n][sum]){
			System.out.println("YES");
			System.out.print("And the elements are : ");

			int i = n,j=sum;
			
			while(true){
				
				if(T[i][j]==true){
					i--;
					continue;
				}
				else{
					System.out.print(arr[i]+" ");
					j = j - arr[i];
					i++;
					if(j==0)break;
				}
				
			}
		}
		else{
			System.out.println("NO");
		}
	}
	
}
