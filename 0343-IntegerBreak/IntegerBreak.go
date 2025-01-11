package integerbreak

func integerBreak(n int) int {
    hm := make(map[int]int)
    
    max := 0
    for i := 2; i <= n; i++ {
        max = getLargestProduct(i, hm)
    }
    
    return max
}

func getLargestProduct(n int, hm map[int]int) int {
    if n <= 2 {
        return 1
    } 
    
    if val, exists := hm[n]; exists {
        return val;
    }
    
    currMax := 0
    for i := 1; i <= n/2; i++ {
        currMax = maxInt(currMax, i * getLargestProduct(n - i, hm))
        currMax = maxInt(currMax, i * (n - i))
    }
    
    hm[n] = currMax
    return currMax    
}


func maxInt(a, b int) int {
    if a > b {
        return a
    }
    return b
}