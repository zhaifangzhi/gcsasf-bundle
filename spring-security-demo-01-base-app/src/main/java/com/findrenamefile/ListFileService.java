package com.findrenamefile;

import java.io.*;
import java.util.*;

public interface ListFileService {
	
	public List<String> allFiles(String path);
    public File getDocument(String path);
}
