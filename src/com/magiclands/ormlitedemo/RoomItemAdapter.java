package com.magiclands.ormlitedemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.magiclands.ormlitedemo.db.entities.Item;
import com.magiclands.ormlitedemo.db.entities.Room;

/**
 * Simple adapter used for demo and works with room items
 *
 */
public class RoomItemAdapter extends ArrayAdapter<Room> {
	private Context ctx;
	private List<Room> rooms;

	public RoomItemAdapter(Context context, Collection<Room> rooms) {
		super(context, R.layout.rowlayout, rooms.toArray(new Room[1]));
		this.ctx = context;
		this.rooms = new ArrayList<Room>(rooms);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.rowlayout, parent, false);
		TextView room = (TextView) row.findViewById(R.id.room);
		TextView items = (TextView) row.findViewById(R.id.items);

		room.setText(rooms.get(position).getNumber());
		StringBuilder sb = new StringBuilder();
		for (Item i : rooms.get(position).getItems()) {
			sb.append(i.getName()).append("(").append(i.getOwner())
					.append("),");
		}
		if (sb.length() != 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		items.setText(sb.toString());
		return row;

	}

}
