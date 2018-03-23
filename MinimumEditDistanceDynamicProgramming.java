import java.util.*;
public class MinimumEditDistanceDynamicProgramming {
	public static void main(String args[]){
		String s1 = "abcdef";
		String s2 = "azced";
		int n = s1.length();
		int m = s2.length();
		int T[][] = new int[m+1][n+1];
		
		for(int i=0;i<n;i++){
			T[0][i] = i;
		}
		for(int i=1;i<n;i++){
			T[i][0] = i;
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(s1.charAt(j-1)==s2.charAt(i-1)){
					T[i][j] = T[i-1][j-1];
				}
				else{
					int temp = Math.min(T[i][j-1], T[i-1][j]);
					T[i][j] = 1+Math.min(temp,T[i-1][j-1]);
				}
			}	
		}
		for(int i=1;i<=m;i++){
			for(int j=0;j<=n;j++){
				System.out.print(T[i][j]+" ");
			}
			System.out.println();	
		}
		System.out.println("Minimum edit would be : "+T[m][n]);
	}
}
