// See https://aka.ms/new-console-template for more information

int[] numArray = {0,1,2,3,4,5,6,7,8,9};

string[] nameArray = {"Tim","Martin","Nikki","Sara"};

bool[] boolArray = new bool[10];
boolArray[0] = true;

for (int i=1; i<boolArray.Length; i++) {
    if (i%2==0) {
        boolArray[i] = true;
    } else {
        boolArray[i] = false;
    }
}
foreach (bool i in boolArray) {
    Console.Write("{0} ", i);
}

List<string> flavors = new List<string>();
flavors.Add("mint chocolate chip");
flavors.Add("peppermint");
flavors.Add("vanilla");
flavors.Add("coffee");
flavors.Add("mango");
flavors.Add("pistachio");
// Console.WriteLine("original length of flavors:");
// Console.WriteLine(flavors.Count);
// Console.WriteLine("third flavor:");
// Console.WriteLine(flavors[2]);
flavors.RemoveAt(2);
// Console.WriteLine("new length of flavors:");
// Console.WriteLine(flavors.Count);

Dictionary<string, string> flavorProfile = new Dictionary<string, string>();

// flavorProfile.Add("Tim",Random(flavors));
// flavorProfile.Add("Martin",flavors[index]);
// flavorProfile.Add("Nikki",flavors[index]);
// flavorProfile.Add("Sara",flavors[index]);

foreach (string name in nameArray)
{
    flavorProfile.Add(name, "random flavor here");
};

Random rand = new Random();
List<string> keys = new List<string>(flavorProfile.Keys);
for (int i=0; i<keys.Count; i++) {
    flavorProfile[keys[i]] = flavors[rand.Next(0,4)];
}

foreach (var entry in flavorProfile)
{
    // both console write methods work:
    // Console.WriteLine($"{entry.Key} - {entry.Value}");
    Console.WriteLine(entry.Key + " - " + entry.Value);
}