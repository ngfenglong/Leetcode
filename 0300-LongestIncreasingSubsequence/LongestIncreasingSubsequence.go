package longestincreasingsubsequence

func lengthOfLIS(nums []int) int {
	dp := make([]int, len(nums))
	dp[len(nums)-1] = 1

	ans := 1
	for i := len(nums) - 2; i >= 0; i-- {
		count := 1
		for j := len(nums) - 1; j > i; j-- {
			if nums[i] < nums[j] {
				count = max(count, dp[j]+1)
			}
		}
		dp[i] = count
		ans = max(ans, count)
	}

	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
