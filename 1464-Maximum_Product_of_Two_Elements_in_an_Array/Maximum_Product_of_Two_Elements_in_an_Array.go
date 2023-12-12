package maximumproductoftwoelementsinanarray

func maxProduct(nums []int) int {
	m1 := 0
	m2 := 0

	for _, val := range nums {
		if val > m1 {
			m2 = m1
			m1 = val
		} else if val > m2 {
			m2 = val
		}
	}

	return (m1 - 1) * (m2 - 1)
}
