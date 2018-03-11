package com.example.tool;

import java.util.List;

import com.example.data.QuestionBean;

public class Tolls {
	public static void Judge(List<QuestionBean> list,int[] vessel){
		for(int i=0;i<list.size();i++){
			if(list.get(i).userAnswer.equals(list.get(i).QBAnswer)){
				vessel[0]++;//正确
			}
			else{
				vessel[1]++;//错误
			}
		}
	}

}
