package music.entities;

public class SongData {

	private Song data;
	private String error;
	private String message;

	public Song getData() {
		return data;
	}

	public void setData(Song data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
