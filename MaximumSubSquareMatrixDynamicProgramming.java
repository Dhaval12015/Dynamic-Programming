public class MaximumSubSquareMatrixDynamicProgramming {	
	public static void main(String args[]){
		int A[][] = new int[][]{{0,0,1,1,1},{1,0,1,1,1},{0,1,1,1,1},{1,0,1,1,1}};
		int T[][] = new int[4][5];
		int n = 4;
		int m = 5;
		for(int i=0;i<n;i++) T[i][0] = A[i][0];
		for(int i=1;i<m;i++) T[0][i] = A[0][i];
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				T[i][j] = Math.min(T[i-1][j-1],Math.min(T[i-1][j],T[i][j-1])) + 1;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
			System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Maximum Sub Square Matrix size is : "+T[n-1][m-1]);
	}
}
