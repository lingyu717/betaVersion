package com.example.moduleTow;

import com.example.moduleTow.Urses;

import com.example.moduleOne.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_register extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_register);
		Button btn_register = (Button) findViewById(R.id.btn_register);
		btn_register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						Urses urseinfo = new Urses();
						// 获取注册账号
						EditText et_username = (EditText) findViewById(R.id.et_username);
						urseinfo.setName(et_username.getText().toString());

						// 获取注册密码
						EditText et_userpassword = (EditText) findViewById(R.id.et_userpassword);
						urseinfo.setPassword(et_userpassword.getText()
								.toString());

						// 获取注册昵称
						EditText et_user_pwd = (EditText) findViewById(R.id.et_user_pwd);
						urseinfo.setNickname(et_user_pwd.getText().toString());

						// 获取注册真是姓名
						EditText et_name = (EditText) findViewById(R.id.et_name);
						urseinfo.setRealname(et_name.getText().toString());

						// 获取注册身份证号
						EditText et_idcard = (EditText) findViewById(R.id.et_idcard);
						urseinfo.setIDCard(et_idcard.getText().toString());

						Webregister toWeb = new Webregister();// 实例化该类对象，调用其传输对象方法
						
						
						String flag = toWeb.sendToWeb(urseinfo);
						Looper.prepare();
						Toast.makeText(Activity_register.this, flag,
								Toast.LENGTH_SHORT).show();
						Looper.loop();
						
						
//						if (flag) {
//							Looper.prepare();
//							Toast.makeText(Activity_register.this, "注册成功！",
//									Toast.LENGTH_SHORT).show();
//							Looper.loop();
//						} else {
//							Looper.prepare();
//							Toast.makeText(Activity_register.this, "网络繁忙！",
//									Toast.LENGTH_SHORT).show();
//							Looper.loop();
//						}
					}

				}).start();
				// register re = new register();
				// re.res(urseinfo.getName(), urseinfo.getPassword(),
				// urseinfo.getNickname(), urseinfo.getRealname(),
				// urseinfo.getIDCard());
			}
		});

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
