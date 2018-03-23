import java.util.Scanner;
public class Regular_Expression_Matching {

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		String p1 = "xa*b.c";
		String s1 = "xaabyc";
		char p[] = p1.toCharArray();
		char s[] = s1.toCharArray();
		System.out.println(p);
		int m = p1.length();
		int n = s1.length();
		int flag = 0;
		int vlag = 0;
		int a = 0;
		for(int i=0;i<m;i++){
			if(p[i]=='*')
			{
				if(flag==0){
					flag = 1;
					p[a++] = p[i]; 
				}
			}
			else if( p[i]=='.'){
				if(vlag==0){
					vlag = 1;
					p[a++] = p[i]; 
				}
				
			}
			else{
				p[a++] = p[i];
				flag = 0;
				vlag = 0;
			}
			
		}
		char pe[] = new char[a];
		for(int i=0;i<a;i++){
			pe[i] = p[i];
		}
		System.out.println(pe);
		System.out.println(s);
		
		m = pe.length;
		boolean arr[][]  = new boolean[n+1][m+1];
		
		
		
		for(int i=1;i<m;i++) arr[0][i] = false;
		
		for(int i=1;i<n;i++) arr[i][0] = false;
		
		arr[0][0] = true;
		for(int i=1;i<m;i++){
			if(pe[i]=='*'){
				arr[0][i] = arr[0][i-2];
			}
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s[i-1]==pe[j-1] || pe[j-1]=='.'){
					arr[i][j] = arr[i-1][j-1];
				}
				else if(pe[j-1]=='*'){
					arr[i][j] = arr[i][j-2];
					if(pe[j-2]==s[j-1] || pe[j-2]=='.')		
					arr[i][j] = arr[i][j] | arr[i-1][j];	
				}
			}
		}
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				
		System.out.print(arr[i][j]+" ");
			}
		System.out.println();	
		}
		 
	}
}
