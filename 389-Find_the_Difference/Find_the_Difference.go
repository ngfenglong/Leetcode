package findthedifference

func findTheDifference(s string, t string) byte {
	numOfChars := make([]int, 26)

	for i := range s {
		idx := s[i] - 'a'
		numOfChars[idx]++
	}

	for i := range t {
		idx := t[i] - 'a'
		if numOfChars[idx] == 0 {
			return t[i]
		}
		numOfChars[idx]--
	}

	return 'a'
}
