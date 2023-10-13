package mincostclimbingstairs

func minCostClimbingStairs(cost []int) int {
	totalCost := make([]int, len(cost)+1)
	for i := 2; i < len(totalCost); i++ {
		totalCost[i] = getMin(totalCost[i-1]+cost[i-1], totalCost[i-2]+cost[i-2])
	}
	return totalCost[len(cost)]
}

func getMin(a, b int) int {
	if a < b {
		return a
	}
	return b
}
