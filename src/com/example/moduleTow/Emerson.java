package com.example.moduleTow;

public class Emerson {

	 private int QBID;
	 
	 //科目id  教育学为1  心理学为2
	 private int CategorID ;
	 //第几章
	 private int ChapterNum ;
	 //问题
	 private String Question;
	 //问题类型
	 private int QuestionType ;
	 //选择个数
	 private int ChoiceNum;
	 //选项A
	 private String SelectA;
	 private String SelectB;
	 private String SelectC;
	 private String SelectD;
	 //答案
	 private String Answer;
	 //解释
	 private String Explaination;
	//不传
	 private int SourceID;
	 
	 //是否审核  默认为0 
	 private int flag;
	 //上传日期
	 private String date;
	 //发布者
	 private String owner;
	 
	 
	 
	 
	public Emerson(int categorID, int chapterNum, String question, int questionType, int choiceNum, String selectA,
			String selectB, String selectC, String selectD, String answer, String explaination, String date,
			String owner) {
		super();
		CategorID = categorID;
		ChapterNum = chapterNum;
		Question = question;
		QuestionType = questionType;
		ChoiceNum = choiceNum;
		SelectA = selectA;
		SelectB = selectB;
		SelectC = selectC;
		SelectD = selectD;
		Answer = answer;
		Explaination = explaination;
		this.date = date;
		this.owner = owner;
	}
	public int getQBID() {
		return QBID;
	}
	public void setQBID(int qBID) {
		QBID = qBID;
	}
	public int getCategorID() {
		return CategorID;
	}
	public void setCategorID(int categorID) {
		CategorID = categorID;
	}
	public int getChapterNum() {
		return ChapterNum;
	}
	public void setChapterNum(int chapterNum) {
		ChapterNum = chapterNum;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public int getQuestionType() {
		return QuestionType;
	}
	public void setQuestionType(int questionType) {
		QuestionType = questionType;
	}
	public int getChoiceNum() {
		return ChoiceNum;
	}
	public void setChoiceNum(int choiceNum) {
		ChoiceNum = choiceNum;
	}
	public String getSelectA() {
		return SelectA;
	}
	public void setSelectA(String selectA) {
		SelectA = selectA;
	}
	public String getSelectB() {
		return SelectB;
	}
	public void setSelectB(String selectB) {
		SelectB = selectB;
	}
	public String getSelectC() {
		return SelectC;
	}
	public void setSelectC(String selectC) {
		SelectC = selectC;
	}
	public String getSelectD() {
		return SelectD;
	}
	public void setSelectD(String selectD) {
		SelectD = selectD;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public String getExplaination() {
		return Explaination;
	}
	public void setExplaination(String explaination) {
		Explaination = explaination;
	}
	public int getSourceID() {
		return SourceID;
	}
	public void setSourceID(int sourceID) {
		SourceID = sourceID;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
