import java.util.Scanner;

public class Game {

    private Player player;
    private Enemy enemy;
    private int turn;
    
    public Game(Player plyr, Enemy enmy) {
        player = plyr;
        enemy = enmy;
        turn = 1;
    }

    public void startTurn() {
        System.out.println("\n------ START OF TURN " + turn + " ------\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("-  Your enemy is at " + enemy.getHealth()
         + "/" + enemy.getMaxHealth() + " HP");
         System.out.println("-  You are at " + player.getHealth()
         + "/" + player.getMaxHealth() + " HP");
        System.out.println("\n --- What action will you take? --- \n");
        System.out.println("| Heal ♥");
        System.out.println("| Attack @");
        System.out.println("| Lucky Attack ♣");
        System.out.println("| Defend [+]");
        System.out.print("\nAction (H/A/L/D): ");
        String inputString;
        do {
        inputString = scanner.nextLine();
        switch (inputString) {
            case "A":
            case "a":
            System.out.println("PLAYER'S TURN");
            player.attack(enemy);
            break;
            case "H":
            case "h":
            System.out.println("PLAYER'S TURN");
            player.heal();
            break;
            case "L":
            case "l":
            System.out.println("PLAYER'S TURN");
            player.luckyAttack(enemy);
            break;
            case "D":
            case "d":
            System.out.println("PLAYER'S TURN");
            player.defend();
            break;
            default: inputString = "";
            System.out.print("\nAction (H/A/L/D): ");
            } 
        } while (inputString.equals(""));

        System.out.println("\nENEMY'S TURN!");
        if (enemy.getHealth() > 0) {
            enemy.randomAction(player);
        }
        System.out.println("\n------ END OF TURN " + turn + " ------\n");
        turn++;
    }


}
