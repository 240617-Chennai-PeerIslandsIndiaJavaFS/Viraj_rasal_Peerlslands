package dungeon;

public class Weapon extends Item {
    public Weapon(String name) {
        super(name);
    }

    @Override
    public void use(Player player) {
        System.out.println(player.name + " uses " + name);
        // Implement weapon-specific functionality
    }
}
