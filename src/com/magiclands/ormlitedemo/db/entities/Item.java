package com.magiclands.ormlitedemo.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.magiclands.ormlitedemo.db.dao.impl.ItemDaoImpl;

@DatabaseTable(daoClass = ItemDaoImpl.class)
@Entity
public class Item {

	@Id
	@GeneratedValue
	private int _id;

	@Column
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "room_id")
	private Room room;

	@Column
	private String name;

	@Column
	private String owner;

	public Item() {
		super();
	}

	public Item(Room room, String name, String owner) {
		super();
		this.name = name;
		this.owner = owner;
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public long getId() {
		return _id;
	}

}
