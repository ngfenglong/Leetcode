package monotonicarray

func isMonotonic(nums []int) bool {
	// notassigned - 0, increasing -> 1, decreasing 2
	status := 0

	prev := nums[0]
	for i := 1; i < len(nums); i++ {
		if prev < nums[i] {
			if status == 2 {
				return false
			}
			status = 1
		}
		if prev > nums[i] {
			if status == 1 {
				return false
			}
			status = 2
		}

		prev = nums[i]
	}

	return true
}
