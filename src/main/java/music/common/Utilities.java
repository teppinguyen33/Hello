package music.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class Utilities {

	/**
	 * Check charset of array byte
	 * @param bytes
	 * @return
	 */
	public static String checkCharset(byte[] bytes) {
		// Check charset of string response
		org.mozilla.universalchardet.UniversalDetector detector = new org.mozilla.universalchardet.UniversalDetector(null);
		detector.handleData(bytes, 0, bytes.length);
		detector.dataEnd();
		String encoding = detector.getDetectedCharset();
		detector.reset();
		return encoding;
	}
	
	/**
	 * Convert a string to array byte
	 * @param string
	 * @return
	 * @throws IOException
	 */
	public static byte[] compress(String string) throws IOException {
		if (string == null || "".equals(string)) {
			return null;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gos = new GZIPOutputStream(baos);
		gos.write(string.getBytes(StandardCharsets.UTF_8));
		gos.close();
		return baos.toByteArray();
	}
	
	/**
	 * Convert a array byte to string, encode UTF-8
	 * @param bytes
	 * @return
	 * @throws IOException
	 */
	public static String decompress(byte[] bytes) throws IOException {
		String retString = "";
		
		if (bytes == null || bytes.length == 0) {
			return "";
		}
		GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(bytes));
		BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
		
		String line;
		while((line = br.readLine()) != null) {
			retString += line;
		}
		
		return retString;
	}

}
