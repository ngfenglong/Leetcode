package reverseinteger

import (
	"math"
)

func reverse(x int) int {
    rev := 0
    for x != 0 {
        pop := x % 10
        x /= 10

        rev = rev * 10 + pop
        
        if rev > math.MaxInt32 || rev < math.MinInt32 {
            return 0
        }
    }
    
    return rev
}