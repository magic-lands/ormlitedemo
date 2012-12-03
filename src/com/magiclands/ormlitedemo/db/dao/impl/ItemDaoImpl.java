package com.magiclands.ormlitedemo.db.dao.impl;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.magiclands.ormlitedemo.db.dao.ItemDao;
import com.magiclands.ormlitedemo.db.entities.Item;

public class ItemDaoImpl extends BaseDaoImpl<Item, Integer> implements ItemDao {

	public ItemDaoImpl(ConnectionSource connectionSource)
			throws SQLException {
		super(connectionSource, Item.class);
	}

}
