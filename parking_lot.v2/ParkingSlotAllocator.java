import java.util.List;

import Vehicle.Vehicle;

public interface ParkingSlotAllocator {
    public List<ParkingSlot> getAvailableSlots(List<ParkingSlot> slots, Vehicle vehicle);
    ParkingSlot allocateParkingSlot(List<ParkingSlot> slots, Vehicle vehicleType);
    void releaseParkingSlot(ParkingSlot parkingSlot);
}
