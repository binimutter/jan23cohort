// See https://aka.ms/new-console-template for more information

Dictionary<string, int> profiles = new Dictionary<string, int>();
profiles.Add("Ubin", 24);
profiles.Add("Melissa", 40);
profiles.Add("Julie", 31);
profiles.Add("Santa", 200);

// static void average(Dictionary<string, int> MyDictionary)
// {
//     // Your code here
//     int sum = 0;
//     foreach (var profile in MyDictionary)
//     {
//         sum += profile.Value;
//     }
//     Console.WriteLine(sum / MyDictionary.Count);
// }
// average(profiles);
// Dictionary<string, string> TestDict = new Dictionary<string, string>();
// TestDict.Add("HeroName", "Iron Man");
// TestDict.Add("RealName", "Tony Stark");
// TestDict.Add("Powers", "Money and intelligence");
// PrintDictionary(TestDict);

// static int averageAge(int a, int b)
// {
//     return a + b;
// }

// public static void getAverage()
// {
//     Console.WriteLine("==================getAverage================================");
//     int[] numberArray = { 1, 3, 5, 7, 9, 13 };
//     int average = 0;
//     int sum = 0;
//     for (int i = 0; i < numberArray.Length; i++)
//     {
//         sum += numberArray[i];
//     }
//     average = sum / numberArray.Length;
//     Console.WriteLine(average);
// }

static double average(List<int> list)
{
    int sum = 0;
    foreach (int number in list)
    {
        sum += number;
    }

    return (double)sum / list.Count;
}
List<int> grades = new List<int>();
grades.Add(100);
grades.Add(91);
grades.Add(45);

Console.WriteLine(average(grades));

//  static double average(List<int> list)
// {
//     int sum = 0;
//     if (list.Any())
//         foreach (int number in list)
//             sum += number;

//     return (double)sum / list.Count;
// }