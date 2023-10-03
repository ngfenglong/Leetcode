package numberofgoodpairs

func numIdenticalPairs(nums []int) int {
	hm := make(map[int]int)
	count := 0
	for _, num := range nums {
		count += hm[num] // if num is not present, hm[num] will return 0
		hm[num]++
	}

	return count
}
