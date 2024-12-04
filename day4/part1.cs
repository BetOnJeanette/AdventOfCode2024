namespace Day4;

public static class Part1Solver {
    const string SEARCHING_WORD = "XMAS";

    private static bool StaysInBounds(string[] sepLines, int line, int charIdx, int vMov, int hMov){
        int vDist = vMov * (SEARCHING_WORD.Length - 1);
        int hDist = hMov * (SEARCHING_WORD.Length - 1);

        int endLine = vDist + line;
        int endChar = hDist + charIdx;
        
        if (endLine >= sepLines.Length || endLine < 0) return false;
        if (endChar >= sepLines[line].Length || endChar < 0) return false;
        return true;
    }

    private static bool TestIfWordIsPresent(string[] sepLines, int line, int charIdx, int vMov, int hMov){
        if (!StaysInBounds(sepLines, line, charIdx, vMov, hMov)) return false;
        // start at 1: if we're here, we already know we got the first char
        for (int searchIdx = 1; searchIdx < SEARCHING_WORD.Length; searchIdx++){
            int vPos = line + ( vMov * searchIdx );
            int hPos = charIdx + ( hMov * searchIdx );
            if (sepLines[vPos][hPos] != SEARCHING_WORD[searchIdx]) return false;
        }

        return true;
    }

    private static int TestAllDirections(string[] sepLines, int line, int charIdx){
        int output = 0;

        for (int vMov = -1; vMov <= 1; vMov++){
            for (int hMov = -1; hMov <= 1; hMov++){
                if (vMov == 0 && hMov == 0) continue;
                if (TestIfWordIsPresent(sepLines, line, charIdx, vMov, hMov)) output++;
            }
        }

        return output;
    }
    
    public static int GetSol(string[] wordGrid) {
        int output = 0;
        for (int line = 0; line < wordGrid.Length; line++){
            for (int charIdx = 0; charIdx < wordGrid[line].Length; charIdx++){
                if (wordGrid[line][charIdx] != SEARCHING_WORD[0]) continue;
                output += TestAllDirections(wordGrid, line, charIdx); 
            }
        }

        return output;
    }
}
