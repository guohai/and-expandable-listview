package org.xkit.and.demo.expandable.listview.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GroupTwoLineView extends LinearLayout {

	public GroupTwoLineView(Context context) {
		super(context);

		primary = new TextView(context);

		addView(primary);

		secondary = new TextView(context);

		addView(secondary);
	}

	private TextView primary;

	private TextView secondary;

	public void setPrimaryString(String l) {
		primary.setText(l);
	}

	public void setSecondaryString(String l) {
		secondary.setText(l);
	}
}
