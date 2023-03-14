// See https://aka.ms/new-console-template for more information
for (int i=1; i<=255; i++) {
    Console.WriteLine(i);
}

Random rand = new Random();
for (int i=1; i<=5; i++) {
    int random = rand.Next(10,20);
    Console.WriteLine(random);
}

int sum = 0;
for (int i=1; i<=5; i++) {
    int random = rand.Next(10,20);
    Console.WriteLine(random);
    sum += random;
}
Console.WriteLine(sum);

for (int i=1; i<=100; i++) {
    if (i % 3 == 0 && i % 5 == 0) {
        continue;
    } else if (i % 3 == 0) {
        Console.WriteLine(i);
    } else if (i % 5 == 0) {
        Console.WriteLine(i);
    }
}

for (int i=1; i<=100; i++) {
    if (i % 3 == 0 && i % 5 == 0) {
        continue;
    } else if (i % 3 == 0) {
        Console.WriteLine("Fizz");
    } else if (i % 5 == 0) {
        Console.WriteLine("Buzz");
    }
}

for (int i=1; i<=100; i++) {
    if (i % 3 == 0 && i % 5 == 0) {
        Console.WriteLine("FizzBuzz");
        continue;
    } else if (i % 3 == 0) {
        Console.WriteLine("Fizz");
    } else if (i % 5 == 0) {
        Console.WriteLine("Buzz");
    }
}