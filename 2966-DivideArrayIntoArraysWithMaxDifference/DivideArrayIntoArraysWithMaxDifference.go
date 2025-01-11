package dividearrayintoarrayswithmaxdifference

import (
	"sort"
)

func divideArray(nums []int, k int) [][]int {
	sort.Ints(nums)
	n := len(nums)
	grps := n / 3
	ans := make([][]int, grps)

	i := n - 1
	grps--
	for i > 0 {
		for j := 0; j < 3; j++ {
			if nums[i]-nums[i-2] > k {
				return [][]int{}
			}
			ans[grps] = make([]int, 3)
			ans[grps][2] = nums[i]
			ans[grps][1] = nums[i-1]
			ans[grps][0] = nums[i-2]
		}
		i -= 3
		grps--
	}

	return ans
}
