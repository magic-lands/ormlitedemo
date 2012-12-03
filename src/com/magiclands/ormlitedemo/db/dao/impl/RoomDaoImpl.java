package com.magiclands.ormlitedemo.db.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.magiclands.ormlitedemo.db.dao.RoomDao;
import com.magiclands.ormlitedemo.db.entities.Item;
import com.magiclands.ormlitedemo.db.entities.Room;

public class RoomDaoImpl extends BaseDaoImpl<Room, Integer> implements RoomDao {

	public RoomDaoImpl(ConnectionSource connectionSource) throws SQLException {
		super(connectionSource, Room.class);
	}

	@Override
	public Collection<Item> getItemsInRoomWithNumber(int roomNumber) {
		// create a matching object, which will be used to query the DB, by
		// properties set on the matching object, some kind of "QueryByExample"
		Room match = new Room(Integer.toString(roomNumber));
		try {
			Collection<Room> rooms = queryForMatching(match);
			Collection<Item> items = new ArrayList<Item>();
			for (Room r : rooms) {
				items.addAll(r.getItems());
			}
			return items;
		} catch (SQLException e) {
			return new ArrayList<Item>();
		}
	}

}
