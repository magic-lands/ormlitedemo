package com.magiclands.ormlitedemo.db.dao;

import java.util.Collection;

import com.j256.ormlite.dao.Dao;
import com.magiclands.ormlitedemo.db.entities.Item;
import com.magiclands.ormlitedemo.db.entities.Room;

//simple interface for a roomDao, here we could add specific methodes we want use with our application
public interface RoomDao extends Dao<Room, Integer> {

	public Collection<Item>  getItemsInRoomWithNumber(int roomNumber);

}
