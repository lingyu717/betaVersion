package com.example.moduleTow;

import com.example.moduleTow.Urses;

import com.example.moduleOne.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_login);
		Button bt_registered = (Button) findViewById(R.id.bt_registered);
		bt_registered.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Activity_login.this,
						Activity_register.class);
				// intent.setClass(login.this, register.class);
				startActivity(intent);
			}
		});
		Urses urseinfo = new Urses();
		Button bt_login = (Button) findViewById(R.id.bt_login);
		bt_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 获取登录账号
				// EditText et_name = (EditText) findViewById(R.id.et_name);
				// urseinfo.setName(et_name.getText().toString());

				// 获取登录用户密码
				// EditText et_pwd = (EditText) findViewById(R.id.et_pwd);
				// urseinfo.setPassword(et_pwd.getText().toString());
				// System.out.println(urseinfo.getName()+" "+urseinfo.getPassword());

				new Thread(new Runnable() {
					@Override
					public void run() {
						EditText et_name = (EditText) findViewById(R.id.et_name);
						EditText et_pwd = (EditText) findViewById(R.id.et_pwd);
						Urses urse = new Urses();
						urse.setName(et_name.getText().toString());
						urse.setPassword(et_pwd.getText().toString());
						Weblogin toWeb = new Weblogin();// 实例化该类对象，调用其传输对象方法
						String flag = toWeb.sendToWeb(urse);
						Looper.prepare();
						Toast.makeText(Activity_login.this, flag,
								Toast.LENGTH_SHORT).show();
						Looper.loop();
//						if (flag) {
//							Looper.prepare();
//							Toast.makeText(Activity_login.this, "登录成功！",
//									Toast.LENGTH_SHORT).show();
//							Looper.loop();
//						}
//						else {
//							Looper.prepare();
//							Toast.makeText(Activity_login.this, "账号或密码错误",
//									Toast.LENGTH_SHORT).show();
//							Looper.loop();
//						}
					}

				}).start();
				// login lg = new login();
				// lg.log(urseinfo.getName(), urseinfo.getPassword());
			}
		});
		// Button bt_login = (Button) findViewById(R.id.bt_login);
		// bt_login.setOnClickListener(new OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// Urses urseinfo = new Urses();
		// // 获取登录账号
		// EditText et_name = (EditText) findViewById(R.id.et_name);
		// urseinfo.setName(et_name.getText().toString());
		//
		// // 获取登录用户密码
		// EditText et_pwd = (EditText) findViewById(R.id.et_pwd);
		// urseinfo.setPassword(et_pwd.getText().toString());
		// //System.out.println(urseinfo.getName()+" "+urseinfo.getPassword());
		// Urses urse=new Urses();
		//
		// login lg=new login();
		// lg.log(urseinfo.getName(),urseinfo.getPassword());
		// }
		// });
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
