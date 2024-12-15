package main;

import java.io.File;
import java.io.BufferedReader;

fun main(){
    val bufferedReader = File("input.txt").bufferedReader();
    val fileContents = bufferedReader.use { it.readText() };
    val splitLines = fileContents.split("\n").filter{line -> line.length > 0};
    val bounds = Pair(splitLines.size, splitLines[0].length);
    val part1 = part1.solvePart1(splitLines, bounds);
    print(part1);
}
