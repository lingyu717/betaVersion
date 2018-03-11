package com.example.moduleTow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;
import com.example.moduleTow.Urses;

public class Webregister {
	
	private Boolean flag = false;
	public String sendToWeb(Urses user) {
		String result=null;
		try {
			// (1)服务器的访问路径
			Log.i("TAG", "创建连接");
			URL url = new URL(
					new WebUrl().getUrl_register());
			HttpURLConnection http = (HttpURLConnection) url.openConnection(); // 实例化连接对象
			http.setDoInput(true); // 可读可写
			http.setDoOutput(true);
			http.setUseCaches(false); // 不允许使用缓存
			http.setRequestMethod("POST"); // 设置传输方式为 post
			http.connect(); // 创建连接
			Log.i("TAG", "创建连接成功");

			// (2)数据写入流发送至服务器
			OutputStream os = http.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			Log.i("TAG", "创建json 对象");
			JSONArray jsonArray = new JSONArray(); // 创建 json 对象
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("name", user.getName()); // 写入对象数据
			jsonObject.put("password", user.getPassword());
			jsonObject.put("nickname", user.getNickname()); // 写入对象数据
			jsonObject.put("Realname", user.getRealname());
			jsonObject.put("IDCard", user.getIDCard()); // 写入对象数据
			
			
			jsonArray.put(jsonObject);
			bw.write(jsonArray.toString());
			bw.flush();
			Log.i("TAG", "传送json 对象");
			// (3)数据读取流接收数据
			InputStream is = http.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			result = br.readLine(); // 获取web 端返回的数据
			Log.i("TAG", result);
			


			// (4)关闭相关流
			if (os != null)
				os.close();
			if (osw != null)
				osw.close();
			if (is != null)
				is.close();
			if (isr != null)
				isr.close();
			if (br != null)
				br.close();
			if (bw != null)
				bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return  result;

	}
}
