#include <iostream>
#include <fstream>
#include <string>
#include <unordered_set>
#include <utility>
#include <vector>
#include "part1.h"

using namespace std;

unordered_set<int> getCrates(string inputLine){
    int lastFound = -1;
    unordered_set<int> output;
    while(inputLine.find("#", lastFound + 1) != string::npos) {
        lastFound = inputLine.find("#", lastFound + 1);
        output.insert(lastFound);
    }
    return output;
}

int main() {
    string currentLine = "";
    int linesProcessed = 0;
    vector<unordered_set<int>> crates;
    pair<int, int> guardPos;
    int lineWidth;

    ifstream inputFile("input.txt");

    while (getline(inputFile, currentLine)){
        if (currentLine.length() == 0) continue;
        crates.push_back(getCrates(currentLine));
        lineWidth = currentLine.length();
        if (currentLine.find("^") != string::npos){
            guardPos.first = linesProcessed;
            guardPos.second = currentLine.find("^");
        }
        linesProcessed++;
    }

    pair<int, int> outerBounds = pair(linesProcessed, lineWidth);
    int part1 = Part1Solver::solvePart1(crates, guardPos, outerBounds);
    cout << part1 << endl;
}
