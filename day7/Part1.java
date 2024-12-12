import java.util.LinkedList;

class Part1 {
    private static Boolean isValidEquation(long total, String[] equationVals, int curIdx){
        int curNum = Integer.parseInt(equationVals[curIdx]);
        int previousIdx = curIdx - 1;
        if (curIdx == 0) return curNum == total;
        if (total <= 0) return false;
        if (total % curNum == 0 && isValidEquation(total / curNum, equationVals, previousIdx)) return true;
        return isValidEquation(total - curNum, equationVals, previousIdx);
    }

    private static Boolean isValidEquation(long total, String[] equationVals){
        return isValidEquation(total, equationVals, equationVals.length - 1);
    }

    public static long SolvePart1(LinkedList<String> lines){
        long possibleOps = 0;

        for (String line: lines) {
            String[] splitOps = line.split(": ");
            long total = Long.parseLong(splitOps[0]);
            String[] equationVals = splitOps[1].split(" ");
            if (isValidEquation(total, equationVals)) possibleOps += total;
        }

        return possibleOps;
    }
}
