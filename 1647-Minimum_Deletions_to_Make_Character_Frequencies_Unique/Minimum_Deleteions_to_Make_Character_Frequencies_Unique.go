package minimumdeletionstomakecharacterfrequenciesunique

func minDeletions(s string) int {
	frequencies := make([]int, 26)

	for i := 0; i < len(s); i++ {
		frequencies[s[i]-'a']++
	}

	count := 0
	check := make(map[int]bool)

	for i := 0; i < 26; i++ {
		frequency := frequencies[i]
		for frequency > 0 && check[frequency] {
			frequency--
			count++
		}
		check[frequency] = true
	}

	return count
}
