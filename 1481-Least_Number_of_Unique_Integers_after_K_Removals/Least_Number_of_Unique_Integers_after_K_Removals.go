package leastnumberofuniqueintegersafterkremovals

func findLeastNumOfUniqueInts(arr []int, k int) int {
	freqsMap := make(map[int]int)

	for _, key := range arr {
		val := freqsMap[key]
		freqsMap[key] = val + 1
	}

	freqs := make([]int, len(arr)+1)

	for _, freq := range freqsMap {
		freqs[freq]++
	}

	remainingUnique := len(freqsMap)
	for i := range freqs {
		for freqs[i] > 0 {
			if k >= i {
				k -= i
				freqs[i]--
				remainingUnique--
			} else {
				return remainingUnique
			}
		}
	}

	return remainingUnique
}
