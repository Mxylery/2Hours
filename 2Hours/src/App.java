import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        //Temp test values; use whatever you feel like (It is recommended to keep luck below 0.3 or so)
        Player player = new Player(50, 5, 0.1, 1);
        Enemy enemy = new Enemy(50, 5, 0.1, 1);

        Game game = new Game(player, enemy);

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            game.startTurn();
        }
        
        if (player.getHealth() <= 0) {
            System.out.println("You are noob");
        } else {
            System.out.println("You are W");
        }

    }
}
