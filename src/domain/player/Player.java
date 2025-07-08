package domain.player;

public class Player {

    private final int id;
    private boolean alive = true;

    public Player(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isAlive() {
        return alive;
    }

    public void kill() {
        alive = false;
    }
}
