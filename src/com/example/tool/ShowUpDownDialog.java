package com.example.tool;

import com.example.dialog.UpAndDownDialog;

import android.content.Context;

public class ShowUpDownDialog {
	public void showDialog(Context context,String title,String message,String buttonText){
		final UpAndDownDialog ud=new UpAndDownDialog(context, title, message, buttonText);
		ud.show();
		ud.setCallBack(new UpAndDownDialog.MyCallBack() {
			
			@Override
			public void ok() {
				ud.dismiss();
			}
		});
	}

}
