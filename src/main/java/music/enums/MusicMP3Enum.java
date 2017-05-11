package music.enums;

public enum MusicMP3Enum {

	HOST("HOST", "http://m.mp3.zing.vn"), 
	SEARCH("SEARCH", "/tim-kiem/bai-hat.html"),
	SONG("SONG", "/json/html5/song/"), 
	ALBUM("ALBUM", "/json/playlist/initialize/"),
	TOPIC("TOPIC", "/chu-de/")
	;
	private String code;
	private String text;

	private MusicMP3Enum(String code, String text) {
		this.code = code;
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
