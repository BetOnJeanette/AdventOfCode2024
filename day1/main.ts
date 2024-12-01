import * as fs from 'fs'
import { solveProblem as solveFirstProb } from "./part1" 

const file = fs.readFileSync(__dirname + "/input.txt", 'utf8');
const part1Sol = solveFirstProb(file)
console.log(part1Sol);
