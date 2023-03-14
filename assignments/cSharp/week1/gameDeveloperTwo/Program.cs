Melee Stevens = new Melee("Stevens");
Ranged Bricka = new Ranged("Bricka");
Magic Yoobie = new Magic("Yoobie");

// Stevens.PerformAttack(Bricka, Stevens.AttackList[1]);
// Stevens.PerformAttack(Yoobie, Stevens.Rage());

// Bricka.PerformAttack(Stevens, Bricka.AttackList[0]);
// Bricka.Dash();
// Bricka.PerformAttack(Stevens, Bricka.AttackList[0]);

Yoobie.PerformAttack(Stevens, Yoobie.AttackList[0]);
Yoobie.Heal(Bricka);
Yoobie.Heal(Yoobie);
