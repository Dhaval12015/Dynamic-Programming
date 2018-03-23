import java.util.*;
public class SumQueryin2DImmutableArrayDynamicProgramming {
	
	public static void main(String args[]){
		int n = 4;
		int A[][] = {{2,0,-3,4},{6,3,2,-1},{5,4,7,3},{2,-6,8,1}};
		for(int i=1;i<n;i++){
			A[i][0] += A[i-1][0]; 
			A[0][i] += A[0][i-1];
		}
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				A[i][j] += A[i-1][j] + A[i][j-1] - A[i-1][j-1]; 
		//		System.out.print(A[i][j]);
			}
			System.out.println();
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
			//	A[i][j] += A[i-1][j] + A[i][j-1] - A[i-1][j-1]; 
				System.out.print(A[i][j]);
			}
			System.out.println();
		}
		int a = 2,b = 2;
		int c = 2,d = 2;
		
		int ans = A[c][d] - (A[c][a-1] + A[a-1][d]) + A[a-1][b-1];
		System.out.println(ans);
	}
}
