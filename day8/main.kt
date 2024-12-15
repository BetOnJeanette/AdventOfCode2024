package main;

import java.io.File;
import java.io.BufferedReader;

fun main(){
    val bufferedReader = File("input.txt").bufferedReader();
    val fileContents = bufferedReader.use { it.readText() };
    val splitLines = fileContents.split("\n").filter{line -> line.length > 0};
    val bounds = Pair(splitLines.size, splitLines[0].length);
    val part1 = part1.solvePart1(splitLines, bounds);
    val part2 = part2.solvePart2(splitLines, bounds);
    println(part1);
    println(part2);
}
