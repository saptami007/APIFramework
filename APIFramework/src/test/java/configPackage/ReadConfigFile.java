package configPackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	static Properties properties;
	public static void readData() throws IOException {
		properties=new Properties();
		File file=new File(System.getProperty("user.dir")+"//src//test//java//configPackage//config.properties");
		FileReader obj=new FileReader(file);
		properties.load(obj);
		
	}

public static String getConfigData(String data) throws IOException {
	readData();
	String name=properties.getProperty(data);
	return name;
	
}
}
