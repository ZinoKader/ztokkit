import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public final class PageContentReader {


    public static String urlToString(String url) {

	StringBuilder content = new StringBuilder();

	try {

	    URLConnection urlConnection = new URL(url).openConnection();
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	    String line = bufferedReader.readLine();

	    while (line != null) {
		content.append(line).append("\n");
		line = bufferedReader.readLine();
	    }

	    bufferedReader.close();

	} catch(IOException e) {
	    e.printStackTrace();
	}

	return content.toString();
    }
}
