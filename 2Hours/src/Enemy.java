public class Enemy extends Entity {

    public Enemy (int hp, int dmg, double lck, int def) {
        super(hp, dmg, lck, def);
    }

    public void randomAction(Entity entity) {
        double rng = Math.random();

        //10% chance to lucky attack
        if (rng < 0.1) {
            this.luckyAttack(entity);
        //30% chance to heal if low/defend if not low
        } else if (rng > 0.1 && rng < 0.4) {
            if ((double) this.getHealth()/this.getMaxHealth() < 0.5) {
                this.heal();
            } else {
                this.defend();
            }
        //60% chance to attack
        } else {
            this.attack(entity);
        }
    }

}


