package work.entity;

public class PowerManager {
    private int power;
    public static PowerManager instance;
    public static synchronized PowerManager getInstance(){
        if (instance==null)
            instance=new PowerManager();
        return instance;
    }

    public PowerManager() {
        this.power = 30;
    }

    //减少
    public void reducePower(int power){
        this.power-=power;
    }

    //增加
    public void addPower(int power){
        this.power+=power;
    }

    public int getPower() {
        return power;
    }
}
