package bikeshare.service;

import bikeshare.model.*;
import bikeshare.repository.RideSaver;

import java.util.*;

public class BikeShareService {
    private final Map<Station, Queue<Bike>> stations = new EnumMap<>(Station.class);
    private final Map<String, Rental> activeRentals = new HashMap<>();
    private final RideSaver rideSaver;

    public BikeShareService(RideSaver rideSaver) {
        this.rideSaver = rideSaver;
        initializeStations();
    }

    private void initializeStations() {
        int bikeCounter = 1;
        for (Station station : Station.values()) {
            Queue<Bike> bikes = new LinkedList<>();
            bikes.add(new Bike("B" + bikeCounter++));
            bikes.add(new Bike("B" + bikeCounter++));
            stations.put(station, bikes);
        }
    }

    public void rentBike(String memberId, MemberType type, Station station) {
        if (activeRentals.containsKey(memberId)) {
            throw new IllegalStateException("Member " + memberId + " already has a bike.");
        }
        Queue<Bike> availableBikes = stations.get(station);
        if (availableBikes.isEmpty()) {
            throw new IllegalStateException("No bikes available at " + station);
        }
        
        Bike bike = availableBikes.poll();
        activeRentals.put(memberId, new Rental(memberId, type, bike));
    }

    public Receipt returnBike(String memberId, Station station, int minutes) {
        Rental rental = activeRentals.remove(memberId);
        if (rental == null) {
            throw new IllegalStateException("No active rental found for member " + memberId);
        }
        
        stations.get(station).add(rental.bike());
        
        int fee = minutes * rental.memberType().getRatePerMinute();
        Receipt receipt = new Receipt(rental.bike().id(), minutes, fee);
        
        rideSaver.save(memberId, receipt);
        return receipt;
    }
}