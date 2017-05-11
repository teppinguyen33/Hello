package music.entities;

public class SongQuality {
	public String Audio128;
	private String audio128;

	public String getAudio128() {
		return audio128;
	}

	public void setAudio128(String audio128) {
		this.audio128 = audio128;
	}

	public void sync() {
		this.audio128 = this.Audio128;
	}
}
