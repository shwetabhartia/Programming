import java.util.HashMap;
import java.util.Hashtable;

public class general {
	
	public void hammingCode (int x, int y) {
		int c = x^y;
		int count = 0;
		String s = Integer.toBinaryString(c);
		for (int i = 0; i< s.length(); i++) {
			if (s.charAt(i) == '1') count++;
		}
		System.out.println(count);
		System.out.println("----------");
		System.out.println(Integer.bitCount(x^y));
	}
	
	public int findComplement(int num) {
        int x = num^1;
        System.out.println(x);
        return x;
    }
	
	public void addString(String s) {
		int sum=0;
		Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
		ht.put("zero", 0);
		ht.put("one", 1);
		ht.put("two", 2);
		ht.put("three", 3);
		ht.put("four", 4);
		ht.put("five", 5);
		ht.put("six", 6);
		ht.put("seven", 7);
		ht.put("eight", 8);
		ht.put("nine", 9);
		String sarr[] = s.split(" ");
		for(int i=0; i<sarr.length; i++) {
			sum+=ht.get(sarr[i]);
		}
		System.out.println(sum);	
	}
	
	public int[] twoSum (int[] nums, int target) {
		if (nums.length < 2) return null;
		int[] retValue = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i =0; i<nums.length; i++) {
			Integer diff = (Integer) target - nums[i];
			if (hm.containsKey(diff)) {
				retValue[0] = hm.get(diff);
				retValue[1] = i;
				return retValue;
			} else {
				hm.put(nums[i], i);
			}
		}
		return null;
	}
	
	public static void main (String args[]) {
		general g = new general();
		/*g.hammingCode(8, 5);
		g.addString("two three five");*/
		int[] a = {3,2,4};
		int[] res = g.twoSum(a, 6);
		System.out.println(res[0]);
		g.findComplement(5);
	}
}
