package com.example.dialog;

import com.example.moduleOne.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UpAndDownDialog extends Dialog implements android.view.View.OnClickListener{
	private String title,message,buttonText;
	private MyCallBack myCallBack;
	
	public UpAndDownDialog(Context context,String title,String message,String buttonText) {
		super(context,R.style.dialog_custom);//加载样式
		this.title=title;
		this.message=message;
		this.buttonText=buttonText;
	}
	
	public void setCallBack(MyCallBack myCallBack){
		this.myCallBack=myCallBack;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_updown);
		initView();//加载控件
	}


	private void initView(){
		TextView	mTitle=(TextView) findViewById(R.id.upDown_title);
		TextView mText=(TextView) findViewById(R.id.upDown_text);
		Button mOK=(Button) findViewById(R.id.upDown_ok);
		mOK.setOnClickListener(this);
		mTitle.setText(title);
		mText.setText(message);
		mOK.setText(buttonText);
	}


	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.upDown_ok:{
			myCallBack.ok();
		}
		break;
		}
	}
	public interface MyCallBack {
		void ok();
	}
	
}
