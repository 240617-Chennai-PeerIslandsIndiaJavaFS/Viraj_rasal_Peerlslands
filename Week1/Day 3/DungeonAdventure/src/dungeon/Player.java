package dungeon;

public class Player extends Creature implements Interactable {
    public Player(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(Creature target) {
        System.out.println(name + " attacks " + target.name);
        target.takeDamage(10);
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage. Health: " + health);
    }

    @Override
    public void interact(Creature creature) {
        System.out.println(name + " interacts with " + creature.name);
        attack(creature);
    }
}
