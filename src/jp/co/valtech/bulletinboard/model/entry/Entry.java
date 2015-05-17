package jp.co.valtech.bulletinboard.model.entry;

import java.util.regex.Pattern;

public abstract class Entry {
	
	private static Pattern newLinePattern = Pattern.compile("\r\n|\r|\n");
	
	/** 連番 */
	protected int seq;
	
	/** ID */
	protected String id;
	
	/** タイトル */
	protected String title;
	
	/** 内容 */
	protected String entry;
	
	public Entry(int seq, String id, String title, String entry) {
		this.seq   = seq;
		this.id    = id;
		this.title = title;
		this.entry = entry;
	}
	
	public int getSeq() {
		return seq;
	}

	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getHtmlTitle() {
		return title.replaceAll(" ", "&nbsp;");
	}

	public String getEntry() {
		return entry;
	}
	
	public String getHtmlEntry() {
		return newLinePattern.matcher(entry).replaceAll("<br/>").replaceAll(" ", "&nbsp;");
	}
	
}
