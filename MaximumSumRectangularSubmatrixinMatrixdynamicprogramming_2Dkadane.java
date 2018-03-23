import java.util.*;
public class MaximumSumRectangularSubmatrixinMatrixdynamicprogramming_2Dkadane {
	public static int[] findMaxsumSubarray(int[] arr){
		int n = arr.length;
		int cm = 0,max = 0;
		boolean flag = false;
		int s=0,e=0;
		for(int i=0;i<n;i++){
			cm += arr[i];
			if(cm >= max){
				if(flag) {s = i;flag = false;}
				max = cm;
				e = i;
			}
			if(cm < 0){
				cm = 0;
				flag = true;
			}
			
		}
		int ans[] = new int[3];
		ans[0] = max;
		ans[1] = s;
		ans[2] = e;
		return ans;
	}
	public static void main(String args[]){
	//	int arr[] = {-2,3,-4,3,-5};
	//	int ans[] = findMaxsumSubarray(arr);
	//	System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
		int T[][] =new int[][]{{2,1,-3,-4,5},
								{0,6,3,4,1},
								{2,-2,-1,4,-5},
								{-3,3,1,0,3}};
		int l=0,r=0,up=0,down=0;
		int A[][] = new int[4][5];
		int n =4,m=5;
		int ms=0;
		for(int i=0;i<m;i++)A[0][i] = T[0][i];
		for(int i=1;i<n;i++){
			for(int j=0;j<m;j++){
				A[i][j] =T[i][j] + A[i-1][j]; 
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(A[i][j]+" ");
			}
			System.out.println();	
		}
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr = A[i].clone();
			int ans[] = findMaxsumSubarray(arr);
			if(ans[0]>ms){
				ms = ans[0];
				l = ans[1];
				r = ans[2];
				up = 0;
				down = i;
			}
		}
		
	
		System.out.println();
		for(int i=1;i<n;i++){
				for(int k=i;k<n;k++){
				int arr1[] = A[k].clone();
				int arr2[] = A[i-1].clone();
				for(int p=0;p<m;p++){
					arr[p] = arr1[p] - arr2[p];
				}
				int ans[] = findMaxsumSubarray(arr);
				if(ans[0]>ms){
					ms = ans[0];
					l = ans[1];
					r = ans[2];
					up = i;
					down = k;
				}
				}
			}
		System.out.println(ms+" "+l+" "+r+" "+up+" "+down);
	}
}
