package bagoftokens

import "sort"

func bagOfTokensScore(tokens []int, power int) int {
	sort.Ints(tokens)

	left := 0
	right := len(tokens) - 1
	score := 0

	for left <= right && tokens[left] <= power {
		power -= tokens[left]
		score++
		left++
	}

	for left < right && score > 0 {
		score--
		power += tokens[right]
		for left < right && tokens[left] <= power {
			power -= tokens[left]
			left++
			score++
		}

		right--
	}

	return score
}
