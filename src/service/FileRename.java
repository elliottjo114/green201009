package service;

import java.io.File;

public class FileRename {

	public String newName(String path,String name) {
		
		int cnt = 0;
		int pos = name.lastIndexOf(".");
		String fName = name.substring(0,pos);
		String ext = name.substring(pos);
		
		while(new File(path+"\\"+name).exists()) {
			cnt++;
			name = fName+"_"+cnt+ext;
		}
		
		
		return name;
	}
}
