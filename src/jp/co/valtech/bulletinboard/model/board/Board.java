package jp.co.valtech.bulletinboard.model.board;

import java.util.ArrayList;
import java.util.List;

import jp.co.valtech.bulletinboard.model.thread.Thread;

public abstract class Board {
	
	protected int boardId;
	
	protected String title;
	
	protected List<Thread> threads = new ArrayList<>();
	
	Board (String title) {
		this.boardId = title.hashCode();
		this.title   = title;
	}
	
	public int getBoardId() {
		return this.boardId;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public List<Thread> getThreads() {
		return new ArrayList<>(threads);
	}
	
	public Thread getThread(long threadid) {
		for (Thread thread : threads) if (thread.getThreadId() == threadid) return thread;
		return null;
	}
	
	public abstract void createThread(String title);
}
