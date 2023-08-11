
public class BuilderRobot extends Robot{
    final static int MAX_BUILDING_TIME = 4000;
    final static int MIN_BUILDING_TIME = 1000;
    private Track track;
    private int packagesToBuildRemaining;


    public BuilderRobot(String name, int packagesToBuildRemaining, Track track){
        super(name);
        this.packagesToBuildRemaining = packagesToBuildRemaining;
        this.track = track;
    }
    public void run(){
        while (packagesToBuildRemaining > 0){
            work();
        }
        System.out.println("O robô Construtor " + name + " terminou seu serviço!");
    }


    public void work(){
        try{
            sleep((int) ((Math.random() * (MAX_BUILDING_TIME - MIN_BUILDING_TIME)) + MIN_BUILDING_TIME));
            System.out.println("O robô Construtor " + name + " está tentando entregar um conjunto!");
            track.AccessTrack(this, AccessType.DeliverPackage);
            packagesToBuildRemaining--;
        }catch (InterruptedException err){
            System.out.println("sobrecarga no robô!");
        }


    }

}
