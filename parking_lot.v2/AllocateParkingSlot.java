import java.util.ArrayList;
import java.util.List;

import Vehicle.Vehicle;

public class AllocateParkingSlot implements ParkingSlotAllocator {

    @Override
    public List<ParkingSlot> getAvailableSlots(List<ParkingSlot> slots, Vehicle vehicle) {
        List<ParkingSlot> availableSlots = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied) {
                availableSlots.add(slot);
            }   
        }
        return availableSlots;
    }
    @Override
    public ParkingSlot allocateParkingSlot(List<ParkingSlot> slots, Vehicle vehicle) {
        List<ParkingSlot> availableSlots = getAvailableSlots(slots, vehicle);
        ParkingSlot allocatedSlot = null;
        if (!availableSlots.isEmpty()) {
            allocatedSlot = availableSlots.get((int) (Math.random() * availableSlots.size()));
            allocatedSlot.occupy();
            System.out.println("Allocated slot ID: " + allocatedSlot.id + " for vehicle: " + vehicle.getNumber());
        } else {
            System.out.println("No available slots for vehicle: " + vehicle.getNumber());
        }
        return allocatedSlot;
    }

    @Override
    public void releaseParkingSlot(ParkingSlot parkingSlot) {
        if (parkingSlot != null) {
            parkingSlot.isOccupied = false;
            System.out.println("Released slot ID: " + parkingSlot.id);
        } else {
            System.out.println("No slot to release.");
        }
    }
}
