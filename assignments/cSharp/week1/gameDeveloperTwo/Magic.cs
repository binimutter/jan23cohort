class Magic : Enemy
{
    public Magic(string theName) : base(theName)
    {
        _Health = 80;
        AttackList = new List<Attack>() {
            new Attack("Fireball", 25),
            new Attack("LightningBolt", 20),
            new Attack("StaffStrike", 10)
        };
    }
    public void Heal(Enemy healTarget) {
        healTarget._Health += 40;
        Console.WriteLine($"{this.Name} healed {healTarget.Name} for 40 health. {healTarget.Name} now has {healTarget._Health} health!");
    }
}