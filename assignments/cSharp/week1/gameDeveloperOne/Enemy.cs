class Enemy
{
    public string Name;
    private int Health;
    public int _Health
    {
        get { return Health; }
    }
    public List<Attack> AttackList;

    public Enemy(string theName)
    {
        Name = theName;
        Health = 100;
        AttackList = new List<Attack>();
    }
    public void AddAttack(Attack newAttack)
    {
        AttackList.Add(newAttack);
        Console.WriteLine($"{this.Name} learned {newAttack.Name}. Be careful!");
    }
    public void RandomAttack()
    {
        Random rand = new Random();
        int attack = rand.Next(AttackList.Count);
        Console.WriteLine($"{Name} used the attack: {AttackList[attack].Name}");
    }
}