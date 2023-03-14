// See https://aka.ms/new-console-template for more information
static void PrintList(List<string> MyList)
{
    // Your code here

    // 1:
    foreach (var item in MyList)
    {
        Console.WriteLine(item);
    }

    // 2:
    for (int i = 0; i < MyList.Count; i++)
    {
        Console.WriteLine(MyList[i]);
    }

    // 3:
    MyList.ForEach(p => Console.WriteLine(p));

    // 4:
    Console.WriteLine(string.Join(", ", MyList));
}
List<string> TestStringList = new List<string>() { "Harry", "Steve", "Carla", "Jeanne" };
PrintList(TestStringList);

static void SumOfNumbers(List<int> IntList)
{
    // Your code here
    int sum = 0;
    foreach(var num in IntList) {
        sum += num;
    }
    Console.WriteLine(sum);
}
List<int> TestIntList = new List<int>() {2,7,12,9,3};
// You should get back 33 in this example
SumOfNumbers(TestIntList);

static int FindMax(List<int> IntList)
{
    // Your code here
    int max = IntList[0];
    foreach(var num in IntList) {
        if (num > max) {
            max = num;
        } else {
            continue;
        }
    }
    Console.WriteLine(max);
    return max;
}
List<int> TestIntList2 = new List<int>() {-9,12,10,3,17,5};
// You should get back 17 in this example
FindMax(TestIntList2);

static List<int> SquareValues(List<int> IntList)
{
    // Your code here
    List<int> results = new List<int>();
    foreach (var num in IntList)
    {
        int squared = num * num;
        results.Add(squared);
    }
    Console.WriteLine("[{0}]", string.Join(", ", results));
    return results;
}
List<int> TestIntList3 = new List<int>() { 1, 2, 3, 4, 5 };
// You should get back [1,4,9,16,25], think about how you will show that this worked
SquareValues(TestIntList3);

static int[] NonNegatives(int[] IntArray)
{
    // Your code here
    int[] results = new int[IntArray.Length];
    for (int i = 0; i < IntArray.Length; i++)
    {
        int notNeg = IntArray[i];
        if (IntArray[i] < 0)
        {
            notNeg = 0;
            results[i] = notNeg;
        }
        else
        {
            results[i] = IntArray[i];
        }
    }
    Console.WriteLine("[{0}]", string.Join(", ", results));
    return results;
    // you can also make results array a list at creation and use results.ToArray() to convert it into an array before return
}
int[] TestIntArray = new int[] { -1, 2, 3, -4, 5 };
// You should get back [0,2,3,0,5], think about how you will show that this worked
NonNegatives(TestIntArray);

static void PrintDictionary(Dictionary<string,string> MyDictionary)
{
    // Your code here
    foreach(var entry in MyDictionary) {
        Console.WriteLine("{0}: {1}", entry.Key, entry.Value);
    }
}
Dictionary<string,string> TestDict = new Dictionary<string,string>();
TestDict.Add("HeroName", "Iron Man");
TestDict.Add("RealName", "Tony Stark");
TestDict.Add("Powers", "Money and intelligence");
PrintDictionary(TestDict);

static bool FindKey(Dictionary<string,string> MyDictionary, string SearchTerm)
{
    // Your code here
    foreach(var entry in MyDictionary) {
        if (entry.Key == SearchTerm) {
            return true;
        }
    }
    return false;
}
// Use the TestDict from the earlier example or make your own
// This should print true
Console.WriteLine(FindKey(TestDict, "RealName"));
// This should print false
Console.WriteLine(FindKey(TestDict, "Name"));

// Ex: Given ["Julie", "Harold", "James", "Monica"] and [6,12,7,10], return a dictionary
// {
//	"Julie": 6,
//	"Harold": 12,
//	"James": 7,
//	"Monica": 10
// } 

static Dictionary<string,int> GenerateDictionary(List<string> Names, List<int> Numbers)
{
    // Your code here
    Dictionary<string,int> results = new Dictionary<string, int>();
    for (int i = 0; i < Names.Count; i++) {
        results.Add(Names[i], Numbers[i]);
    }
    foreach(var entry in results) {
        Console.WriteLine("{0}: {1}", entry.Key, entry.Value);
    }
    return results;
}
// We've shown several examples of how to set your tests up properly, it's your turn to set it up!
// Your test code here
List<string> TestNamesList = new List<string>() {"Julie", "Harold", "James", "Monica"};
List<int> TestNumbersList = new List<int>() {6,12,7,10};
GenerateDictionary(TestStringList, TestIntList);




