package com.example.moduleThree;

import java.util.List;

import com.example.data.QuestionBean;
import com.example.tool.FinishActivity;
import com.example.tool.ShowReturn;
import com.example.tool.ShowUpDownDialog;
import com.example.moduleOne.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class ShowResult extends Activity {
	private TextView question,answer,categor,charpte,questionNum,mTitle,mTitleCh,mTitleQue;
	private RadioGroup radiogroup;
	private RadioButton[] radio=new RadioButton[4];
	private ImageButton btnUp,btnDown;
	private ScrollView scroll;
	private int arrow=0;
	private static List<QuestionBean> list=Test.list;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_review);
		FinishActivity.getInstance().addActivity(this);
		initView();
		showItem();
	}

	private void initView(){
		question=(TextView) findViewById(R.id.requestions);
		answer=(TextView) findViewById(R.id.reanswer_key);
		radiogroup=(RadioGroup) findViewById(R.id.reradioGroup);
		radio[0]=(RadioButton) findViewById(R.id.reradioA);
		radio[1]=(RadioButton) findViewById(R.id.reradioB);
		radio[2]=(RadioButton) findViewById(R.id.reradioC);
		radio[3]=(RadioButton) findViewById(R.id.reradioD);
		btnUp=(ImageButton) findViewById(R.id.rebutton_up);
		btnDown=(ImageButton) findViewById(R.id.rebutton_down);
		radio[0].setClickable(false);
		radio[1].setClickable(false);
		radio[2].setClickable(false);
		radio[3].setClickable(false);
		
		mTitle=(TextView) findViewById(R.id.tv_categor);
		mTitleCh=(TextView) findViewById(R.id.tv_chapter);
	    mTitleQue=(TextView) findViewById(R.id.tv_num);
		
	    ImageView mLeftImgv=(ImageView) findViewById(R.id.imgv_leftbtn);
		mLeftImgv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	    
	}
	
	private void showItem(){
		QuestionBean q=list.get(arrow);
		
		question.setText(q.QBid+".  "+q.QBQuestion);
		String b[]=q.QBChoiceStr.split("&&");
		radio[0].setText(b[0]);
		radio[1].setText(b[1]);
		radio[2].setText(b[2]);
		radio[3].setText(b[3]);
		mTitle.setText(q.CAcategorName);
		mTitleCh.setText("章节："+q.QBChapterNum+"/"+q.CAchapter);
		mTitleQue.setText("题量："+q.QBid+"/"+list.size());
		answer.setText(q.QBExplaination);
		showChoose(radio, q);
		
		btnUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				radiogroup.clearCheck();
				if(arrow>0){
					arrow--;
					QuestionBean q=list.get(arrow);
					question.setText(q.QBid+".  "+q.QBQuestion);
					String b[]=q.QBChoiceStr.split("&&");
					radio[0].setText(b[0]);
					radio[1].setText(b[1]);
					radio[2].setText(b[2]);
					radio[3].setText(b[3]);
					mTitleQue.setText("题量："+q.QBid+"/"+list.size());
					answer.setText(q.QBExplaination);
					radiogroup.clearCheck();
					showChoose(radio, q);
					
				}else{
					ShowUpDownDialog show=new ShowUpDownDialog();
					show.showDialog(ShowResult.this, "提示", "已经是第一题了！", "确定");
				}
			}
		});
		
		btnDown.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(arrow<list.size()-1){
					arrow++;
					QuestionBean q=list.get(arrow);
					question.setText(q.QBid+".  "+q.QBQuestion);
					String b[]=q.QBChoiceStr.split("&&");
					radio[0].setText(b[0]);
					radio[1].setText(b[1]);
					radio[2].setText(b[2]);
					radio[3].setText(b[3]);
					mTitleQue.setText("题量："+q.QBid+"/"+list.size());
					answer.setText(q.QBExplaination);
					radiogroup.clearCheck();
					showChoose(radio, q);
				}else{
					ShowReturn show=new ShowReturn();
					show.showDialog(ShowResult.this, "提示", "是否退出？", "确定","取消");
				}
			}
		});
	}
	
	private void showChoose(RadioButton[] radiobutton,QuestionBean q){		
			for(int j=0;j<radiobutton.length;j++){
				if(q.userAnswer.equals(String.valueOf(radiobutton[j].getTag()))){
					radiobutton[j].setChecked(true);
					break;
				}
			}
	}

}
