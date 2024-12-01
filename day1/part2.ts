function parseFile(file: string){
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

function getAppearanceCount(list: number[]){
    const output = {};
    list.forEach(item => {
        if (item in output){
            output[item]++;
        } else {
            output[item] = 1;
        }
    })
    return output;
}

function solveProblem(file: string){
    const [leftSide, rightSide] = parseFile(file);
    const appearanceCount = getAppearanceCount(rightSide);
    return leftSide.reduce((acc, item) => acc + (item * (appearanceCount[item] || 0)), 0)
}

export {solveProblem}
