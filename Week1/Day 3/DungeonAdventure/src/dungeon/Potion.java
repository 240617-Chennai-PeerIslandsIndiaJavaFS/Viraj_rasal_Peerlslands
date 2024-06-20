package dungeon;

public class Potion extends Item {
    public Potion(String name) {
        super(name);
    }

    @Override
    public void use(Player player) {
        System.out.println(player.name + " uses " + name);
        player.takeDamage(-20); // Heal the player
    }
}
