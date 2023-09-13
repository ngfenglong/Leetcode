package candy

func candy(ratings []int) int {
	n := len(ratings)

	toLeft := make([]int, n)
	toRight := make([]int, n)

	toLeft[n-1] = 1
	toRight[0] = 1

	for i := 1; i < n; i++ {
		if ratings[i] > ratings[i-1] {
			toRight[i] = toRight[i-1] + 1
		} else {
			toRight[i] = 1
		}
	}

	for i := n - 2; i >= 0; i-- {
		if ratings[i] > ratings[i+1] {
			toLeft[i] = toLeft[i+1] + 1
		} else {
			toLeft[i] = 1
		}
	}

	count := 0
	for i := 0; i < n; i++ {
		if toLeft[i] > toRight[i] {
			count += toLeft[i]
		} else {
			count += toRight[i]
		}
	}

	return count
}
