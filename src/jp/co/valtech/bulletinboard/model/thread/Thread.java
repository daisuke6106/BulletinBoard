package jp.co.valtech.bulletinboard.model.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.valtech.bulletinboard.model.entry.Entry;

public abstract class Thread {
	
	/** スレッドID */
	protected long threadId;
	
	/** タイトル */
	protected String title; 
	
	/** 書き込み一覧 */
	protected List<Entry> entrys = new ArrayList<>();
	
	public Thread(String title) {
		this.threadId = new Date().getTime();
		this.title = title;
	}
	
	public long getThreadId() {
		return this.threadId;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public synchronized int getLastSeq() {
		if (this.entrys.size() == 0) return 0;
		return this.entrys.get(this.entrys.size()-1).getSeq();
	}
	
	public List<Entry> getEntrys() {
		return new ArrayList<Entry>(this.entrys);
	}
	
	public abstract void write(String id, String title, String entry);
}
