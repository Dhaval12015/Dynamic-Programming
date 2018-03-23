
public class MaximumSubsquareWithSidesasX {
	public static void main(String args[]){
		int A[][] = new int[][]{{0,0,0,0,1},{1,0,1,1,1},{1,0,1,0,1},{1,1,1,1,1},{0,0,1,1,1}};
		int n = 5;
		int m = 5;
		int B[][] = new int[5][5];
		for(int i=0;i<n;i++) B[i][0] = A[i][0];
	//	for(int i=0;i<m;i++) B[0][i] = A[0][i];
		
		for(int i=0;i<n;i++){
			for(int j=1;j<m;j++){
				if(A[i][j]>=1)
				B[i][j] = B[i][j-1] + 1;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
			System.out.print(B[i][j]+" ");
			}
			System.out.println();
		}
		int C[][] = new int[5][5];
	//	for(int i=0;i<n;i++) B[i][0] = A[i][0];
		for(int i=0;i<m;i++) C[0][i] = A[0][i];
		
		for(int i=1;i<n;i++){
			for(int j=0;j<m;j++){
				if(A[i][j]>=1)
				C[i][j] = C[i-1][j] + 1;
			}
		}
		System.out.println();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
			System.out.print(C[i][j]+" ");
			}
			System.out.println();
		}
		int max = 0;
		for(int i=n-1;i>=0;i--){
			int a = Math.min(B[i][m-1], C[i][m-1]);
		//	System.out.println(a+"asd");
			if(a<max){break;}
			for(int j=a;j>=1;j--){
			//	System.out.println(B[i][m-1]+" "+B[i][m-1-(a-1)]+" "+C[i][m-1]+" "+C[i-(a-1)][m-1]);
				if(B[i][m-1]-B[i][m-1-(j-1)]==j-1 && C[i][m-1]-C[i-(j-1)][m-1]==j-1){
					if(B[i-(j-1)][m-1]-B[i-(j-1)][m-1-(j-1)]==j-1 && C[i][m-1-(j-1)]-C[i-(j-1)][m-1-(j-1)]==j-1 ){
							max = j;
							break;
					}
				}
				else{
					continue;
				}
			}
		}
		System.out.println();
		System.out.println("Maximum Subsquare With Sides as X : "+max);
	}
}
