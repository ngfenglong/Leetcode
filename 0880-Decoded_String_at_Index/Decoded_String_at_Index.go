package decodedstringatindex

func decodeAtIndex(s string, k int) string {
	decodedLength := 0

	for i := range s {
		c := s[i]
		if isDigit(c) {
			decodedLength *= int(c - '0')
		} else {
			decodedLength++
		}
	}

	for i := len(s) - 1; i >= 0; i-- {
		c := s[i]
		k %= decodedLength
		if k == 0 && isDigit(c) == false {
			return string(c)
		}

		if isDigit(c) {
			decodedLength /= int(c - '0')
		} else {
			decodedLength--
		}
	}

	return ""

}

func isDigit(b byte) bool {
	if b >= '2' && b <= '9' {
		return true
	}

	return false
}
