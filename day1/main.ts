import * as fs from 'fs'
import { solveProblem as solveFirstProb } from "./part1" 
import { solveProblem as solveSecondProb } from "./part2" 

const file = fs.readFileSync(__dirname + "/input.txt", 'utf8');
const part1Sol = solveFirstProb(file)
console.log(part1Sol);
const part2Sol = solveSecondProb(file)
console.log(part2Sol);
