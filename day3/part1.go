package main

import (
	"fmt"
	"regexp"
	"strconv"
	"strings"
)

func getMult(multStr string) int {
    numericSec := multStr[4:len(multStr) - 1]
    fmt.Println(multStr, numericSec)
    numStrs := strings.Split(numericSec, ",")
    out := 1
    for _, element := range numStrs {
        curNum, err := strconv.Atoi(element)
        if err != nil {
            panic(err)
        }
        out *= curNum
    }
    return out
}

func solvePartOne(input string) int {
    total := 0
    reg, _ := regexp.Compile("mul\\(\\d{1,3},\\d{1,3}\\)")
    mults := reg.FindAllString(input, -1)
    for _, element := range mults {
       total += getMult(element) 
    }
    return total
}
