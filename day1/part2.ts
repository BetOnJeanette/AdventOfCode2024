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

function solveProblem(leftList: number[], rightList: number[]){
    const appearanceCount = getAppearanceCount(rightList);
    return leftList.reduce((acc, item) => acc + (item * (appearanceCount[item] || 0)), 0)
}

export {solveProblem}
