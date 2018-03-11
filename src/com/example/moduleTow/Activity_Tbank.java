package com.example.moduleTow;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.moduleOne.R;

import com.example.moduleThree.Test;
import com.example.moduleTow.Emerson;
import com.example.moduleTow.Urses;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class Activity_Tbank extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bank);
		Button bt_go=(Button) findViewById(R.id.bt_go);
		bt_go.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				EditText bt_CategorID=(EditText) findViewById(R.id.bt_CategorID);
				String CategorID=bt_CategorID.getText().toString();
				
				EditText bt_ChapterNum=(EditText) findViewById(R.id.bt_ChapterNum);
				String ChapterNum=bt_ChapterNum.getText().toString();
				
				EditText bt_Question=(EditText) findViewById(R.id.bt_Question);
				String Question=bt_Question.getText().toString();
				
				EditText bt_QuestionType=(EditText) findViewById(R.id.bt_QuestionType);
				String QuestionType=bt_QuestionType.getText().toString();
				
				EditText bt_SelectA=(EditText) findViewById(R.id.bt_SelectA);
				String SelectA=bt_SelectA.getText().toString();
				
				EditText bt_SelectB=(EditText) findViewById(R.id.bt_SelectB);
				String SelectB=bt_SelectB.getText().toString();
				
				EditText bt_SelectC=(EditText) findViewById(R.id.bt_SelectC);
				String SelectC=bt_SelectC.getText().toString();
				
				EditText bt_SelectD=(EditText) findViewById(R.id.bt_SelectD);
				String SelectD=bt_SelectD.getText().toString();
				
				EditText bt_Answer=(EditText) findViewById(R.id.bt_Answer);
				String Answer=bt_Answer.getText().toString();
				
				EditText bt_Explaination=(EditText) findViewById(R.id.bt_Explaination);
				String Explaination=bt_Explaination.getText().toString();
				

				//List<Emerson> list = null;
				//list.add(new Emerson(Emerso, tx1, tx2, tx3, tx4, tx5));
				JSONArray json = new JSONArray();
				JSONObject jo = new JSONObject();
				
				 
				String urlPath = "http://192.168.1.100:8080/test";  
				URL url = null;  
				try {
					url = new URL(urlPath);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
				
				String ChoiceNum="4";
				if(SelectD==null){
					ChoiceNum="3";
				}
				 Date d = new Date();  
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				 String date = sdf.format(d);
				 String owner=new Urses().getName();
				try {
					jo.put("CategorID", CategorID);
					jo.put("ChapterNum", ChapterNum);
					jo.put("Question", Question);
					jo.put("QuestionType", QuestionType);
					jo.put("ChoiceNum",ChoiceNum);
					jo.put("SelectA", SelectA);
					jo.put("SelectB", SelectB);
					jo.put("SelectC", SelectC);
					jo.put("SelectD", SelectD);
					jo.put("Answer", Answer);
					jo.put("Explaination", Explaination);
					jo.put("flag", 0);
					jo.put("date", date);
					jo.put("owner", owner);
					
					json.put(jo);
					String content = String.valueOf(json);  
					
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
					conn.setConnectTimeout(5000);  
					// 设置允许输出  
					conn.setDoOutput(true);  
					conn.setRequestMethod("POST");  
					// 设置User-Agent: Fiddler  
					conn.setRequestProperty("ser-Agent", "Fiddler");  
					// 设置contentType  
					conn.setRequestProperty("Content-Type","application/json");  
					OutputStream os = conn.getOutputStream();  
					os.write(content.getBytes());  
					os.close();  
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				}});	
	Button bt_return = (Button) findViewById(R.id.bt_return);
	bt_return.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
		// TODO Auto-generated method stub
			Activity_Tbank.this.finish();
			
		}
	});
	}
}
