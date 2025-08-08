import Vehicle.Vehicle;
import java.util.List;
public class SlotAllocationProcessor {
    ParkingSlotAllocator parkingSlotAllocator;
    SlotAllocationProcessor(ParkingSlotAllocator parkingSlotAllocator) {
        this.parkingSlotAllocator = parkingSlotAllocator;
    }

    public ParkingSlot allocateSlot(List<ParkingSlot> slots, Vehicle vehicleType){
        return this.parkingSlotAllocator.allocateParkingSlot(slots, vehicleType);
    }

    public void releaseSlot(ParkingSlot parkingSlot){
        this.parkingSlotAllocator.releaseParkingSlot(parkingSlot);
    }
}
