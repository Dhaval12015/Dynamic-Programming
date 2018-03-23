import java.util.*;
public class TextJustificationDynamicProgramming {
	public void ArrangeString(String[] str,int cap){
		int n = str.length;
		int T[][] = new int[n][n];
		for(int i=0;i<n;i++){
			T[i][i] = cap - str[i].length();
			for(int j=i+1;j<n;j++){
				T[i][j] = T[i][j-1] - str[j].length() - 1;
			}
		}
	
		for(int i=0;i<n;i++){
			T[i][i] = (int)Math.pow(T[i][i], 2);
			for(int j=i+1;j<n;j++){
				if(T[i][j]>=0){
					T[i][j] = (int)Math.pow(T[i][j], 2);
				}
				else{
					T[i][j] = Integer.MIN_VALUE;
				}
			}
		}
	
		int arr1[] = new int[str.length];
		int arr2[] = new int[str.length];
		arr2[0] = -1;
		arr1[0] = T[0][0];
		for(int i=1;i<n;i++){
			int min = Integer.MAX_VALUE;
			int a = 0;
			for(int j=i;j>=0;j--){
				if(T[j][i]>=0){
					if(j>0)
					a = T[j][i]+arr1[j-1];
					
					else{
						a = T[j][i];
				//	System.out.println(a+"df000");
					}
					if(a<min){
						min = a;
						arr1[i] = min;
						arr2[i] = j-1;
					}
			}
			}
		}
		
		for(int i=n-1;i>0;i--){
			for(int j=arr2[i]+1;j<=i;j++){
			System.out.print(str[j]);
			}
			System.out.println();
			if(arr2[i]==0)System.out.println(str[0]);
			i = arr2[i]+1;
		}	
	}
	public static void main(String args[]){
		String str[] = {"Tushar","Roy","Likes","To","Coad"};
		TextJustificationDynamicProgramming obj = new TextJustificationDynamicProgramming();
		int cap = 10;
		obj.ArrangeString(str,cap);
	}
}
