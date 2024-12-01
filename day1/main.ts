import * as fs from 'fs'
import { solveProblem as solveFirstProb } from "./part1" 
import { solveProblem as solveSecondProb } from "./part2" 

function parseLists(file: string){
    const leftSide: number[] = [];
    const rightSide: number[] = [];
    const splitLines = file.split("\n")

    splitLines.forEach((line) => {
        if(line.length === 0) return;
        const [left, right] = line.split("   ");
        leftSide.push(parseInt(left));
        rightSide.push(parseInt(right));
    })

    return [leftSide, rightSide];
}

console.time("solveProbs");
const file = fs.readFileSync(__dirname + "/input.txt", 'utf8');
const [leftList, rightList] = parseLists(file)
const part1Sol = solveFirstProb(leftList, rightList);
const part2Sol = solveSecondProb(leftList, rightList);
console.log(part1Sol, part2Sol);
console.timeEnd("solveProbs");
