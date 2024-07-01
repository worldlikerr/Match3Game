package work.entity;

public enum Type {
    Red(1),
    Yellow(2),
    Blue(3),
    Green(4),
    Pink(5),
    Purple(6);
    private final int index;
    Type(int index) {
         this.index=index;
    };
     public int getIndex(){
         return this.index;
     }
}
