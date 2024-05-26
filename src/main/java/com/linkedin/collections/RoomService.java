package com.linkedin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RoomService {

	private Collection<Room> inventory;

	public RoomService() {
		this.inventory = new LinkedHashSet<>();
	}

	public boolean hasRoom(Room room) {
		return inventory.contains(room);
	}

	public Room[] asArray() {
		return inventory.toArray(new Room[0]);
	}

	public Collection<Room> getByType(String type) {
		return inventory.stream()
				.filter(room -> type.equals(room.getType()))
				.collect(Collectors.toList());
	}

	public Collection<Room> getInventory() {
		return new HashSet<>(this.inventory);
	}

	public void createRoom(String name, String type, int capacity, double price) {
		this.inventory.add(new Room(name, type, capacity, price));
	}

	public void createRooms(Room[] rooms) {
		this.inventory.addAll(Arrays.asList(rooms));
	}

	public void removeRoom(Room room) {
		this.inventory.remove(room);
	}

}
