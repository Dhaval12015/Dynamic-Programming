public class CountNumberofBinaryTreePossiblegivenPreorderSequencelengthdynamicprogramming {
	public static void main(String args[]){
		int n = 4;
		int arr[] = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2;i<=n;i++){
			if(i==3) {arr[3] = 5;continue;}
			for(int j=i-1;j>=i/2;j--){
				arr[i] += 2*arr[j];
			}
		}
		System.out.println(arr[n]);
	}
}
