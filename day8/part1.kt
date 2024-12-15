package part1;

fun addToNodeMap(curMap: HashMap<Char, HashSet<Pair<Int,Int>>>, id: Char, pos: Pair<Int, Int>){
    if (curMap.containsKey(id)) {
        curMap.get(id)?.add(pos);
    } else {
        val newSet: HashSet<Pair<Int, Int>> = HashSet();
        newSet.add(pos)
        curMap.put(id, newSet);
    }
}

fun createNodeMap(lines: List<String>): HashMap<Char, HashSet<Pair<Int,Int>>>{
    val outMap: HashMap<Char, HashSet<Pair<Int,Int>>> = HashMap();

    for (lineIdx in 0..<lines.size){
        val line = lines[lineIdx];
        for (charIdx in 0..<line.length){
            val char = line[charIdx];
            val pos = Pair(lineIdx, charIdx)

            if (char != '.') {
                addToNodeMap(outMap, char, pos);
            }
        }
    }

    return outMap;
}

fun getAntiNodeFromPair(posA: Pair<Int, Int>, posB: Pair<Int, Int>): Pair<Int, Int>{
    val vertDist = posA.first - posB.first;
    val horzDist = posA.second - posB.second;
    val outPair = Pair(posB.first - vertDist, posB.second - horzDist); 
    return outPair;
}

fun createAntiNodeSet(nodePos: HashMap<Char, HashSet<Pair<Int,Int>>>): HashSet<Pair<Int, Int>>{
    val outSet: HashSet<Pair<Int, Int>> = HashSet();

    for (nodeGroup in nodePos.values){
        val groupList = nodeGroup.toList();
        for (leftIdx in 0..<groupList.size){
            for (rightIdx in leftIdx+1..<groupList.size){
                outSet.add(getAntiNodeFromPair(groupList[leftIdx], groupList[rightIdx]));
                outSet.add(getAntiNodeFromPair(groupList[rightIdx], groupList[leftIdx]));
            }
        }
    }

    return outSet;
}

fun isPairInBounds(node: Pair<Int, Int>, bounds: Pair<Int, Int>): Boolean{
    if (node.first < 0 || node.first >= bounds.first) return false;
    return !(node.second < 0 || node.second >= bounds.second);
}
 
fun solvePart1(lines: List<String>, bounds: Pair<Int, Int>): Int{
    val nodeMap = createNodeMap(lines);
    val antiNodeSet = createAntiNodeSet(nodeMap);
    return antiNodeSet.filter({item: Pair<Int, Int> -> isPairInBounds(item, bounds)}).size
}
