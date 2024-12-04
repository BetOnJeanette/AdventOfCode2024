namespace Day4;

class Program {
    static void Main(string[] args){
        string fileContents = "";
        using (StreamReader reader = new StreamReader("input.txt")){
            fileContents = reader.ReadToEnd();
        }
        int sol1 = Part1Solver.GetSol(fileContents);
        Console.WriteLine($"Part 1: {sol1}");
    }
}
