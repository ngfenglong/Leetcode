package frogjump

func canCross(stones []int) bool {
	if stones[1] != 1 || stones[len(stones)-1] > 2001000 {
		return false
	}

	// Initialization of memoization table
	dp := make([][]*bool, 2001)
	for i := range dp {
		dp[i] = make([]*bool, 2001)
	}

	// Mapping of stone values to their positions in the array
	stoneToIndex := make(map[int]int)
	for i, stone := range stones {
		stoneToIndex[stone] = i
	}

	return isReachable(1, 0, stones[len(stones)-1], dp, stoneToIndex)
}

func isReachable(jump int, currentPosition int, destination int, dp [][]*bool, stoneToIndex map[int]int) bool {
	if currentPosition == destination {
		return true
	}

	idx, stoneExists := stoneToIndex[currentPosition]
	if !stoneExists {
		return false
	}

	if dp[idx][jump] != nil {
		return *dp[idx][jump]
	}

	// Check the possibility of reaching the destination by jumping `jump-1`, `jump`, or `jump+1` units.
	if jump != 1 && isReachable(jump-1, currentPosition+jump-1, destination, dp, stoneToIndex) {
		dp[idx][jump] = &stoneExists
		return true
	}

	if isReachable(jump, currentPosition+jump, destination, dp, stoneToIndex) {
		dp[idx][jump] = &stoneExists
		return true
	}

	if idx != 0 && isReachable(jump+1, currentPosition+jump+1, destination, dp, stoneToIndex) {
		dp[idx][jump] = &stoneExists
		return true
	}

	falseVal := false
	dp[idx][jump] = &falseVal
	return false
}
