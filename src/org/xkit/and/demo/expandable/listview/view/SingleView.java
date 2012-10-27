package org.xkit.and.demo.expandable.listview.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingleView extends LinearLayout {

	public SingleView(Context context) {
		super(context);

		label = new TextView(context);

		addView(label);
	}

	private TextView label;

	public void setLabelString(String l) {
		label.setText(l);
	}
}
