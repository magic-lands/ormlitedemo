package com.magiclands.ormlitedemo.db.impl;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.magiclands.ormlitedemo.db.DatabaseHelper;
import com.magiclands.ormlitedemo.db.dao.ItemDao;
import com.magiclands.ormlitedemo.db.dao.RoomDao;
import com.magiclands.ormlitedemo.db.entities.Item;
import com.magiclands.ormlitedemo.db.entities.Room;

//implementation of the DatabaseHeler interface
public class DatabaseHelperImpl extends OrmLiteSqliteOpenHelper implements
		DatabaseHelper {

	private static final String DATABASE_NAME = "ormlitedemo";
	private static final int DATABASE_VERSION = 7;

	private ItemDao bookDao;
	private RoomDao roomDao;

	public DatabaseHelperImpl(Context ctx) {
		super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			// everytime onCreate is called, what happens only if we have no
			// database or the version is incremented, we create the tables we
			// need using an ormlite util class
			TableUtils.createTable(connectionSource, Item.class);
			TableUtils.createTable(connectionSource, Room.class);
		} catch (SQLException e) {
			Log.e("ORMLITEDEMO", e.toString());
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {
		try {
			// everytime the dabase version is incremented we drop all tables
			// and let them create from scratch
			TableUtils.dropTable(connectionSource, Item.class, true);
			TableUtils.dropTable(connectionSource, Room.class, true);
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e("ORMLITEDEMO", e.toString());
		}
	}

	@Override
	public ItemDao getItemDao() throws SQLException {
		// create a dao if not already created
		if (bookDao == null) {
			bookDao = DaoManager.createDao(getConnectionSource(), Item.class);
		}
		return bookDao;
	}

	@Override
	public RoomDao getRoomDao() throws SQLException {
		// create a dao if not already created
		if (roomDao == null) {
			roomDao = DaoManager.createDao(getConnectionSource(), Room.class);
		}
		return roomDao;
	}
}
