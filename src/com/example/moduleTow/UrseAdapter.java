package com.example.moduleTow;

import java.util.List;

import com.example.moduleTow.Urses;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import android.widget.BaseAdapter;

public class UrseAdapter extends BaseAdapter {
	private List<Urses> goods;
	private Context context;
	public UrseAdapter(List<Urses> goods,Context context) {
		// TODO Auto-generated constructor stub
		super();
		this.goods=goods;
		this.context=context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return goods.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
