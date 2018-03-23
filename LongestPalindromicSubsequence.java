
public class LongestPalindromicSubsequence {
	public static void main(String args[]){
		String s = "agbdba";
		int n = s.length();
		int T[][] = new int[n][n];
		for(int i=0;i<n;i++) T[i][i] = 1;
		for(int i=n-1,l=1;i>0;i--,l++){
			for(int j=0;j<i;j++){
			//	System.out.println(j+" "+(j+k));
				
						String s1 = s.substring(j,j+l+1);
					//	System.out.println(s1);
						int l1 = s1.length();
						if(s1.charAt(0)==s1.charAt(l1-1)){
							T[j][j+l] = 2 + T[j+1][j+l-1];
						}else{
							T[j][j+l] = Math.max(T[j+1][j+l],T[j][j+l-1]);
						} 
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Longest Palindromic Subsequence size is : "+T[0][n-1]);
	}
}
