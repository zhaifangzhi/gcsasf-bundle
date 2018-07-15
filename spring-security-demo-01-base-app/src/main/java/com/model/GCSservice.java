package com.model;
import java.nio.file.Path;
import java.util.ArrayList;

import com.google.cloud.storage.Blob;

public interface GCSservice {
	public ArrayList<Blob> listAllBlobs(String prefex);
	public ArrayList<Blob> sortAllBlobs(String prefex);
	public void deleteBlob(Blob b);
}
