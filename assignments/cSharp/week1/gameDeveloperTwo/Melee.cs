class Melee : Enemy
{
    public Melee(string theName) : base(theName)
    {
        _Health = 120;
        AttackList = new List<Attack>() {
            new Attack("Punch", 20),
            new Attack("Kick", 15),
            new Attack("Tackle", 25)
        };
    }
    public Attack Rage() {
        Random rand = new Random();
        int attack = rand.Next(AttackList.Count);
        AttackList[attack].DamageAmount += 10;
        Console.WriteLine($"{AttackList[attack].Name} now deals {AttackList[attack].DamageAmount} damage");
        return AttackList[attack];
    }
}