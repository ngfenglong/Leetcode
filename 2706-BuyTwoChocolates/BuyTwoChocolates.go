package buytwochocolates

func buyChoco(prices []int, money int) int {
	var first, second int

	if prices[0] < prices[1] {
		first = prices[0]
		second = prices[1]
	} else {
		first = prices[1]
		second = prices[0]
	}

	for i := 2; i < len(prices); i++ {
		if prices[i] < first {
			second = first
			first = prices[i]
		} else if prices[i] < second {
			second = prices[i]
		}
	}

	if first+second > money {
		return money
	}

	return money - (first + second)
}
