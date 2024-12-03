package main

import (
	"regexp"
	"strings"
)

func removeFirstItem(arr []string) []string{
    if len(arr) == 1 {
        return make([]string, 0)
    }
    return arr[1:]
}

func getMults(searchIn string) int {
    total := 0
    reg, _ := regexp.Compile("mul\\(\\d{1,3},\\d{1,3}\\)")
    mults := reg.FindAllString(searchIn, -1)
    for _, element := range mults {
       total += getMult(element) 
    }
    return total
}

func solvePart2(input string) int {
    total := 0
    dontSplits := strings.Split(input, "don't()")

    total += getMults(dontSplits[0])
    dontSplits = removeFirstItem(dontSplits)

    for _,elem := range dontSplits{
        doSplits := removeFirstItem(strings.Split(elem, "do()"))
        for _,reenabledElem := range doSplits {
            total += getMults(reenabledElem)
        }
    }
    
    return total
}
