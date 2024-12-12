import java.util.LinkedList;

class Part2 {
    private static Boolean isConcat(long total, int curNum){
        while (curNum > 0){
            if (curNum % 10 != total % 10) return false;
            curNum = curNum / 10;
            total = total / 10;
        }
        return true;
    }
    
    private static long removeConcat(long total, int curNum){
        while (curNum > 0) {
            curNum = curNum / 10;
            total = total / 10;
        }
        return total;
    }
    
    private static Boolean isValidEquation(long total, String[] equationVals, int curIdx){
        int curNum = Integer.parseInt(equationVals[curIdx]);
        int previousIdx = curIdx - 1;
        if (curIdx == 0) return curNum == total;
        if (total <= 0) return false;
        if (isConcat(total, curNum) && isValidEquation(removeConcat(total, curNum), equationVals, previousIdx)) return true;
        if (total % curNum == 0 && isValidEquation(total / curNum, equationVals, previousIdx)) return true;
        return isValidEquation(total - curNum, equationVals, previousIdx);
    }

    private static Boolean isValidEquation(long total, String[] equationVals){
        return isValidEquation(total, equationVals, equationVals.length - 1);
    }

    public static long SolvePart2(LinkedList<String> lines){
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
