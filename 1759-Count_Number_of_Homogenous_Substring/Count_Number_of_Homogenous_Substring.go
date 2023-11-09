package countnumberofhomogenoussubstring

func countHomogenous(s string) int {
	mod := 1000000007
	var total int64 = 0
	var count int64 = 0
	curr := s[0]

	for i, _ := range s {
		if s[i] == curr {
			count++
		} else {
			count = 1
			curr = s[i]
		}
		total += count
	}

	return int(total % int64(mod))
}
