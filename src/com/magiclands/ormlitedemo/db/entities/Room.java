package com.magiclands.ormlitedemo.db.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.magiclands.ormlitedemo.db.dao.impl.RoomDaoImpl;

@DatabaseTable(daoClass = RoomDaoImpl.class)
@Entity
public class Room {

	@Id
	@GeneratedValue
	private int _id;

	@Column(unique = true)
	private String number;

	@ForeignCollectionField(eager = true)
	private Collection<Item> items;

	public Room() {
		super();
	}

	public Room(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public long getId() {
		return _id;
	}

}
