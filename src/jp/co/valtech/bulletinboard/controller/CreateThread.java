package jp.co.valtech.bulletinboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.valtech.bulletinboard.model.board.BoardOnMemory;

/**
 * Servlet implementation class BulletinBoard
 */
public class CreateThread extends HttpServlet {

	/* シリアルバージョンiD */
	private static final long serialVersionUID = 1274540577842698870L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CreateThread() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String boardid = request.getParameter("boardid");
		String title   = request.getParameter("title");
		BoardOnMemory.getBoard(Integer.parseInt(boardid)).createThread(title);
		response.sendRedirect("./select_board?boardid=" + boardid);
	}

}
