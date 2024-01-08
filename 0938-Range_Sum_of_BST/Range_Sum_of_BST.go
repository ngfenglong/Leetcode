package rangesumofbst

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func rangeSumBST(root *TreeNode, low int, high int) int {
	return binarySearch(root, low, high)
}

func binarySearch(root *TreeNode, low int, high int) int {
	if root == nil {
		return 0
	}
	if root.Val < low {
		return binarySearch(root.Right, low, high)
	} else if root.Val > high {
		return binarySearch(root.Left, low, high)
	} else {
		return root.Val + binarySearch(root.Left, low, high) + binarySearch(root.Right, low, high)
	}

}
