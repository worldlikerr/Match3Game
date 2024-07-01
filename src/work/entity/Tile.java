package work.entity;

public class Tile {
    private Type type;
    private boolean isMatched;

    public Tile(Type type) {
        this.type = type;
        this.isMatched = false;
    }

    public Type getType() {
        return type;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }
}
