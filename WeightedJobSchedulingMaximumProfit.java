import java.util.*;

class job{
	int s,e,p;
	job(){}
	job(int s,int e,int p){
		this.s = s;
		this.e = e;
		this.p = p;
	}}
class FinishTimeComparator implements Comparator<job>{
	
	public int compare(job j1,job j2){
		if(j1.e<=j2.e)
			return -1;
		else 
			return 1;
		}
}

public class WeightedJobSchedulingMaximumProfit {
	
	public int maxProfit(job[] j){
		int T[]  = new int[j.length];
		int S[]  = new int[j.length];
		int U[] = new int[j.length];
		for(int i=0;i<j.length;i++){
			U[i] = j[i].p;
		//	System.out.print(U[i]);
		}
		FinishTimeComparator comparator = new FinishTimeComparator();
		Arrays.sort(j,comparator);
		S[0] = 0;
		T[0] = j[0].p;
		for(int i=1;i<j.length;i++){
			T[i] = j[i].p;
			S[i] = i;
			for(int k=0;k<i;k++){
				if(j[k].e <= j[i].s){
				T[i] = Math.max(j[i].p+T[k], j[i].p);
				S[i] = k;
				}
			}
		}
		
		int a = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<j.length;i++){
			if(T[i]>max){
				max = T[i];
				a = i;
			}
		}
		System.out.println("Included Jobs are :");
		while(true){
			if(S[a]==a){
				System.out.println(a +" "+U[a]);
				break;
			}
			System.out.println(a+" "+U[a]);
			a = S[a];
		}
		return max;
		
		
	}
	public static void main(String args[]){
		
	job j[] = new job[6];
	
	j[0] = new job(1,3,5);
	j[1] = new job(2,5,6);
	j[2] = new job(4,6,5);
	j[3] = new job(6,7,4);
	j[4] = new job(5,8,11);
	j[5] = new job(7,9,2);

	WeightedJobSchedulingMaximumProfit obj = new WeightedJobSchedulingMaximumProfit();
	System.out.println("Max Profit is : "+obj.maxProfit(j));
	}
}


