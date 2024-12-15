package part2;

fun getAntiNodeSet(posA: Pair<Int, Int>, posB: Pair<Int, Int>, bounds: Pair<Int, Int>): List<Pair<Int, Int>>{
    val vertDist = posA.first - posB.first;
    val horzDist = posA.second - posB.second;
    val nodeQueue: ArrayDeque<Pair<Int, Int>> = ArrayDeque();
    nodeQueue.add(posA);
    nodeQueue.add(posB);
    nodeQueue.add(Pair(posB.first - vertDist, posB.second - horzDist));

    while(part1.isPairInBounds(nodeQueue.last(), bounds)){
        val addedItem = nodeQueue.last();
        nodeQueue.add(Pair(addedItem.first - vertDist, addedItem.second - horzDist))
    }
    val returnData = nodeQueue.dropLast(1);
    return returnData;
}

fun createAntiNodesPt2(nodePos: HashMap<Char, HashSet<Pair<Int,Int>>>, bounds: Pair<Int, Int>): HashSet<Pair<Int, Int>>{
    val outSet: HashSet<Pair<Int, Int>> = HashSet();

    for (nodeGroup in nodePos.values){
        val groupList = nodeGroup.toList();
        for (leftIdx in 0..<groupList.size){
            for (rightIdx in leftIdx+1..<groupList.size){
                outSet.addAll(getAntiNodeSet(groupList[leftIdx], groupList[rightIdx], bounds));
                outSet.addAll(getAntiNodeSet(groupList[rightIdx], groupList[leftIdx], bounds));
            }
        }
    }

    return outSet;
}


fun solvePart2(lines: List<String>, bounds: Pair<Int, Int>): Int{
    val nodeMap = part1.createNodeMap(lines);
    return createAntiNodesPt2(nodeMap, bounds).size;
}
