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
public class SelectThread extends HttpServlet {

	/* シリアルバージョンiD */
	private static final long serialVersionUID = -2301011360493293091L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SelectThread() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String boardid  = request.getParameter("boardid");
		String threadid = request.getParameter("threadid");
		request.setAttribute("boardid" , boardid);
		request.setAttribute("threadid", threadid);
		request.setAttribute("thread" , BoardOnMemory.getBoard(Integer.parseInt(boardid)).getThread(Long.parseLong(threadid)));
		getServletContext().getRequestDispatcher("/thread.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
