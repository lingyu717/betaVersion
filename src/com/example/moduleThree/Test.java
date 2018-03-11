package com.example.moduleThree;

import java.util.List;


import com.example.data.DBServer;
import com.example.data.QuestionBean;
import com.example.dialog.SumbitDialog;
import com.example.tool.FinishActivity;
import com.example.tool.ShowUpDownDialog;
import com.example.tool.Tolls;
import com.example.moduleOne.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Test extends Activity {
	public TextView question,categor,charpte,questionNum,mTitle,mTitleCh,mTitleQue;
	public RadioButton[] radio=new RadioButton[4];
	public CheckBox[] check=new CheckBox[4];
	public RadioGroup radiogroup,checkgroup;
	public ImageButton btnUp,btnDown;
	public DBServer helper1;
	public int count=0;
	public int arrow=0;
	
	public static int[] vessel=new int[]{0,0};//记录正确个数和错误个数
	static DBServer server=new DBServer();//创建数据库连接
	public static List<QuestionBean> list=server.getQuestion();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_test);
		FinishActivity.getInstance().addActivity(this);

		initView();
		showItem();
	}
	

	private void initView(){
		question=(TextView) findViewById(R.id.questions);
		
		radiogroup=(RadioGroup) findViewById(R.id.radioGroup);
		radio[0]=(RadioButton) findViewById(R.id.radioA);
		radio[1]=(RadioButton) findViewById(R.id.radioB);
		radio[2]=(RadioButton) findViewById(R.id.radioC);
		radio[3]=(RadioButton) findViewById(R.id.radioD);
		
		checkgroup=(RadioGroup) findViewById(R.id.checkGroup);
		check[0]=(CheckBox) findViewById(R.id.cA);
		check[1]=(CheckBox) findViewById(R.id.cB);
		check[2]=(CheckBox) findViewById(R.id.cC);
		check[3]=(CheckBox) findViewById(R.id.cD);
		
		btnUp=(ImageButton) findViewById(R.id.button_up);
		btnDown=(ImageButton) findViewById(R.id.button_down);

		
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

		question.setText(q.QBid+". "+q.QBQuestion);
		String b[]=q.QBChoiceStr.split("&&");
		radio[0].setText(b[0]);
		radio[1].setText(b[1]);
		radio[2].setText(b[2]);
		radio[3].setText(b[3]);
		mTitle.setText(q.CAcategorName);
		mTitleCh.setText("章节："+q.QBChapterNum+"/"+q.CAchapter);
		mTitleQue.setText("题量："+q.QBid+"/"+list.size());
		

		btnUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(arrow>0){
					arrow--;
					QuestionBean q=list.get(arrow);
					question.setText(q.QBid+".  "+q.QBQuestion);
					String b[]=q.QBChoiceStr.split("&&");
					if(q.QBQuestionType==0){
						checkgroup.setVisibility(View.GONE);
						radiogroup.setVisibility(View.VISIBLE);
						radio[0].setText(b[0]);
						radio[1].setText(b[1]);
						radio[2].setText(b[2]);
						radio[3].setText(b[3]);
					}else if(q.QBQuestionType==1){
						checkgroup.setVisibility(View.VISIBLE);
						radiogroup.setVisibility(View.GONE);
						check[0].setText(b[0]);
						check[1].setText(b[1]);
						check[2].setText(b[2]);
						check[3].setText(b[3]);
					}

					mTitleQue.setText("题量："+q.QBid+"/"+list.size());
					
					radiogroup.clearCheck();//清空radiobutton
				}else{
					ShowUpDownDialog show=new ShowUpDownDialog();
					show.showDialog(Test.this, "提示", "已经是第一题了！！", "确定");
				}
			}
		});
		
		//��һ��
		btnDown.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(arrow<list.size()-1){
					arrow++;
					QuestionBean q=list.get(arrow);
					question.setText(q.QBid+".  "+q.QBQuestion);
					String b[]=q.QBChoiceStr.split("&&");
					if(q.QBQuestionType==0){
						checkgroup.setVisibility(View.GONE);
						radiogroup.setVisibility(View.VISIBLE);
						radio[0].setText(b[0]);
						radio[1].setText(b[1]);
						radio[2].setText(b[2]);
						radio[3].setText(b[3]);
					}else if(q.QBQuestionType==1){
						checkgroup.setVisibility(View.VISIBLE);
						radiogroup.setVisibility(View.GONE);
						check[0].setText(b[0]);
						check[1].setText(b[1]);
						check[2].setText(b[2]);
						check[3].setText(b[3]);
					}
					mTitleQue.setText("提示："+q.QBid+"/"+list.size());
					
					radiogroup.clearCheck();
					
				}else{
					if(count<list.size()){
						ShowUpDownDialog ud=new ShowUpDownDialog();
						ud.showDialog(Test.this, "提示", "亲，你还有道题没有做哦！", "确定");
					}
					else{
						showResult(Test.this, "提示", "你做完了，是否提交？", "确定", "取消");
					}
				}
			}
		});
	

		radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				for(int i=0;i<radio.length;i++){
					if(radio[i].isChecked()==true){
						list.get(arrow).userAnswer=String.valueOf(radio[i].getTag()) ;
						count++;
						break;
					}
				}
			}
		});
	}
		
	public void showResult(Context context,String title,String message,String buttonOk,String buttonNo){
		final SumbitDialog sumbit=new SumbitDialog(context, title, message, buttonOk, buttonNo);
		sumbit.show();
		sumbit.setMyCallBack(new SumbitDialog.MyCallBack() {
			
			@Override
			public void ok() {

				new Tolls();
				Tolls.Judge(Test.list, Test.vessel);
		
				Intent intent=new Intent(Test.this, Result.class);
				startActivity(intent);
			}
			
			@Override
			public void cancle() {

				sumbit.dismiss();
			}
		});
	}
}
	


