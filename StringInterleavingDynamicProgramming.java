import java.util.*;
public class StringInterleavingDynamicProgramming {
	public static void main(String args[]){
		String s1 = "aab";
		String s2 = "axy";
		boolean flag = true;
		String s3 = "aaxaby";
		for(int i=0,j=0,k=0;i<s3.length();i++){
			if(flag){
				if(s1.charAt(j)==s3.charAt(i) && j<s1.length()){
					j++;
					flag = false;
					continue;
				}
			else if(s2.charAt(k)==s3.charAt(i) && k<s2.length()){
				k++;
				flag = true;
				continue;
			}
			else{
				System.out.println(i+" "+j+" "+k+"No Match");
				return;
			}
			}
			else{
				if(s2.charAt(k)==s3.charAt(i) && k<s2.length()){
					k++;
					flag = true;
					continue;
				}
				else if(s1.charAt(j)==s3.charAt(i) && j<s1.length()){
					j++;
					flag = false;
					continue;
				}
				else{
					System.out.println(i+" "+j+" "+k+"No Match");
					return;
				}
			}		
		}
		System.out.println("String are Matching.");
		
	}
}
