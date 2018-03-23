import java.util.*;
public class OptimalBinarySearchTree {
	
	public static void main(String args[]){
		 
		int key[] = {10,12,16,21};
		 int val[] = {4,2,6,3};
		 int n = key.length;
		 int T[][] = new int[n][n];
		 
		 for(int i=0;i<n;i++)	 T[i][i] = val[i];
		 
		 for(int i=n-1,k=1;i>0&&k<n;i--,k++){
				for(int j=0;j<i;j++){
					int sum = 0;
					for(int l=j;l<=j+k;l++){
						sum += val[l];
					}
						int min = Integer.MAX_VALUE;
						int ans = 0;
						for(int l=j;l<=j+k;l++){
							if(l==j){
								ans = sum + T[j+1][j+k];
							}
							else if(l==j+k){
								ans = sum + T[j][j+k-1];
							}
							else {
							ans = sum + T[j][l-1] + T[l+1][j+k];
							}
							if(ans<min){
								min = ans;
							}
						}
						T[j][j+k] = min;
				}
		 }
		 for(int i=0;i<n;i++){
			 for(int j=0;j<n;j++){
				 System.out.print(T[i][j]);
			 }
			 System.out.println();
		 }
	}
}
