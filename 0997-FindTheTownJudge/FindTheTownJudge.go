package findthetownjudge

func findJudge(n int, trust [][]int) int {
	trusting := make([]int, n+1)
	trusted := make([]int, n+1)

	for i := range trust {
		trusting[trust[i][0]]++
		trusted[trust[i][1]]++
	}

	for i := 1; i <= n; i++ {
		if trusting[i] == 0 && trusted[i] == n-1 {
			return i
		}
	}

	return -1
}
