package org.xkit.and.demo.expandable.listview;

import java.util.ArrayList;
import java.util.List;

import org.xkit.and.demo.expandable.listview.view.GroupSingleView;
import org.xkit.and.demo.expandable.listview.view.GroupTwoLineView;
import org.xkit.and.demo.expandable.listview.view.SingleView;
import org.xkit.and.demo.expandable.listview.view.TwoLineView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

public class HelloListView extends Activity {

	MyExpandableListAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_list_view);

		ExpandableListView listView = (ExpandableListView) findViewById(R.id.expandable_list_view);

		listView.setIndicatorBounds(180, 210);

		adapter = new MyExpandableListAdapter(getBaseContext());

		listView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_hello_list_view, menu);
		return true;
	}
}

// data holder
class DataItem {

	public DataItem(String k, String e1, String e2, int e3) {
		key = k;
		ext01 = e1;
		ext02 = e2;
		ext03 = e3;
	}

	public DataItem(String k, String e1, int e3) {
		key = k;
		ext01 = e1;
		ext03 = e3;
	}

	public String key;
	public String ext01;
	public String ext02;
	public int ext03;

	public List<DataItem> children = new ArrayList<DataItem>();
}

class MyExpandableListAdapter extends BaseExpandableListAdapter {

	List<DataItem> adapterData;

	private void fillAdapterData() {
		if (adapterData == null) {
			adapterData = new ArrayList<DataItem>();
		}

		DataItem tmpGrpItem = null;
		// group item 1
		adapterData.add(new DataItem("key_resolution", "hello", "expandable", 0));
		tmpGrpItem = adapterData.get(adapterData.size() - 1);

		tmpGrpItem.children.add(new DataItem("1", "child_dd", 0));
		tmpGrpItem.children.add(new DataItem("2", "child_22", 0));

		// group item 2
		adapterData.add(new DataItem("key_quality", "video", "list view button", 0));
		tmpGrpItem = adapterData.get(adapterData.size() - 1);

		tmpGrpItem.children.add(new DataItem("3", "child_vv", 0));
		tmpGrpItem.children.add(new DataItem("4", "child_44",
				R.drawable.logonodpi240));
	}

	MyExpandableListAdapter(Context c) {
		context = c;
		fillAdapterData();
	}

	private Context context;

	@Override
	public int getGroupCount() {
		return adapterData.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return adapterData.get(groupPosition).children.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return adapterData.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return adapterData.get(groupPosition).children.get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		View v;
		if (convertView == null) {
			if (groupPosition == 0) {
				GroupTwoLineView G1 = new GroupTwoLineView(context);
				v = G1;
			} else {
				GroupSingleView G2 = new GroupSingleView(context);
				v = G2;
			}
		} else {
			v = convertView;
		}

		bindGroupView(v, adapterData, groupPosition);

		return v;
	}

	private void bindChildView(View view, List<DataItem> data,
			int groupPosition, int childPosition) {

		if (groupPosition == 0) {
			SingleView C1 = (SingleView) view;

			C1.setLabelString(data.get(groupPosition).children
					.get(childPosition).ext01);
		} else {

			if (childPosition == 0) {
				SingleView C1 = (SingleView) view;
				C1.setLabelString(data.get(groupPosition).children
						.get(childPosition).ext01);
			} else {
				TwoLineView C2 = (TwoLineView) view;

				C2.setLabelString(data.get(groupPosition).children
						.get(childPosition).ext01);
				C2.setIcon(data.get(groupPosition).children.get(childPosition).ext03);
			}
		}

	}

	private void bindGroupView(View view, List<DataItem> data, int groupPosition) {
		if (groupPosition == 0) {
			GroupTwoLineView G1 = (GroupTwoLineView) view;
			G1.setPrimaryString(data.get(groupPosition).ext01);
			G1.setSecondaryString(data.get(groupPosition).ext02);
		} else {
			GroupSingleView G1 = (GroupSingleView) view;
			G1.setButtonString(data.get(groupPosition).ext02);
		}
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		View v;
		if (convertView == null) {
			if (groupPosition == 0) {
				SingleView C1 = new SingleView(context);
				v = C1;
			} else {

				if (childPosition == 0) {
					SingleView C1 = new SingleView(context);
					v = C1;
				} else {
					TwoLineView C2 = new TwoLineView(context);
					v = C2;
				}
			}
		} else {
			v = convertView;
		}

		bindChildView(v, adapterData, groupPosition, childPosition);
		return v;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	@Override
	public int getGroupType(int groupPosition) {
		return groupPosition;
	}

	@Override
	public int getGroupTypeCount() {
		return 2;
	}

	@Override
	public int getChildType(int groupPosition, int childPosition) {
		
		int result = 0;
		
		if (groupPosition == 0)
			result = 0;
		
		if (groupPosition == 1 && childPosition == 0)
			result = 0;
		
		if (groupPosition == 1 && childPosition == 1)
			result = 1;
		return result;
	}

	@Override
	public int getChildTypeCount() {
		return 2;
	}

}
