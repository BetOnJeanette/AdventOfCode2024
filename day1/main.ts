import * as fs from 'fs'
import { solveProblem as solveFirstProb } from "./part1" 
import { solveProblem as solveSecondProb } from "./part2" 

const file = fs.readFileSync(__dirname + "/input.txt", 'utf8');
console.time("solveProbs");
const part1Sol = solveFirstProb(file)
const part2Sol = solveSecondProb(file)
console.log(part1Sol, part2Sol);
console.timeEnd("solveProbs");
