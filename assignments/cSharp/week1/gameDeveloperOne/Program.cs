Enemy Thanos = new Enemy("Thanos");
Attack Punch = new Attack("Punch", 5);
Attack Kick = new Attack("Kick", 10);
Attack FingerSnap = new Attack("FingerSnap", 25);

Thanos.AddAttack(Punch);
Thanos.AddAttack(Kick);
Thanos.AddAttack(FingerSnap);

Thanos.RandomAttack();