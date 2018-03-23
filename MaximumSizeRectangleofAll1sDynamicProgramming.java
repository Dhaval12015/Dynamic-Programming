
public class MaximumSizeRectangleofAll1sDynamicProgramming {
	public static int maxArea(int arr[]){
		int n = arr.length;
		int cm = 0,max = 0,min=Integer.MAX_VALUE,cnt=0;
		
		for(int i=0;i<n;i++){
			if(arr[i]==0){
				max = cnt*cm;
				min = Integer.MAX_VALUE;
				cnt = 0;
			}
			else{
				if(arr[i]<min){
					min = arr[i];
				}
				cnt++;
			}
		}
		return min*cnt;
	}
	
	public static void main(String args[]){
		int A[][] = new int[][]{{0,0,1,1,1},{1,0,1,1,1},{0,1,1,1,1},{1,0,1,1,1}};
		int T[][] = new int[4][5];
		int n = 4;
		int m = 5;
		int max = 0;
		T[0][0] = A[0][0];
//		for(int i=1;i<n;i++) if(A[i][0]==1)T[i][0] = A[i][0]+T[i-1][0];
		for(int i=1;i<m;i++) T[0][i] = A[0][i];
		int temp = maxArea(T[0].clone());
		if(temp>max){
			max = temp;
		}
	//	System.out.println(max);
		for(int i=1;i<n;i++){
			for(int j=0;j<m;j++){
				if(A[i][j]!=0)
				T[i][j] = T[i-1][j]+A[i][j];
			}
			temp = maxArea(T[i].clone());
		//			System.out.print(temp+" ");
			if(temp>max){
				max = temp;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
			System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Maximum Sub Square Matrix size is : "+max);
	}
}
