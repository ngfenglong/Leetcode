package majorityelementii

func majorityElement(nums []int) []int {
	// Boyer-Moore Majority Vote Algo
	// There can only be at most 2 elements with a frequency > n/3, so we only have to keep track of the top 2 number
	firstCount := 0
	secondCount := 0

	firstNum := 0
	secondNum := 0

	// Traverse the array to look for the top 2 frequency number
	for _, num := range nums {
		if firstNum == num {
			firstCount++
		} else if secondNum == num {
			secondCount++
		} else if firstCount == 0 {
			firstNum = num
			firstCount = 1
		} else if secondCount == 0 {
			secondNum = num
			secondCount = 1
		} else {
			firstCount--
			secondCount--
		}
	}

	ans := []int{}
	firstCount = 0
	secondCount = 0
	target := len(nums) / 3

	// Check if first num & second num has a frequency that is > n/3
	for _, num := range nums {
		if num == firstNum {
			firstCount++
		} else if num == secondNum {
			secondCount++
		}
	}

	if firstCount > target {
		ans = append(ans, firstNum)
	}

	if secondCount > target {
		ans = append(ans, secondNum)
	}

	return ans
}
