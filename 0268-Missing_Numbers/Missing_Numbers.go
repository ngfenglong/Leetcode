package missingnumbers

func missingNumber(nums []int) int {
	checkList := make([]bool, len(nums)+1)

	for _, val := range nums {
		checkList[val] = true
	}

	for i := range checkList {
		if checkList[i] != true {
			return i
		}
	}

	return -1
}
