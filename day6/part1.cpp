#include "part1.h"
#include <unordered_set>
#include <utility>
#include <vector>

using namespace std;

enum Direction{
    North,
    East,
    South,
    West
};

pair<int, int>getNextPos(pair<int, int> guardPos, Direction curDir){
    switch (curDir){
        case North: return pair(guardPos.first - 1, guardPos.second);
        case East: return pair(guardPos.first, guardPos.second + 1);
        case South: return pair(guardPos.first + 1, guardPos.second);
        case West: return pair(guardPos.first, guardPos.second - 1);
    }
}

Direction getNextDirection(Direction curDir) {
    switch (curDir){
        case North: return East;
        case East: return South;
        case South: return West;
        case West: return North; 
    };
}

bool isInBounds(pair<int, int> curPos, pair<int, int> outerBounds) {
    if (curPos.first < 0 || curPos.first >= outerBounds.first) return false;
    return !(curPos.second < 0 || curPos.second >= outerBounds.second);
}

int getHashPos(pair<int, int> posToHash, pair<int, int> outerBounds) {
    // the hash is just how many characters it is in there.
    return (posToHash.first * outerBounds.second) + posToHash.second;
}

int Part1Solver::solvePart1(vector<unordered_set<int>> crates, pair<int, int> guardPos, pair<int, int> outerBounds){
    Direction curDir = North;
    bool inBounds = true;
    unordered_set<int> usedSpots = unordered_set<int>();

    usedSpots.insert(getHashPos(guardPos, outerBounds));
    
    while (inBounds) {
        pair<int, int> nextPos = getNextPos(guardPos, curDir);
        if (!isInBounds(nextPos, outerBounds)) {
            inBounds = false;
        } else if (crates[nextPos.first].find(nextPos.second) != crates[nextPos.first].end()) {
            curDir = getNextDirection(curDir);
        } else {
            usedSpots.insert(getHashPos(nextPos,  outerBounds));
            guardPos = nextPos;
        } 
    }

    return usedSpots.size();
}
