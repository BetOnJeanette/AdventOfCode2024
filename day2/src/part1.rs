static MIN_DIF: i32 = 1;
static MAX_DIF: i32 = 3;

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
            return false;
        }

        prev_num = *num;
    }

    return true;
}

pub fn solve_puzzle(input: &Vec<Vec<i32>>) -> String {
    let safe_lines = input.into_iter().filter(|line: &&Vec<i32>| meets_safety_reqs(&line));
    return safe_lines.count().to_string()
}
