package uniquepaths

func uniquePaths(m int, n int) int {
	dp := make([][]*int, m)
	for i := range dp {
		dp[i] = make([]*int, n)
	}

	return dfs(0, 0, m, n, dp)
}

func dfs(i int, j int, m int, n int, dp [][]*int) int {
	if i >= m || j >= n {
		return 0
	}

	if i == m-1 && j == n-1 {
		return 1
	}

	if dp[i][j] != nil {
		return *dp[i][j]
	}

	paths := dfs(i+1, j, m, n, dp) + dfs(i, j+1, m, n, dp)
	dp[i][j] = &paths
	return *dp[i][j]
}
