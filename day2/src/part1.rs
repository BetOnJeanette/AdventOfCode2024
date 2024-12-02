static MIN_DIF: i32 = 1;
static MAX_DIF: i32 = 3;

fn parse_line(line: &str) -> Vec<i32>{
    let split_items:Vec<&str> = line.split(' ').collect();
    return split_items.iter().map(|item: &&str| item.parse::<i32>().unwrap()).collect();

}

fn ensure_ascending_list(list: Vec<i32>) -> Vec<i32>{
    if list.len() > 1 && list[0] > list[1] {
        return list.into_iter().rev().collect();
    } else {
        return list;
    }
}

fn meets_safety_reqs(readings: &Vec<i32>) -> bool{
    if readings.len() == 0 {
        return true;
    }
    let mut prev_num = readings[0] - MIN_DIF;

    for num in readings {
        if prev_num > *num {
            return false;
        }
        let dif = *num - prev_num;
        if dif < MIN_DIF || dif > MAX_DIF {
            println!("{num} and {prev_num} have dif {dif}");
            return false;
        }

        prev_num = *num;
    }

    return true;
}

fn is_line_safe(line: &str) -> bool {
    let parsed_line: Vec<i32> = parse_line(line);
    let ascending_list: Vec<i32> = ensure_ascending_list(parsed_line);
    return meets_safety_reqs(&ascending_list);
}

pub fn solve_puzzle(input: &String) -> String {
    let safe_lines = input.lines().filter(|line: &&str| is_line_safe(line));
    return safe_lines.count().to_string()
}
