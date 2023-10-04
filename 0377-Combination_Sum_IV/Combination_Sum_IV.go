package combinationsumiv

func combinationSum4(nums []int, target int) int {
	dp := make([]int, target+1)
	for i := range dp {
		dp[i] = -1
	}
	return checkCombinations(nums, target, dp)
}

func checkCombinations(nums []int, target int, dp []int) int {
	if target == 0 {
		return 1
	}

	if target < 0 {
		return 0
	}

	if dp[target] != -1 {
		return dp[target]
	}

	ans := 0
	for _, num := range nums {
		ans += checkCombinations(nums, target-num, dp)
	}

	dp[target] = ans
	return ans
}
