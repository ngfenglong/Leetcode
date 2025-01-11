package specialpositionsinabinarymatrix

func numSpecial(mat [][]int) int {
	specialCol := make([]int, 0)

	for i, _ := range mat {
		count := 0
		col := -1
		for j, _ := range mat[i] {
			if mat[i][j] == 1 {
				col = j
				count++
			}
		}

		if count == 1 {
			specialCol = append(specialCol, col)
		}
	}

	ans := 0
	for _, j := range specialCol {
		count := 0
		for i, _ := range mat {
			if mat[i][j] == 1 {
				count++
			}
		}

		if count == 1 {
			ans++
		}
	}

	return ans
}
