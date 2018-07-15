package com.model;


import java.util.ArrayList;

import org.springframework.stereotype.Component;


import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Component
public class GCSservicelmp implements GCSservice{

	@Override
	public ArrayList<Blob> listAllBlobs(String prefex) {
		Storage storage = StorageOptions.getDefaultInstance().getService();
	  	  ArrayList<Bucket> al=new ArrayList();
	  	  for (Bucket bucket : storage.list().iterateAll()) {  
	  	    al.add(bucket);
	  	  }
	  	  ArrayList<Blob> at=new ArrayList();
	  	  for (Blob blob : al.get(0).list().iterateAll()) {
	  		  if(blob.getName().toLowerCase().contains(prefex.toLowerCase())){
	  			  if(!(blob.getName().endsWith("/"))){
	  				  at.add(blob);
	  			  }
		    	}
		    }
	  	  return at;
	}

	@Override
	public ArrayList<Blob> sortAllBlobs(String prefex) {
		Storage storage = StorageOptions.getDefaultInstance().getService();
	  	  ArrayList<Bucket> al=new ArrayList();
	  	  for (Bucket bucket : storage.list().iterateAll()) {  
	  	    al.add(bucket);
	  	  }
	  	  ArrayList<Blob> at=new ArrayList();
	  	  
	  	  for (Blob blob : al.get(0).list().iterateAll()) {
	  		  if(blob.getName().toLowerCase().contains(prefex.toLowerCase())){
	  			if(!(blob.getName().endsWith("/"))){
	  				  at.add(blob);
	  			  }
		    	}
		    }
	  	  int c=0;
	  	  long[] b=new long[at.size()];
	  	  for (int f=0;f<at.size();f++) {
	 		    b[c]=at.get(f).getCreateTime();
		    	c++;	
		    }
	  	  
	  	  Sort.quickSort(b, 0, c-1);
	  	  ArrayList<Blob> as=new ArrayList();
	  	  for(int h=0;h<b.length;h++){
	  		for(int n=0;n<b.length;n++){
	  			if(at.get(n).getCreateTime()==b[h]){
	  				as.add(at.get(n));
	  			}
	  		}
	  	  }
	  	  return as;
	}

	@Override
	public void deleteBlob(Blob b) {
		Storage storage = StorageOptions.getDefaultInstance().getService();
		BlobId blobId = BlobId.of("fzlove", b.getName());
		storage.delete(blobId);
	}


}
