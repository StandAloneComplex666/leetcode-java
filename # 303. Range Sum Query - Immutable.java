class NumArray {
	int[] sum;
	public NumArray(int[] nums) {
		if (nums == null) return;
		int len = nums.length;
		if(len == 0) return;
		sum = new int[len + 1];
		sum[0] = 0;
		for (int i = 0; i < len; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return sum[j + 1] - sum[i];
	}
}
