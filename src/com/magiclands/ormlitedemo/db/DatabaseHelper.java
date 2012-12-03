package com.magiclands.ormlitedemo.db;

import java.sql.SQLException;

import com.magiclands.ormlitedemo.db.dao.ItemDao;
import com.magiclands.ormlitedemo.db.dao.RoomDao;

//simple interface for a Database Helper, we could go without it, but we "program to the interface"
public interface DatabaseHelper {

	ItemDao getItemDao() throws SQLException;

	RoomDao getRoomDao() throws SQLException;

}
