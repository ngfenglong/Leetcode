package sum

import (
	"sort"
)

func threeSum(nums []int) [][]int {
	ans := make([][]int, 0)

	sort.Ints(nums)

	p1 := 0
	var p2, p3 int

	for p1 < len(nums)-2 {
		p2 = p1 + 1
		p3 = len(nums) - 1

		for p2 < p3 {
			total := nums[p1] + nums[p2] + nums[p3]

			if total == 0 {
				ans = append(ans, []int{nums[p1], nums[p2], nums[p3]})
				p2++

				for p2 < p3 && nums[p2] == nums[p2-1] {
					p2++
				}
			} else if total > 0 {
				p3--
			} else {
				p2++
			}
		}

		p1++
		for p1 < len(nums)-2 && nums[p1] == nums[p1-1] {
			p1++
		}

	}

	return ans
}
