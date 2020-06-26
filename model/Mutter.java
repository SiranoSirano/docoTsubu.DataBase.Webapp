package model;
// つぶやきに関する情報を持つJavaBeans
//MUTTERテーブルのレコードを示すクラス

import java.io.Serializable;

public class Mutter implements Serializable{
	private int id; //id
	private String userName; //ユーザー名
	private String text; //つぶやきの内容

	public Mutter() {}
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	//id,名前、つぶやきを表示する
	public Mutter(int id, String userName,String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}

	public int getId() {return id;}
	public String getUserName() {return userName;}
	public String getText() {return text;}
}
