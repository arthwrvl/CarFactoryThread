public abstract class Robot extends Thread {
    protected String name;

    public Robot(String name){
        this.name = name;
    }


    public String getRobotName() {
        return name;
    }

    public abstract void work();
}
