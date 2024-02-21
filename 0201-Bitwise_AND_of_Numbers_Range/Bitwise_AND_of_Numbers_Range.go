package bitwiseandofnumbersrange

func rangeBitwiseAnd(left int, right int) int {
	bitShifted := 0
	for left < right {
		left >>= 1
		right >>= 1
		bitShifted++
	}

	ans := left << bitShifted
	return ans
}
