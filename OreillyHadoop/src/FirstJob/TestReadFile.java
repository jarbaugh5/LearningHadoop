package FirstJob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestReadFile {

	/*
	 * Test read the data file to confirm that
	 * heat is at the 15th position in the comma
	 * separated list in the daily information
	 * provided by the NCDC
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			String line;
			br = new BufferedReader(new FileReader(new File("data/201404daily.txt")));
			while ((line = br.readLine()) != null) {
				List<String> items = Arrays.asList(line.split(","));
				// heat is 15th element
				System.out.println(items.get(14));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
