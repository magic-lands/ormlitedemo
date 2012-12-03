package com.magiclands.ormlitedemo.db.dao;

import com.j256.ormlite.dao.Dao;
import com.magiclands.ormlitedemo.db.entities.Item;

//simple interface for a itemDao, here we could add specific methodes we want use with our application
public interface ItemDao extends Dao<Item, Integer> {

}
