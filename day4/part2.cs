public static class Part2Solver {
    const char CENTER_LETTER = 'A';

    private static bool HasSlash(string[] wordGrid, int line, int charIdx, int leftDir){
        HashSet<char> usedChars = new HashSet<char>();
        usedChars.Add(wordGrid[line + leftDir][charIdx - 1]);
        usedChars.Add(wordGrid[line - leftDir][charIdx + 1]);
        return usedChars.Contains('M') && usedChars.Contains('S');
    }

    private static bool HasCross(string[] wordGrid, int line, int charIdx){
        return HasSlash(wordGrid, line, charIdx, 1) && HasSlash(wordGrid, line, charIdx, -1);
    }

    public static int GetSol(string[] wordGrid) {
        int output = 0;

        for (int line = 1; line < wordGrid.Length - 1; line++) {
            for (int charIdx = 1; charIdx < wordGrid[line].Length - 1; charIdx++){
                if (!(wordGrid[line][charIdx] == CENTER_LETTER)) continue;
                if (HasCross(wordGrid, line, charIdx)) output++;
            }
        }
        return output;
    }
}
