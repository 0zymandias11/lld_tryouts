package elevator;
public class Main {
    public static void main(String[] args) throws Exception {
        ElevatorDriver driver = ElevatorDriver.getInstance(2, new DefaultElevatorCreator());

        // Simulate a few hall/car calls
        driver.handle(new Request("r1", 6, CallType.HALL_UP));
        driver.handle(new Request("r2", 2, CallType.HALL_DOWN));
        driver.handle(new Request("r3", 9, CallType.HALL_DOWN));
        driver.handle(new Request("r4", 4, CallType.CAR));

        // Simple scheduler loop
        for (int t = 0; t < 30; t++) {
            driver.tickAll();
            Thread.sleep(120);
        }
    }
}