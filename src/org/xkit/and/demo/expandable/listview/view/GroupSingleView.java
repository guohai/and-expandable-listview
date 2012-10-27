package org.xkit.and.demo.expandable.listview.view;

import android.content.Context;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GroupSingleView extends RelativeLayout {

	public GroupSingleView(Context context) {
		super(context);

		button = new Button(context);

		button.setClickable(false);
		button.setFocusable(false);

		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

		addView(button, lp);
	}

	private TextView button;

	public void setButtonString(String l) {
		button.setText(l);
	}
}
