﻿List<Eruption> eruptions = new List<Eruption>()
{
    new Eruption("La Palma", 2021, "Canary Is", 2426, "Stratovolcano"),
    new Eruption("Villarrica", 1963, "Chile", 2847, "Stratovolcano"),
    new Eruption("Chaiten", 2008, "Chile", 1122, "Caldera"),
    new Eruption("Kilauea", 2018, "Hawaiian Is", 1122, "Shield Volcano"),
    new Eruption("Hekla", 1206, "Iceland", 1490, "Stratovolcano"),
    new Eruption("Taupo", 1910, "New Zealand", 760, "Caldera"),
    new Eruption("Lengai, Ol Doinyo", 1927, "Tanzania", 2962, "Stratovolcano"),
    new Eruption("Santorini", 46,"Greece", 367, "Shield Volcano"),
    new Eruption("Katla", 950, "Iceland", 1490, "Subglacial Volcano"),
    new Eruption("Aira", 766, "Japan", 1117, "Stratovolcano"),
    new Eruption("Ceboruco", 930, "Mexico", 2280, "Stratovolcano"),
    new Eruption("Etna", 1329, "Italy", 3320, "Stratovolcano"),
    new Eruption("Bardarbunga", 1477, "Iceland", 2000, "Stratovolcano")
};
// Example Query - Prints all Stratovolcano eruptions
// IEnumerable<Eruption> stratovolcanoEruptions = eruptions.Where(c => c.Type == "Stratovolcano");
// PrintEach(stratovolcanoEruptions, "Stratovolcano eruptions.");
// Execute Assignment Tasks here!

// Helper method to print each item in a List or IEnumerable.This should remain at the bottom of your class!
static void PrintEach(IEnumerable<dynamic> items, string msg = "")
{
    Console.WriteLine("\n" + msg);
    foreach (var item in items)
    {
        Console.WriteLine(item.ToString());
    }
}

// Use LINQ to find the first eruption that is in Chile and print the result.
Eruption? firstInChile = eruptions.FirstOrDefault(c => c.Location == "Chile");
Console.WriteLine(firstInChile);

Console.WriteLine("----------------------------------------------------------");

// Find the first eruption from the "Hawaiian Is" location and print it. If none is found, print "No Hawaiian Is Eruption found."
Eruption? firstInHawaii = eruptions.FirstOrDefault(c => c.Location == "Hawaiian Is");
Console.WriteLine(firstInHawaii);

Console.WriteLine("----------------------------------------------------------");

// Find the first eruption that is after the year 1900 AND in "New Zealand", then print it.
Eruption? firstInNZAfter1900 = eruptions.FirstOrDefault(c => c.Year > 1900 && c.Location == "New Zealand");
Console.WriteLine(firstInNZAfter1900);

Console.WriteLine("----------------------------------------------------------");

// Find all eruptions where the volcano's elevation is over 2000m and print them.
List<Eruption> elevationOver2k = eruptions.Where(c => c.ElevationInMeters > 2000).ToList();
PrintEach(elevationOver2k);

Console.WriteLine("----------------------------------------------------------");

// Find all eruptions where the volcano's name starts with "L" and print them. Also print the number of eruptions found.
List<Eruption> nameStartsWithL = eruptions.Where(c => c.Volcano.StartsWith('L')).ToList();
PrintEach(nameStartsWithL);
System.Console.WriteLine(nameStartsWithL.Count);

Console.WriteLine("----------------------------------------------------------");

// Find the highest elevation, and print only that integer (Hint: Look up how to use LINQ to find the max!)
int highestElevation = eruptions.Max(c => c.ElevationInMeters);
System.Console.WriteLine(highestElevation);

Console.WriteLine("----------------------------------------------------------");

// Use the highest elevation variable to find a print the name of the Volcano with that elevation.
string hasHighestElevation = eruptions.FirstOrDefault(c => c.ElevationInMeters == highestElevation).Volcano;
Console.WriteLine(hasHighestElevation);

Console.WriteLine("----------------------------------------------------------");

// Print all Volcano names alphabetically.
List<string> alphabeticalOrder = eruptions.OrderBy(c => c.Volcano).Select(c => c.Volcano).ToList();
PrintEach(alphabeticalOrder);

Console.WriteLine("----------------------------------------------------------");

// Print all the eruptions that happened before the year 1000 CE alphabetically according to Volcano name.
List<Eruption> before1000Alphabetical = eruptions.Where(c => c.Year < 1000).OrderBy(c => c.Volcano).ToList();
PrintEach(before1000Alphabetical);

Console.WriteLine("----------------------------------------------------------");

// BONUS: Redo the last query, but this time use LINQ to only select the volcano's name so that only the names are printed.
List<string> before1000AlphabeticalOnlyNames = eruptions.Where(c => c.Year < 1000).OrderBy(c => c.Volcano).Select(c => c.Volcano).ToList();
PrintEach(before1000AlphabeticalOnlyNames);