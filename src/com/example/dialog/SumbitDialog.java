package com.example.dialog;

import com.example.moduleOne.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SumbitDialog extends Dialog implements android.view.View.OnClickListener{
	private String title,message,buttonOkText,buttonNoText;
	private MyCallBack myCallBack;

	public SumbitDialog(Context context,String title,String message,String buttonOkText,String buttonNoText) {
		super(context,R.style.dialog_custom);//加载样式
		this.title=title;
		this.message=message;
		this.buttonOkText=buttonOkText;
		this.buttonNoText=buttonNoText;
	}


	public void setMyCallBack(MyCallBack myCallBack) {
		this.myCallBack = myCallBack;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sumbit);
		initView();//加载控件
	}

	private void initView() {
		TextView	sumbitTitle=(TextView) findViewById(R.id.sumbit_title);
		TextView sumbitText=(TextView) findViewById(R.id.sumbit_text);
		Button sumbitOK=(Button) findViewById(R.id.sumbit_ok);
		Button sumbitCancle=(Button) findViewById(R.id.sumbit_cancle);
		sumbitOK.setOnClickListener(this);
		sumbitCancle.setOnClickListener(this);
		
		sumbitTitle.setText(title);
		sumbitText.setText(message);
		sumbitOK.setText(buttonOkText);
		sumbitCancle.setText(buttonNoText);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.sumbit_ok:{
			myCallBack.ok();
		}
		break;
		case R.id.sumbit_cancle:{
			myCallBack.cancle();
		}
		break;
		}
	}
	public interface MyCallBack {
		void ok();
		void cancle();
	}

}
