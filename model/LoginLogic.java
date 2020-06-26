package model;

//ログインの処理を行うモデル
public class LoginLogic {
	public boolean execute(User user) {
		//パスワードが１２３４ならログインOK、それ以外はログイン失敗
		if(user.getPass().equals("1234")) {return true;}
		return false;
	}
}
