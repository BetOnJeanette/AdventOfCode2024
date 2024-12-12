import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        LinkedList<String> input = new LinkedList<>();
        try {
            Scanner fileScan = new Scanner(inputFile);
            while (fileScan.hasNextLine()) {
                String data = fileScan.nextLine();
                if (data.length() != 0) input.add(data);
            }
            fileScan.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        long part1 = Part1.SolvePart1(input);
        long part2 = Part2.SolvePart2(input);
        System.out.println(String.format("Part 1: %d", part1));
        System.out.println(String.format("Part 2: %d", part2));
    }
}
