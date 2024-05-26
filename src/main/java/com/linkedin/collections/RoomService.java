package com.linkedin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RoomService {

	private Collection<Room> rooms;

	public RoomService() {
		rooms = new ArrayList<Room>();
	}

	public Collection<Room> getInventory() {
		return rooms;
	}

	public void createRoom(String name, String type, int capacity, double rate) {
		rooms.add(new Room(name, type, capacity, rate));
	}

	public void createRooms(Room[] rooms) {
		this.rooms.addAll(Arrays.asList(rooms));
	}

	public void removeRoom(Room room) {
		this.rooms.remove(room);
	}
}
