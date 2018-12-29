import java.io.*;
import java.util.Properties;

class Config{
	String fileName;
	FileInputStream fis;
	FileOutputStream fos;
	Properties p = new Properties();
	boolean error = false;

	public Config(String fileName){
		this.fileName = fileName;
		try{
			fis = new FileInputStream(fileName+".properties");
			p.load(fis);
			fis.close();
		}
		catch(IOException e){error = true;}
	}

	public String getProp(String key){
		return p.getProperty(key);
	}

	public void setProp(String key, String value){
		p.setProperty(key, value);
		try{
			fos = new FileOutputStream(fileName+".properties");
			p.store(fos, "");
		}catch(IOException e){error = true;}
	}

	public void close(){
		try{
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