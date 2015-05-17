package jp.co.valtech.bulletinboard.model.thread;

import jp.co.valtech.bulletinboard.model.entry.EntryOnMemory;

public class ThreadOnMemory extends Thread {

	public ThreadOnMemory(String title) {
		super(title);
	}

	@Override
	public void write(String id, String title, String entry) {
		this.entrys.add(new EntryOnMemory(this.getLastSeq() +1, id, title, entry));
	}
}


