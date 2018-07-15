package com.findrenamefile;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class ListFilelmp implements ListFileService {
	
	public static List<String> filenames;

	@Override
	public File getDocument(String singlefilepath) {
		File a=new File(singlefilepath);
		return a;
	}

	@Override
	public List<String> allFiles(String path) {
	
        File file = new File(path);   
        
        File[] array = file.listFiles();   
          
        for(int i=0;i<array.length;i++){   
            if(array[i].isFile()){   
                filenames.add(array[i].getAbsolutePath());   
            }else if(array[i].isDirectory()){   
                allFiles(array[i].getPath());   
            }   
        }
        return filenames;
    }

} 
   
