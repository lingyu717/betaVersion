package com.example.moduleOne;

import java.io.IOException;

import com.example.data.DataBaseHelper;
import com.example.moduleOne.R;
import com.example.moduleTow.ChapterSelect;
import com.example.tool.FinishActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SubjectChoose extends Activity implements OnClickListener{
	private TextView edu_tv;
    private TextView psy_tv;
    private TextView time_tv;
    private Button edu_btn;
    private Button psy_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject_choose);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		FinishActivity.getInstance().addActivity(this);
		DataBaseHelper helper=new DataBaseHelper(this);
		try {
			helper.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initView();
	}
	private void initView() {
		// TODO Auto-generated method stub
		edu_tv =(TextView)findViewById(R.id.edu_tv);
	   	psy_tv=(TextView)findViewById(R.id.psy_tv);
	   	time_tv=(TextView)findViewById(R.id.time_tv);
	   	edu_btn=(Button)findViewById(R.id.edu_btn);
	   	psy_btn=(Button)findViewById(R.id.psy_btn);
	   	edu_btn.setOnClickListener(this);
	   	psy_btn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.edu_btn:{
			Intent intent =new Intent(SubjectChoose.this, ChapterSelect.class);
			startActivity(intent);
		}
		break;
		case R.id.psy_btn:{
			Intent intent =new Intent(SubjectChoose.this, ChapterSelect.class);
			startActivity(intent);
		}
		break;
		}
	}

    
}
