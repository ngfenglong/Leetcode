package findmodeinbinarysearchtree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var maxOccurrence int

func findMode(root *TreeNode) []int {
	var dp = make(map[int]int)
	maxOccurrence = 0

	dfs(root, dp)

	result := make([]int, 0)
	for key, value := range dp {
		if value == maxOccurrence {
			result = append(result, key)
		}
	}

	return result
}

func dfs(root *TreeNode, dp map[int]int) {
	if root != nil {
		curr := dp[root.Val]
		curr++
		dp[root.Val] = curr

		maxOccurrence = max(maxOccurrence, curr)

		dfs(root.Left, dp)
		dfs(root.Right, dp)
	}

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
