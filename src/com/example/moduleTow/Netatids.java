package com.example.moduleTow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.example.moduleTow.Conatants;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public  class Netatids {
	//public static void GetGoods(Handler handler,String url){
	public static void GetGoods(String url){
		HttpClient client=new DefaultHttpClient();
		
		//生成使用POST方法的请求对象
		HttpPost post=new HttpPost();
		
		//NameValuePair对象代表了一个需要发往服务器的键值对
		List<NameValuePair> params=new ArrayList<NameValuePair>();		
		NameValuePair name=new BasicNameValuePair("", "");
		NameValuePair password=new BasicNameValuePair("", "");
		
		
	    //将准备好的键值对对象放置在一个List当中
		params.add(name);
		params.add(password);
		
		
		//Message msg=handler.obtainMessage();
		try {
			  //创建代表请求体的对象（注意，是请求体）
			HttpEntity requestEntity =new UrlEncodedFormEntity(params,HTTP.UTF_8);
			  //将请求体放置在请求对象当中
			post.setEntity(requestEntity );
			
			
			HttpResponse rsp=client.execute(post);
			String retStr="";
			
		     //执行请求对象
			if(rsp.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				//从相应对象当中取出数据，放到entity当中
				//retStr=EntityUtils.toString(rsp.getEntity(),"utf-8");
				HttpEntity entity = rsp.getEntity();
				BufferedReader reader = new BufferedReader(
				new InputStreamReader(entity.getContent()));
				String result = reader.readLine();
				Log.d("HTTP", "POST:" + result);
				//JSONObject rs=new JSONObject(retStr);
				//msg.what=Conatants.x_cg;				
			}
			else {
				//msg.what=Conatants.x_sb;
			}
		} catch (Exception e) {
			//msg.what=Conatants.x_sb;
		}
		//handler.sendMessage(msg);
		
		
	}
}
