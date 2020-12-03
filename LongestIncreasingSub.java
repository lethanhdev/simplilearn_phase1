package simplilearn;

class LongestIncreasingSub {

	public static void main(String args[]) 
		{ 	// given an array	
			int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 55, 45, 65, 70}; 
			
			for(int num:findSubsequence(arr))		// find the the longest increasing 
				if(num != -1)						//   subsequence and print outputs.
				   System.out.println(num);
		}//main() 
	
	static int[] findSubsequence(int[] arr) {	
		int[] sub = new int[arr.length];			// create and initialize sub array		
		for(int i=0; i < arr.length; i++)			//	to length of given array to -1
			sub[i] = -1;
		
		int higher = -1;							// temporary high value

		for (int i=0; i < arr.length; i++) {		// compare higher value and store to sub array
			if (arr[i] > higher) {
				higher = arr[i];
				sub[i] = arr[i];
			}	
		}
		return sub;
	}	
} 