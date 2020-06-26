package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

//つぶやくに関するリクエストを処理するコントローラー
//GETとPOSTで処理を変える

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// つぶやきリスト取得してリクエストスコープに保存
		GetMutterListLogic getMutterListlogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListlogic.execute();
		request.setAttribute("mutterList", mutterList);

		//ログインしているか確認するためセッションスコープからユーザー情報を習得
		HttpSession session = request.getSession();
		User loginUser =(User) session.getAttribute("loginUser");

		if(loginUser == null) {
			//ログインしていない場合はどこつぶのトップ画面にリダイレクト
			response.sendRedirect("/docoTsubu/");
		}else {
			//ログイン済みの場合はメイン画面のビューのmain.jspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//入力値チェック
		if(text != null && text.length() != 0) {
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			//つぶやきをつぶやきリストに追加
			Mutter mutter = new Mutter(loginUser.getName(),text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);

		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg","つぶやきが入力されていません");
		}

		//つぶやきリストを取得してリクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList",mutterList);

		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}
}
