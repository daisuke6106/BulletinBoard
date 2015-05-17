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
public class SelectBoard extends HttpServlet {

	/* シリアルバージョンiD */
	private static final long serialVersionUID = -6953293387569687630L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoard() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String boardid = request.getParameter("boardid");
		request.setAttribute("board", BoardOnMemory.getBoard(Integer.parseInt(boardid)));
		getServletContext().getRequestDispatcher("/board.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
