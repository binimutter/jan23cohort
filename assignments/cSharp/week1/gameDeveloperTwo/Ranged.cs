class Ranged : Enemy
{
    public int Distance;
    public Ranged(string theName) : base(theName)
    {
        Distance = 5;
        AttackList = new List<Attack>() {
            new Attack("ShootArrow", 20),
            new Attack("ThrowKnife", 15),
        };
    }
    public override void PerformAttack(Enemy Target, Attack ChosenAttack) {
        if (this.Distance < 10) {
            Console.WriteLine($"{this.Name} is too close! Unable to attack.");
        } else {
            base.PerformAttack(Target, ChosenAttack);
        }
    }
    public int Dash() {
        this.Distance = 20;
        Console.WriteLine($"{this.Name} now has a distance of 20!");
        return this.Distance;
    }
} 