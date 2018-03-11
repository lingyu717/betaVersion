package com.example.moduleThree;


import com.example.tool.FinishActivity;
import com.example.moduleOne.R;

import android.app.Activity;
import android.content.Intent; 
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends Activity {
	TextView title,message1,message2,mTitle;
	Button btnAnswer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_result);
		FinishActivity.getInstance().addActivity(this);
		initView();
		showResult();
	}

	private void initView() {
		title=(TextView) findViewById(R.id.result_title);
		message1=(TextView) findViewById(R.id.result_right_text);
		message2=(TextView) findViewById(R.id.result_wrong_text);
		btnAnswer=(Button) findViewById(R.id.result_answer);
		 mTitle=(TextView) findViewById(R.id.tv_categor);
		 mTitle.setText("结果显示");
		 
		 ImageView mLeftImgv=(ImageView) findViewById(R.id.imgv_leftbtn);
			mLeftImgv.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
		 
	}
	
	private void showResult() {
		title.setText("本次测试：");
		message1.setText("你做对了"+Test.vessel[0]+"道题！");
		message2.setText("你做错了"+Test.vessel[1]+"道题！");
		Test.vessel[0]=0;
		Test.vessel[1]=0;
		btnAnswer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {			
				startActivity(new Intent(Result.this, ShowResult.class));
			}
		});
	}
	
	

}
