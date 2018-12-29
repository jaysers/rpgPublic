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
			p.load(fis);
			fis.close();
			fos = new FileOutputStream(fileName+".properties");
		}
		catch(IOException e){error = true;}
	}

	public String getProp(String key){
		return p.getProperty(key);
	}

	public void setProp(String key, String value){
		try{
			p.setProperty(key, value);
			p.store(fos, "");
		}catch(IOException e){error = true;}
	}

	public void clearError(){
		error = false;
	}

	public boolean getError(){
		return error;
	}
}