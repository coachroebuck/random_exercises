import java.util.*;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class Exercise13 {

    public static void main(String[] args) {
    	final int min = args.length >= 1 ? Integer.parseInt(args[0]) : 1;
    	final int max = args.length >= 2 ? Integer.parseInt(args[1]) : 2;

		System.out.println("Org\tStock Price");
    	recursive("", min, max);
	}

	public static void recursive(final String currentString, final int min, final int max) {
		for(char c = 'a'; c <= 'z'; c++) {
			final String nextString = currentString + c;
			if(nextString.length() >= min) {
	    		httpRequest("http://www.nasdaq.com/symbol/", nextString);
			}
		}
		for(char c = '0'; c <= '9'; c++) {
			final String nextString = currentString + c;
			if(nextString.length() >= min) {
	    		httpRequest("http://www.nasdaq.com/symbol/", nextString);
			}
		}

		for(char c = 'a'; c <= 'z'; c++) {
			final String nextString = currentString + c;
			if(nextString.length() < max) {
				recursive(nextString, min + 1, max);
			}
		}
		for(char c = '0'; c <= '9'; c++) {
			final String nextString = currentString + c;
			if(nextString.length() < max) {
				recursive(nextString, min + 1, max);
			}
		}
	}

	public static void httpRequest(final String path, final String abbr) {
		HttpURLConnection aHttpURLConnection;
		URL url;
		int status = HttpURLConnection.HTTP_OK;
		InputStream inputStream;
		Integer BUFFER_SIZE = 128;
		final byte[] buffer = new byte[BUFFER_SIZE];
		final StringBuffer sb = new StringBuffer();
		InputStreamReader isr;
		int rsz;

		try {
			url = new URL(path + abbr);
			aHttpURLConnection = (HttpURLConnection) url.openConnection();
			aHttpURLConnection.setRequestMethod("GET");
			aHttpURLConnection.setDoOutput(true);
			aHttpURLConnection.setDoInput(true);
			aHttpURLConnection.setConnectTimeout(30000);
			aHttpURLConnection.setReadTimeout(30000);
			System.setProperty("http.keepAlive", "false");
			aHttpURLConnection.connect();
			status = aHttpURLConnection.getResponseCode();

			if (status == HttpURLConnection.HTTP_OK) {
			    inputStream = new BufferedInputStream(aHttpURLConnection.getInputStream());
			} else {
			    inputStream = new BufferedInputStream(aHttpURLConnection.getErrorStream());
			}

			isr = new InputStreamReader(inputStream, "UTF-8");
			int data = isr.read();
			while(data != -1){
			    char theChar = (char) data;
			    sb.append(theChar);
			    data = isr.read();
			}

			isr.close();
			inputStream.close();
			aHttpURLConnection.disconnect();

			final String pattern1 = "<div id=\"qwidget_lastsale\" class=\"qwidget-dollar\">";
			final String pattern2 = "</div>";
			final String html = sb.toString();
			final int index1 = html.indexOf(pattern1);

			if(index1 > -1) {
				final int index2 = html.indexOf(pattern2, index1 + pattern1.length());

				if(index2 > -1) {
					final String stockPrice = html.substring(index1 + pattern1.length(), index2);
					System.out.println(String.format(Locale.getDefault(),
						"%s\t%s",
						abbr, stockPrice));
				}
			} 
		}
		catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}

	}
}