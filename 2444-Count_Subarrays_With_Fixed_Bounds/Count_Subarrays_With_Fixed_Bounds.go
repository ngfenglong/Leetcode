package countsubarrayswithfixedbounds

func countSubarrays(nums []int, minK int, maxK int) int64 {
	var count int64
	minP := -1
	maxP := -1
	leftBound := -1

	for i, val := range nums {
		if val < minK || val > maxK {
			leftBound = i
		}

		if val == minK {
			minP = i
		}

		if val == maxK {
			maxP = i
		}

		distance := min(minP, maxP) - leftBound
		if distance > 0 {
			count += int64(distance)
		}
	}

	return count
}

func min(a int, b int) int {
	if a < b {
		return a
	}

	return b
}
