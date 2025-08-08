package Vehicle;
import java.util.Date;

public class Vehicle {
    String number;
    VehicleType type;
    Date entryTime;

    
    Vehicle(String number, VehicleType type){
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getType() {
        return type;
    }   
    

    public void vehicleEntry(){
        this.entryTime = new Date();
    }
}
