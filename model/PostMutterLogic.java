package model;

import dao.MutterDAO;

//つぶやきの投稿に関する処理を行うDAOを用いるモデル

public class PostMutterLogic {
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}


}
