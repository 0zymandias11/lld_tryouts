import java.util.ArrayList;
import java.util.List;

import Vehicle.Bike;
import Vehicle.Car;
import Vehicle.Truck;
import Vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        // 1) Build a small lot
        List<ParkingSlot> slots = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            slots.add(new ParkingSlot(i));
        }

        ParkingLot lot = new ParkingLot(slots);

        // 2) Choose an allocation strategy
        ParkingSlotAllocator allocator = new AllocateParkingSlot();

        // (optional) The Processor now lives here, but ParkingLot.issueTicket(...)
        // already accepts a ParkingSlotAllocator, so we don't actually need to
        // use SlotAllocationProcessor directly in the driver. ParkingLot will.
        // SlotAllocationProcessor processor = new SlotAllocationProcessor(allocator);

        // 3) Create some vehicles
        Vehicle car1   = new Car("WB-01-A-1234");
        Vehicle bike1  = new Bike("WB-02-B-5678");
        Vehicle truck1 = new Truck("WB-03-C-9999");

        // 4) Issue tickets
        Ticket t1 = lot.issueTicket(car1, allocator);
        Ticket t2 = lot.issueTicket(bike1, allocator);
        Ticket t3 = lot.issueTicket(truck1, allocator);

        System.out.println("=== Issued Tickets ===");
        printTicket(t1);
        printTicket(t2);
        printTicket(t3);

        // 5) Checkout (release) one vehicle
        System.out.println("\n=== Release car1 ===");
        if (t1 != null) {
            lot.releaseTicket(t1);  // internally uses AllocateParkingSlot for release
        }

        // 6) Park another vehicle after freeing a slot
        Vehicle car2 = new Car("WB-04-D-0001");
        Ticket t4 = lot.issueTicket(car2, allocator);

        System.out.println("\n=== Issued After Release ===");
        printTicket(t4);

        // 7) Cleanup: release remaining
        System.out.println("\n=== Final Releases ===");
        if (t2 != null) lot.releaseTicket(t2);
        if (t3 != null) lot.releaseTicket(t3);
        if (t4 != null) lot.releaseTicket(t4);
    }

    private static void printTicket(Ticket t) {
        if (t == null) {
            System.out.println("No ticket issued (possibly no available slot).");
            return;
        }
        System.out.printf("Ticket[id=%d, vehicle=%s, slot=%d]%n",
                t.getId(), t.getVehicleNumber(), t.getSlotId());
    }
}
