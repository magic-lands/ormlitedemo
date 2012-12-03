package com.magiclands.ormlitedemo;

import java.sql.SQLException;
import java.util.Collection;

import android.app.ListActivity;
import android.os.Bundle;

import com.magiclands.ormlitedemo.db.DatabaseHelper;
import com.magiclands.ormlitedemo.db.dao.ItemDao;
import com.magiclands.ormlitedemo.db.dao.RoomDao;
import com.magiclands.ormlitedemo.db.entities.Item;
import com.magiclands.ormlitedemo.db.entities.Room;
import com.magiclands.ormlitedemo.db.impl.DatabaseHelperImpl;

public class OrmliteMain extends ListActivity {

	// Some DAOs
	RoomDao roomDao;
	ItemDao itemDao;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// get a Database Helper
		DatabaseHelper dbHelper = new DatabaseHelperImpl(this);

		try {
			// Get the DAOs from the Database Helper
			roomDao = dbHelper.getRoomDao();
			itemDao = dbHelper.getItemDao();

			// generate some rooms and items as example
			addSomeRoomsAndItems();

			// As this activity is a ListActivity we must set out Adapter as the
			// ListAdapter
			setListAdapter(new RoomItemAdapter(this, roomDao.queryForAll()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addSomeRoomsAndItems() throws SQLException {
		// first create the rooms
		for (int i = 0; i < 3; i++) {
			Room r = new Room(i + "");
			roomDao.create(r);

			// set for every item its room and create it
			for (int j = 0; j < 3; j++) {
				Item item = new Item(r, "item" + j, "owner" + j);
				itemDao.create(item);
			}
		}
	}
}
