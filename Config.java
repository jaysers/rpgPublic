import java.io.*;
import java.util.Properties;

class Config{
	FileInputStream fis;
	FileOutputStream fos;
	Properties p = new Properties();
	boolean error = false;

	public Config(String fileName){
		try{
			fis = new FileInputStream(fileName+".properties");
			fos = new FileOutputStream(fileName+".properties");
			p.load(fis);
		}
		catch(IOException e){error = true;}
	}

	public String getProp(String key){
		return p.getProperty(key);
	}

	public void setProp(String key, String value){
		p.setProperty(key, value);
		p.save(fos, "");
	}

	public void clearError(){
		error = false;
	}
}