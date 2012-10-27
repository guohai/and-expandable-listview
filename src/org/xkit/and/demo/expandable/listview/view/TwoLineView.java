package org.xkit.and.demo.expandable.listview.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TwoLineView extends RelativeLayout {

	public TwoLineView(Context context) {
		super(context);

		label = new TextView(context);

		icon = new ImageView(context);

		RelativeLayout.LayoutParams lp0 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp0.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lp0.addRule(RelativeLayout.CENTER_HORIZONTAL);
		addView(label, lp0);

		RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		lp1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lp1.addRule(RelativeLayout.CENTER_HORIZONTAL);
		addView(icon, lp1);
	}

	private TextView label;

	private ImageView icon;

	public void setLabelString(String l) {
		label.setText(l);
	}

	public void setIcon(int resId) {
		icon.setImageResource(resId);
	}
}
