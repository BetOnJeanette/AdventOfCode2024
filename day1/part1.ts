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

function solveProblem(leftList: number[], rightList: number[]){
    sortLists(leftList, rightList);
    const pairedItems = pairItems(leftList, rightList);
    return pairedItems.reduce((acc, currentItem) => acc + getDif(currentItem), 0);
}

export { solveProblem };
