package sortarraybyparity

func sortArrayByParity(nums []int) []int {
	newArr := make([]int, len(nums))

	left := 0
	right := len(nums) - 1

	for i := range nums {
		if nums[i]%2 == 1 {
			newArr[right] = nums[i]
			right--
		} else {
			newArr[left] = nums[i]
			left++
		}
	}

	return newArr
}
