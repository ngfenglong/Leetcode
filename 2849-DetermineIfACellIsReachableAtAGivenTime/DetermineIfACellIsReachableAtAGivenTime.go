package determineifacellisreachableatagiventime

func isReachableAtTime(sx int, sy int, fx int, fy int, t int) bool {
	if sx == fx && sy == fy && t == 1 {
		return false
	}

	return getDifference(sx, fx) <= t && getDifference(sy, fy) <= t
}

func getDifference(i1, i2 int) int {
	if i1 < i2 {
		return i2 - i1
	}

	return i1 - i2
}
