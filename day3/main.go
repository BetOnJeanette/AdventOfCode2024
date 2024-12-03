package main

import (
    "os"
)

func check(e error) {
    if e != nil {
        panic(e)
    }
}

func main() {
    dat, err :=  os.ReadFile("day3/input.txt")
    check(err)    
    input := string(dat)
    part1 := solvePartOne(input)
    println(part1)
}
