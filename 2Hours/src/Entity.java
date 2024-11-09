public abstract class Entity {
    
    private int maxHp;
    private int hp;
    private int dmg;
    private double luck;
    private boolean isDef = false;
    private int defFactor;
    
    public Entity (int health, int damage, double lck, int def) {
        dmg = damage;
        maxHp = health;
        hp = health;
        if (lck > 1) {
            luck = 0;
        } else {
            luck = lck;
        }
        defFactor = def;
    }

    public int getHealth() {
        return hp;
    }

    public int getMaxHealth() {
        return maxHp;
    }

    public int getDamage() {
        return dmg;
    }

    //Used to adjust health; whether or not its damaging or healing
    public void adjustHealth(int dmg) {
        int defDmg = dmg;
        if (dmg < 0 && isDef) {
            isDef = false;
            defDmg += defFactor;
        }
        hp += defDmg;
    }

    public void defend() {
        isDef = true;
        System.out.println("Defended! Will take " + defFactor + " less flat damage next hit.");
    }

    //Attack action
    public void attack(Entity entity) {

        int proposedAttack = -1*dmg;

        //If rng < luck, double dmg
        if (Math.random() < luck) {
            System.out.println("It was a crit!");
            proposedAttack *= 2;
            //If defending
            if (entity.isDef()) {
                System.out.println("Defended!");
                proposedAttack =- entity.getDefFactor();
            }
        //If defending no crit
        } else if (entity.isDef()) {
            System.out.println("Defended!");
            proposedAttack =- entity.getDefFactor();
        }
        System.out.println("Attack dealt " + -1*proposedAttack + " DMG!");
        entity.adjustHealth(proposedAttack);
    }

    public void luckyAttack(Entity entity) {
        int proposedAttack = dmg*-2;
        double rng = Math.random();
        //Low chance to hit AT ALL initially
        if (rng < 0.3 + luck) {
            double rngAgain = Math.random();
            if (rngAgain > 0.2 + luck) {
                proposedAttack = dmg*-3;
                System.out.println("Massive attack! Dealt " + proposedAttack + " DMG");
                entity.adjustHealth(proposedAttack);
            } else {
                System.out.println("Big attack! Dealth " + proposedAttack + " DMG");
                entity.adjustHealth(proposedAttack);
            }
        } 
    }

    //Heal action
    public void heal() {
        int healthFactor = maxHp/5;
        this.adjustHealth(healthFactor);
        System.out.println("Healed for " + healthFactor + " HP");
    }

    //Checks if defending
    public boolean isDef() {
        return isDef;
    }

    public void defFalse() {
        isDef = false;
    }

    //Retrieves defending factor (flat dmg to be reduced)
    public int getDefFactor() {
        return defFactor;
    }
}
