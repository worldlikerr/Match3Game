package work.entity;

public class StarsManager {
    private static int LEVEL1;
    private static int LEVEL2;
    private static int LEVEL3;
    private static int LEVEL4;
    public static int level;
    public static int points;

    public StarsManager(int LEVEL1, int LEVEL2, int LEVEL3, int LEVEL4) {
        StarsManager.LEVEL1 = LEVEL1;
        StarsManager.LEVEL2 = LEVEL2;
        StarsManager.LEVEL3 = LEVEL3;
        StarsManager.LEVEL4 = LEVEL4;
        points=0;
    }

    //结算时调用
    public static void getLevel() {
        if (points >= LEVEL4) {
            level = 4;
        } else if (points >= LEVEL3) {
            level = 3;
        } else if (points >= LEVEL2) {
            level = 2;
        } else if (points >= LEVEL1) {
            level = 1;
        } else {
            level = 0;
        }
    }

    //结算时调用
    public static void addPower(){
        int power=0;
        power=switch (level){
            case 1-> 0;
            case 2-> 2;
            case 3-> 5;
            case 4-> 10;
            default -> 0;
        };

        PowerManager powerManager=PowerManager.getInstance();
        powerManager.addPower(power);
    }
}
