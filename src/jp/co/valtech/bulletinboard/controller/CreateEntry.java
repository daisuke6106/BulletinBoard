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
public class CreateEntry extends HttpServlet {

	/* シリアルバージョンiD */
	private static final long serialVersionUID = -1372750432771936204L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEntry() {
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
		String boardid  = request.getParameter("boardid");
		String threadid = request.getParameter("threadid");
		String id       = request.getRemoteHost();
		String title    = request.getParameter("title");
		String entry    = request.getParameter("entry");
		
		StringBuilder idStr  = new StringBuilder();
		for(byte idByte : id.getBytes())idStr.append(String.format("%02x", idByte));
		
		BoardOnMemory.getBoard(Integer.parseInt(boardid)).getThread(Long.parseLong(threadid)).write(idStr.toString(), title, entry);
		response.sendRedirect("./select_thread?boardid=" + boardid + "&" + "threadid=" + threadid);
	}

}
