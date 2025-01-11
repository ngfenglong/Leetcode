package sequentialdigits

func sequentialDigits(low int, high int) []int {
	answer := make([]int, 0)

	lowDigitCount := 0
	highDigitCount := 0

	currLow := low
	currHigh := high

	for currLow > 0 {
		currLow /= 10
		lowDigitCount++
	}

	for currHigh > 0 {
		currHigh /= 10
		highDigitCount++
	}

	for digitCount := lowDigitCount; digitCount <= highDigitCount; digitCount++ {
		for curr := 1; curr <= 10-digitCount; curr++ {
			num := curr
			for nextNum := curr + 1; nextNum < curr+digitCount; nextNum++ {
				num *= 10
				num += nextNum
			}

			if num < low {
				continue
			} else if num <= high {
				answer = append(answer, num)
			} else {
				break
			}

		}
	}

	return answer
}
