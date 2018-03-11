package com.example.moduleTow;


import com.example.tool.FinishActivity;
import com.example.moduleOne.R;
import com.example.moduleThree.Test;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;



public class ChapterSelect extends Activity {
	private GridView list_gri;
	private MyAdapter adapter;
	private static String[] names={
		"章节练习","难题练习","错题练习",
		"收藏题目","登录","上传",
	};
	private static int[] ids={
		R.drawable.btn1,R.drawable.btn2,R.drawable.btn3,
		R.drawable.btn4,R.drawable.btn6,R.drawable.btn5,
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chapter_select);
	//	requestWindowFeature(Window.FEATURE_NO_TITLE);
		FinishActivity.getInstance().addActivity(this);
		Button bt6 = (Button) findViewById(R.id.bt1);
		bt6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				Intent intent =new Intent(ChapterSelect.this,Test.class);
				Bundle  xy=new Bundle();
				xy.putInt("key", 1);
				intent.putExtras(xy);
				startActivity(intent);	
			}
		});
		Button bt7 = (Button) findViewById(R.id.bt2);
		bt7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			// TODO Auto-generated method stub
				Intent intent =new Intent(ChapterSelect.this,Test.class);
				Bundle  xy=new Bundle();
				xy.putInt("key", 2);
				intent.putExtras(xy);
				startActivity(intent);
				
			}
		});
		list_gri=(GridView) findViewById(R.id.gri);
		//list_gri.setSelector(new ColorDrawable(Color.TRANSPARENT));
		adapter =new MyAdapter();
    	list_gri.setAdapter(adapter);
    	list_gri.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switch(position){
				case 0:break;
				case 1:break;
				case 2:break;
				case 3:break;
				case 4:
					Intent intent4 = new Intent(ChapterSelect.this,
						Activity_login.class);
						startActivity(intent4);break;
				case 5:
					Intent intent5 = new Intent(ChapterSelect.this,
						Activity_Tbank.class);
						startActivity(intent5);break;
			}
			}
    		
    	});
	}
	public class MyAdapter	extends BaseAdapter{
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return ids.length;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view=View.inflate(ChapterSelect.this,R.layout.xyz4_gri , null);
			ImageView iv_item=(ImageView) view.findViewById(R.id.xyz4_im);
			TextView tv_item=(TextView) view.findViewById(R.id.xyz4_tv);
			iv_item.setImageResource(ids[position]);
			System.out.println(position);
			tv_item.setText(names[position]);
			return view;
		}
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	

}
