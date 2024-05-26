package com.linkedin.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 * 1. Returns a new collection that contains guests from the provided collection
		 * who have indicated the provided room as the first preference in their
		 * preferred
		 * room list.
		 */
		return guests.stream()
				.filter(guest -> {
					if (guest.getPreferredRooms() != null && guest.getPreferredRooms().size() >= 1) {
						return guest.getPreferredRooms().get(0).equals(room);
					}
					return false;
				})
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public void checkIn(Guest guest) {
		/*
		 * 2. Adds a guest to the checkinList, placing members of the loyalty program
		 * ahead of those guests not in the program. Otherwise, guests are arranged in
		 * the
		 * order they were inserted.
		 */

		List<Guest> updatedCheckinList = new ArrayList<Guest>();
		if (!guest.isLoyaltyProgramMember()) {
			checkinList.addLast(guest);
		} else {
			for (Guest g : checkinList) {
				if (g.isLoyaltyProgramMember() || updatedCheckinList.contains(guest)) {
					updatedCheckinList.add(g);
				} else {
					updatedCheckinList.addAll(List.of(guest, g));
				}
			}
			checkinList = updatedCheckinList;
		}
	}

	public void swapPosition(Guest guest1, Guest guest2) {
		/*
		 * 3. Swaps the position of the two provided guests within the checkinList.
		 * If guests are not currently in the list no action is required.
		 */
		int indexGuest1 = checkinList.indexOf(guest1);
		int indexGuest2 = checkinList.indexOf(guest2);
		checkinList.set(indexGuest1, guest2);
		checkinList.set(indexGuest2, guest1);
	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
