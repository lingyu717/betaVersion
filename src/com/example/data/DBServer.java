package com.example.data;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBServer {
	private SQLiteDatabase db;
	private Cursor cursor;
	
	public DBServer(){
		db=SQLiteDatabase.openDatabase("/data/data/com.example.moduleOne/databases/QuestionBase.db", null, SQLiteDatabase.OPEN_READWRITE);
		cursor=db.rawQuery("select * from QuestionBank,Categor where QuestionBank.CategorID=Categor.CTID and QBID<=5", null);
	}
	
	public List<QuestionBean> getQuestion(){
		List<QuestionBean> list=new ArrayList<QuestionBean>();
		
		if(cursor.getCount()>0){//判断是否有数据
			cursor.moveToFirst();//移动游标到第一行
			for(int i=0;i<cursor.getCount();i++){
				cursor.moveToPosition(i);//游标移动到指定行
				QuestionBean q=new QuestionBean();
				
				q.QBid=cursor.getInt(cursor.getColumnIndex("QBID"));
				q.QBCategorID=cursor.getInt(cursor.getColumnIndex("CategorID"));
				q.QBChapterNum=cursor.getInt(cursor.getColumnIndex("ChapterNum"));
				q.QBQuestion=cursor.getString(cursor.getColumnIndex("Question"));
				q.QBQuestionType=cursor.getInt(cursor.getColumnIndex("QuestionType"));
				q.QBChoiceNum=cursor.getInt(cursor.getColumnIndex("ChoiceNum"));
				q.QBChoiceStr=cursor.getString(cursor.getColumnIndex("ChoiceStr"));
				q.QBAnswer=cursor.getString(cursor.getColumnIndex("Answer"));
				q.QBExplaination=cursor.getString(cursor.getColumnIndex("Explaination"));
				q.QBSourceID=cursor.getInt(cursor.getColumnIndex("SourceID"));
				q.userAnswer=null;
				q.CAcategorName=cursor.getString(cursor.getColumnIndex("Name"));
				q.CAchapter=cursor.getInt(cursor.getColumnIndex("Chapter"));
				
				list.add(q);
			}
		}
		return list;
	}

}
