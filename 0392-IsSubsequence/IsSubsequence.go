package issubsequence

func isSubsequence(s string, t string) bool {
	sPointer := 0
	tPointer := 0

	for sPointer < len(s) && tPointer < len(t) {
		if s[sPointer] == t[tPointer] {
			sPointer++
		}
		tPointer++
	}

	return sPointer == len(s)
}
