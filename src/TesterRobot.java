public class TesterRobot extends Robot{
    final static int MAX_TESTING_TIME = 4000;
    final static int MIN_TESTING_TIME = 1000;
    private Garage garage;
    private int carToTestRemaining;
    public TesterRobot(String name, int carToTestRemaining, Garage garage) {
        super(name);
        this.carToTestRemaining = carToTestRemaining;
        this.garage = garage;
    }
    public void run(){
        while (carToTestRemaining > 0){
            System.out.println("O piloto de Testes " + name + " está tentando testar um carro!");
            garage.AccessGarage(this, AccessType.TestCar);
        }
        System.out.println("O piloto de Testes " + name + " terminou seu serviço!");
    }

    @Override
    public void work() {
        try{
            sleep((int) ((Math.random() * (MAX_TESTING_TIME - MIN_TESTING_TIME)) + MIN_TESTING_TIME));
            carToTestRemaining--;
        }catch (InterruptedException err){
            System.out.println("sobrecarga no robô!");
        }
    }
}
