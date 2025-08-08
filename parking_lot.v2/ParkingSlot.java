public class ParkingSlot {
    int id;
    boolean isOccupied;
    ParkingSlot(int id){
        this.isOccupied = false;
        this.id = id;
    }

    public void occupy(){
        this.isOccupied = true;
    }


}
