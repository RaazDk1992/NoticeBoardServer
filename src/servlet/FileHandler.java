package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

public class FileHandler {

	Part file;
	String Path;
	String RealPath;
	
	
	public FileHandler(Part filePart, String realPath , String path){
		this.file = filePart;
		this.Path = path;
		this.RealPath = realPath;
		
	}
	public String storeFile(){
		String filePath = null;
		String Filename;
		InputStream is;

		Filename = file.getSubmittedFileName();
		try {
			is = this.file.getInputStream();

			if(pathAvailable(this.RealPath)){
				File f = new File(this.RealPath+"\\"+Filename);
				FileUtils.copyInputStreamToFile(is, f);
			}
			System.err.println(RealPath);
			filePath = this.Path+"/"+Filename;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return filePath;
		
	}
	private boolean pathAvailable(String path){
		boolean available = true;
		
		File directory = new File(path);
		if(!directory.exists()){
			return directory.mkdir();
		}
		
		return available;
	}
}
