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

function sortLists (leftSide: number[], rightSide: number[]){
    leftSide.sort();
    rightSide.sort();
}

function pairItems(leftSide: number[], rightSide: number[]){
    return leftSide.map((leftItem, idx) => {
        const rightItem = rightSide[idx];
        return [Math.max(leftItem, rightItem), Math.min(leftItem, rightItem)];
    })
}

function getDif(pair: number[]){
    return pair[0] - pair[1];
}

function solveProblem(file: string){
    const [leftSide, rightSide] = parseFile(file);
    sortLists(leftSide, rightSide);
    const pairedItems = pairItems(leftSide, rightSide);
    return pairedItems.reduce((acc, currentItem) => acc + getDif(currentItem), 0);
}

export { solveProblem };
