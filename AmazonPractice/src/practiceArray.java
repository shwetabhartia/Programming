import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class practiceArray {

	public Integer majorityElement(int[] nums) {
		
		int count = 0;
		Integer majorityElement=null;
		
		for (int i=0; i<nums.length; i++) {
			if (count == 0) {
				majorityElement = nums[i];
				count++;
			} else {
				if (nums[i] == majorityElement) {
					count++;
				} else count--;
			}
		}
		
		if (count == 0) return null;
		else {
			count = 0;
			for (int i=0; i<nums.length; i++) {
				if (nums[i] == majorityElement) {
					count++;
				}
			}
			return (count > nums.length/2) ? majorityElement : null; 
		}
	}
	
	public int OddNumberTimes (int[] nums) {
		int ret=0;
		for (int i =0; i<nums.length; i++) {
			ret = ret^nums[i];
		}
		return ret;
	}
	
	public ArrayList<Integer> allNumbersOddTimes (int[] nums) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		
		for (int i=0; i<nums.length; i++) {
			if (!hm.containsKey(nums[i])) {
				hm.put(nums[i],true);
			} else {
				hm.remove(nums[i]);
			}
		}
		for (Map.Entry<Integer, Boolean> e : hm.entrySet()) {
			if (e.getValue() == true) numbers.add(e.getKey());
		}
		Iterator<Integer> it = numbers.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		return numbers;
	}
	
	public int maximumSumSubArray (int[] nums) {
		int length = nums.length;
        int maxArray[][] = new int[length][length];
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i<length; i++) {
            for (int j=i; j<length; j++) {
                if (i == j) {
                    maxArray[i][j] = nums[i];
                }
                else {
                    maxArray[i][j] = maxArray[i][j-1] + nums[j];
                }
                if (maxArray[i][j] > max) {
                        max = maxArray[i][j];
                }
            }
        }
        return max;
	}
	
	public static void main (String args[]) {
		
		practiceArray pa = new practiceArray();
		int[] nums = {1,1,2,3,4,4,7,3};
		//System.out.println(pa.majorityElement(nums));
		//System.out.println(pa.OddNumberTimes(nums));
		pa.allNumbersOddTimes(nums);
	}
}
