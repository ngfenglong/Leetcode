package ransomnote

func canConstruct(ransomNote string, magazine string) bool {
    letters := make([]int, 26)
    
    for _, l := range magazine {
        i := l - 'a'
        letters[i]++
    }
    
    for _, l := range ransomNote {
        i := l - 'a'
        if letters[i] == 0 {
            return false
        }
        letters[i]--
    }
    
    return true
}