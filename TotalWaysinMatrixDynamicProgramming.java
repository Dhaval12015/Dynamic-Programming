import java.util.*;
public class TotalWaysinMatrixDynamicProgramming {
	
	public static void main(String args[]){
		
		int n = 4,m = 4;
		int T[][] = new int[n][m];
		if(n==m){
		for(int i=0;i<n;i++){
			T[0][i] = 1;
			T[i][0] = 1;
		}}
		for(int i=0;i<n;i++){
			T[i][0] = 1;
		}
		for(int i=0;i<m;i++){
			T[0][i] = 1;
		}
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				T[i][j] = T[i][j-1] + T[i-1][j];
			}
		}
		System.out.println("Total Number of Ways are :"+T[n-1][m-1]);
		
	}
}
