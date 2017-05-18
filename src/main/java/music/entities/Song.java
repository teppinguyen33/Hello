package music.entities;

public class Song {

	private String id;
	private String cover;
	private String lyric;
	private String lyric_content;
	private SongQuality qualities;
	private String title;
	private String log_data;
	private String artist;
	private String listen;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public String getLyric_content() {
		return lyric_content;
	}

	public void setLyric_content(String lyric_content) {
		this.lyric_content = lyric_content;
	}

	public SongQuality getQualities() {
		return qualities;
	}

	public void setQualities(SongQuality qualities) {
		this.qualities = qualities;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLog_data() {
		return log_data;
	}

	public void setLog_data(String log_data) {
		this.log_data = log_data;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getListen() {
		return listen;
	}

	public void setListen(String listen) {
		this.listen = listen;
	}

}
