use std::fs;

use part1::solve_puzzle;
mod part1;

fn parse_line(line: &str) -> Vec<i32>{
    let split_items:Vec<&str> = line.split(' ').collect();
    return split_items.iter().map(|item: &&str| item.parse::<i32>().unwrap()).collect();

}

fn ensure_ascending_list(list: &Vec<i32>) -> Vec<i32>{
    if list.len() > 1 && list[0] > list[1] {
        return (*list).clone().into_iter().rev().collect();
    } else {
        return (*list).clone();
    }
}

fn main() {
    let file = fs::read_to_string("input.txt").unwrap(); 
    let parsed_lines: Vec<Vec<i32>> = file.lines().map(|line: &str| parse_line(line)).collect();
    let asccending_lines: Vec<Vec<i32>> = parsed_lines.into_iter().map(|line: Vec<i32>|ensure_ascending_list(&line)).collect();
    let part1_sol = solve_puzzle(&asccending_lines);
    println!("Part 1: {part1_sol}");
}
