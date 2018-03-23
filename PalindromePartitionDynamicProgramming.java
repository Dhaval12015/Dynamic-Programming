import java.util.*;
public class PalindromePartitionDynamicProgramming {
	public static boolean isPelindrom(String str){
		StringBuffer s = new StringBuffer(str);
		
		if(str.equals((s.reverse()).toString()))
		return true;
		else return false;
	}
	public static void main(String args[]){
		String s = "abc";
		System.out.println(isPelindrom(s));
		
		
		int n = s.length();
		int T[][] = new int[n][n];
		for(int i=0;i<n;i++){
			T[i][i] = 0;
		}
		for(int i=n-1,k=1;i>0&&k<n;i--,k++){
			for(int j=0;j<i;j++){
			//	System.out.println(j+" "+(j+k));
				String s1 = s.substring(j,j+k);
				if(isPelindrom(s.substring(j,j+k+1))){
					T[j][j+k] = 0;
				}
				else{
					int min = Integer.MAX_VALUE;
					for(int l=j+1;l<=j+k;l++){
						int a = 1 + T[j][l-1] + T[l][j+k];
						if(a<min){
							min = a;
						}
					} 
					T[j][j+k] = min;
				}
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
