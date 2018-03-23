import java.util.*;
public class Word_Splitting_Problem {
	
	public Void breakWord(String str, HashSet<String> dict){
		int n = str.length();
		int T[][] = new int[n][n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				T[i][j] = -1;
			}
		}
		
		
		for(int l=1;l<=n;l++){
			for(int i=0;i<n-l+1;i++){
				int j = i+l-1;
				String s = str.substring(i,j+1);
				if(dict.contains(s)){
					T[i][j] = i;
					continue;
				}
				
					for(int k=i+1;k<=j;k++){
						if(T[i][k-1]!=-1 && T[k][j]!=-1)
						T[i][j] = k;
						break;
					}			
						
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(T[i][j]);
			}
			System.out.println();
		}
		if(T[0][n-1]==-1)
			System.out.println(-1);
		else{
	//	StringBuffer buff = new StringBuffer();
		int i = 0,j = n-1;
		while(i<j){
		int k = T[i][j];
		
		if(i==k){
	//		buff.append(str.substring(i,j+1));
			System.out.print(str.substring(i,j+1)+" ");
			break;
		}
	//	buff.append(str.substring(i,i+1)+" ");
		System.out.print(str.substring(i,j+1)+" ");
		
		}}
	//	return buff.toString();
		return null;
		
	}

	public static void main(String args[]){
		
		HashSet<String> dictionary = new HashSet<String>();
		dictionary.add("i");
		dictionary.add("like");
		dictionary.add("to");
		Word_Splitting_Problem obj = new Word_Splitting_Problem();
		
		obj.breakWord("iliketo",dictionary);	
	}

}
