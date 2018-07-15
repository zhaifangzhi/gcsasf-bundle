package com.findrenamefile;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Renamelmp implements RenameService {
	
	@Autowired
	private ListFileService lfs;

	@Override
	public List<String> rename(String path) {
		String[] level={"1","2","3","4","5","6","7","8","9","0","q","w","e","r","t"," ",
				"y","u","i","o","p","a","s","d","f","g","h","j","k",
				"l","z","x","c","v","b","n","m","_","Q","W","E","R","T","Y","U","I","O","P","A","S","D","F",
				"G","H","J","K","L","Z","X","C","V","B","N","M","/"};
		List<String> al = lfs.allFiles(path);
		for(String filename:al){
			if(((filename.substring(filename.length()-4,filename.length())).equals(".mp4"))||
					((filename.substring(filename.length()-4,filename.length())).equals(".mkv"))||
					((filename.substring(filename.length()-4,filename.length())).equals(".mp3")))
			{
				String name = filename.substring(0,filename.length()-4);
				
				for(int i=0;i<name.length();i++){
					String n=name.charAt(i)+"";
					for(int m=0;m<level.length;m++){
						if(n.equals(level[m])){
						   break;
						}
							if(m==(level.length-1)){
								File ss=lfs.getDocument(filename);
								ss.renameTo
								(new File(filename.replace(filename.charAt(i), '0')));
							}
					}
				}
			}
		}
		List<String> an=lfs.allFiles(path);
		return an;
	}

}
