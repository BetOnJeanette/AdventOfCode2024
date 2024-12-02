use std::fs;

use part1::solve_puzzle;
mod part1;

fn main() {
    let file = fs::read_to_string("input.txt").unwrap(); 
    let part1_sol = solve_puzzle(&file);
    println!("Part 1: {part1_sol}");
}
