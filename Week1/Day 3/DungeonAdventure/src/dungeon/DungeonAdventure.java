package dungeon;

import java.util.Scanner;

public class DungeonAdventure {
    private static Scanner scanner = new Scanner(System.in);
    private static Player player = new Player("Hero", 100);

    public static void main(String[] args) {
        while (player.isAlive()) {
            System.out.println("You are in a dark dungeon.");
            System.out.println("You see a door. Do you want to enter? (yes/no)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                enterRoom();
            } else {
                break;
            }
        }

        if (!player.isAlive()) {
            System.out.println("You have been defeated!");
        } else {
            System.out.println("You have exited the dungeon.");
        }
    }

    private static void enterRoom() {
        Creature enemy = Math.random() > 0.5 ? new Goblin("Goblin", 30) : new Dragon("Dragon", 50);
        System.out.println("You encounter a " + enemy.name);

        while (enemy.isAlive() && player.isAlive()) {
            System.out.println("Do you want to (1) attack or (2) use an item?");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                player.interact(enemy);
                if (enemy.isAlive() && enemy instanceof Interactable) {
                    ((Interactable) enemy).interact(player);
                }
            } else if (choice.equals("2")) {
                useItem();
            }
        }
    }

    private static void useItem() {
        Item potion = new Potion("Health Potion");
        potion.use(player);
    }
}
