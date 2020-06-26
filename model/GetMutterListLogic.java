package model;

//つぶやきの取得に関する処理を行うDAOを利用したモデル

import java.util.List;

import dao.MutterDAO;

public class GetMutterListLogic {
	public List<Mutter> execute(){
		MutterDAO dao = new MutterDAO();
		List<Mutter> mutterList = dao.findAll();
		return mutterList;
	}

}
