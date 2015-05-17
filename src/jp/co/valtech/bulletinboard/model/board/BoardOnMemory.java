package jp.co.valtech.bulletinboard.model.board;

import java.util.ArrayList;
import java.util.List;

import jp.co.valtech.bulletinboard.model.thread.ThreadOnMemory;

public class BoardOnMemory extends Board{
	
	BoardOnMemory(String title) {
		super(title);
	}

	public void createThread(String title) {
		this.threads.add(new ThreadOnMemory(title));
	}
	
	private static List<Board> boardList = new ArrayList<>();
	
	static {
		boardList.add(new BoardOnMemory("コンピュータ"));
		boardList.add(new BoardOnMemory("家電、AV"));
		boardList.add(new BoardOnMemory("カメラ"));
		boardList.add(new BoardOnMemory("音楽"));
		boardList.add(new BoardOnMemory("映画、ビデオ"));
		boardList.add(new BoardOnMemory("ホビー、カルチャー"));
		boardList.add(new BoardOnMemory("アンティーク、コレクション"));
		boardList.add(new BoardOnMemory("スポーツ、レジャー"));
		boardList.add(new BoardOnMemory("自動車、オートバイ"));
	}
	
	public static List<Board> getBoardAll(){
		return new ArrayList<>(boardList);
	}
	
	public static Board getBoard(int boardId) {
		for(Board board : boardList) if (board.boardId == boardId) return board;
		return null;
	}
	
}
