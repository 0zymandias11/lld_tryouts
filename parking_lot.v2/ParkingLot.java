import java.util.HashMap;
import java.util.List;

import Vehicle.Vehicle;

public class ParkingLot {
    List<ParkingSlot> slots;
    HashMap<Integer, Ticket> tickets;
    ParkingLot(List<ParkingSlot> slots) {
        this.slots = slots;
        this.tickets = new HashMap<>();
    }

    public Ticket issueTicket(Vehicle vehicle,ParkingSlotAllocator parkingSlotAllocator) {
        SlotAllocationProcessor slotAllocationProcessor = new SlotAllocationProcessor(parkingSlotAllocator);
        ParkingSlot allocatedSlot = slotAllocationProcessor.allocateSlot(slots, vehicle);

        int ticketNum =0;
        if(allocatedSlot !=null){
            Ticket ticket = new Ticket(ticketNum, vehicle.getNumber(), allocatedSlot.id);
            tickets.put(ticketNum, ticket);
            return ticket;
        }
        return null;
    }

    public void releaseTicket(Ticket ticket) {
        for (ParkingSlot slot : slots) {
            if (slot.id == ticket.getSlotId()) {
                SlotAllocationProcessor slotAllocationProcessor = new SlotAllocationProcessor(new AllocateParkingSlot());
                slotAllocationProcessor.releaseSlot(slot);
                tickets.remove(ticket.getId());
                System.out.println("Ticket released for vehicle: " + ticket.getVehicleNumber());
                return;
            }
       }
    }
}
