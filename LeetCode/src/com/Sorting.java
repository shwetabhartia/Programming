package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sorting {
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Set<Integer> set = new HashSet<Integer>();
		int i=0, j=0, k=0;
		while (i<nums1.length && j<nums2.length) {
			if (nums1[i] == nums2[j]) {
				set.add(nums1[i]);
				i++; j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int []ret = new int[set.size()];
		for (Integer num : set) ret[k++] = num;
		return ret;
	}

	public static void main (String []args) {
		Sorting sort = new Sorting();
		int []nums1 = {1,2,2,1};
		int []nums2 = {2,2};
		int ret[] = sort.intersection(nums1, nums2);
		for (int num : ret) System.out.println(num);
 	}

}
