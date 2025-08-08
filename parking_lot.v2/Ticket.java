public class Ticket {
    int id;
    boolean paidStatus;
    String vehicleNumber;
    int parkingSlotId; 

     Ticket(int id, String vehicleNumber, int parkingSlotId) {
         this.id = id;
         this.vehicleNumber = vehicleNumber;
         this.parkingSlotId = parkingSlotId;
         this.paidStatus = false;
     }
    public void markAsPaid() {  
        this.paidStatus = true;
    }

    public int getId() {
        return id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getSlotId() {
        return parkingSlotId;
    }

    
}
