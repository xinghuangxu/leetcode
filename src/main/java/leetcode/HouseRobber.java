package leetcode;

public class HouseRobber {

	public int rob(int[] nums) {
		int[] mem = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			mem[i]=-1;
		}
		return findMax(nums, 0, mem);
	}

	public int findMax(int[] nums, int left, int[] mem) {
		if (nums.length - 1 < left) {
			return 0;
		}
		if (mem[left] != -1) {
			return mem[left];
		}
		if (nums.length - 1 == left) {
			return nums[left];
		}
		int option1 = nums[left] + findMax(nums, left + 2, mem);
		int option2 = 0;
		if (nums.length - 1 >= left + 1) {
			option2 = nums[left + 1] + findMax(nums, left + 3, mem);
		}
		mem[left] = Math.max(option1, option2);
		return mem[left];
	}
}
