 
public class EggDroppingDynamicProgramming {
	public static void main(String args[]){
		int f = 6;
		int e = 2;
		int T[][] =new int[e+1][f+1];
		for(int i=1;i<=f;i++) T[1][i] = i;
		for(int i=2;i<=e;i++)
			for(int j=1;j<=f;j++){
				if(i>j){
					T[i][j] = T[i-1][j];
				}
				else{
					int max = Integer.MAX_VALUE;
					int temp = 0;
					for(int k=1;k<=j;k++){
						temp = 1 + Math.max(T[i-1][k-1], T[i][j-k]); // one for break and another for not break;
						if(temp<max){
							max = temp;
						}
					}
					T[i][j] = max;				}
			}
		for(int i=1;i<=e;i++){
			for(int j=1;j<=f;j++){
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
		}
}
