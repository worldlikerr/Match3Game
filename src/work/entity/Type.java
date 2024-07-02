package work.entity;

public enum Type {
    None(0),
    Blue(1),
    Green(2),
    Pink(3),
    Purple(4),
    Red(5),
    Yellow(6);
    private final int index;
    Type(int index) {
         this.index=index;
    };
     public int getIndex(){
         return this.index;
     }
}
