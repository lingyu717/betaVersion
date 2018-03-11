package com.example.tool;

import android.content.Context;

import com.example.dialog.SumbitDialog;

public class ShowReturn {
	public void showDialog(Context context,String title,String message,String buttonText1,String buttonText2){
		final SumbitDialog ud=new SumbitDialog(context, title, message, buttonText1,buttonText2);
		ud.show();
		ud.setMyCallBack(new SumbitDialog.MyCallBack() {
			
			@Override
			public void ok() {
				// TODO Auto-generated method stub
				FinishActivity.getInstance().exit();
			}
			
			@Override
			public void cancle() {
				// TODO Auto-generated method stub
				ud.dismiss();
			}
		});
	}

}
