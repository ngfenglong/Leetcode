package removecoloredpiecesifbothneighborsarethesamecolor

func winnerOfGame(colors string) bool {
    if len(colors) < 3 {
        return false
    }
    
    
    removableColors := make([]int, 2)
    
    count := 0
    currColor := colors[0]
    
    for i := 0; i < len(colors); i++ {
        if colors[i] == currColor {
            count++
        } else {
            if count > 2 {
                removableColors[currColor - 'A'] += (count - 2)
            }
            count = 1
            currColor = colors[i]
        }
    }
    
    if count > 2 {
        removableColors[currColor - 'A'] += (count - 2)
    }
    
    return removableColors[0] > removableColors[1]
     
}