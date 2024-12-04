namespace Day4;

class Program {
    static void Main(string[] args){
        string fileContents = "";
        using (StreamReader reader = new StreamReader("input.txt")){
            fileContents = reader.ReadToEnd();
        }
        string[] wordGrid = fileContents.Split("\n").Where(line => line.Length > 0).ToArray();
        int sol1 = Part1Solver.GetSol(wordGrid);
        Console.WriteLine($"Part 1: {sol1}");
    }
}
