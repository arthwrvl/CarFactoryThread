public class AssemblerRobot extends Robot{

    final static int MAX_ASSEMBLING_TIME = 4000;
    final static int MIN_ASSEMBLING_TIME = 1000;
    private Track track;
    private Garage garage;
    private int carToAssembleRemaining;
    public AssemblerRobot(String name, int carToAssembleRemaining, Track track, Garage garage) {
        super(name);
        this.carToAssembleRemaining = carToAssembleRemaining;
        this.track = track;
        this.garage = garage;
    }
    public void run(){
        while (carToAssembleRemaining > 0){
            System.out.println("O robô Montador " + name + " está tentando pegar um conjunto!");
            track.AccessTrack(this, AccessType.GetPackage);
        }
        System.out.println("O robô Montador " + name + " terminou seu serviço!");
    }
    @Override
    public void work() {
        try{
            sleep((int) ((Math.random() * (MAX_ASSEMBLING_TIME - MIN_ASSEMBLING_TIME)) + MIN_ASSEMBLING_TIME));
            garage.AccessGarage(this, AccessType.DeliverCar);
            carToAssembleRemaining--;
        }catch (InterruptedException err){
            System.out.println("sobrecarga no robô!");
        }
    }
}
