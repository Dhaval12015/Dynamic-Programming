
public class MatrixChainMultiplication {
	public static void main(String args[]){
		int arr[] = {2,3,6,4,5};
		int n = arr.length;
		int m = n-1;
		int T[][] = new int[m][m];
		for(int i=0;i<m;i++) T[i][i] = 0;
		for(int i=m-1,l=1;i>0;i--,l++){
			for(int j=0;j<i;j++){
			//	System.out.println(j+" "+(j+k));
				int min = Integer.MAX_VALUE;
					for(int k=j+1;k<=j+l;k++){
						int a =  T[j][k-1] + T[k][j+l] + arr[j]*arr[k+1]*arr[j+l];
						if(a<min){
							min = a;
						}
					} 
					T[j][j+l] = min;
			}
		}
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-1;j++){
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
	}
}
