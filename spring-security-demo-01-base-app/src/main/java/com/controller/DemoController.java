package com.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.databasemodel.UserService;
import com.google.cloud.storage.Blob;
import com.model.BotService;
import com.model.GCSservice;
import com.model.UrlService;
import com.pojos.ASFresponse;
import com.pojos.SteamEmailUser;
import com.pojos.SteamUser;

@Controller
public class DemoController {
	
	@Autowired
	private GCSservice gcs;
	
	@Autowired
	private UserService us;
	
	@Autowired
	private BotService bs;
	
	@Autowired
	private UrlService usv;
	
	@InitBinder
	public void init(WebDataBinder wdb){
		StringTrimmerEditor ste=new StringTrimmerEditor(true);
		wdb.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping("/")
	public String showHome(Model h){
		h.addAttribute("ss", new SteamUser());
		return "home";
	}
	
	@RequestMapping("/upload")
	public String uploadToServer(@Valid @ModelAttribute("ss") SteamUser su,
			BindingResult br,Model s,HttpServletRequest hsr){
		
		if(br.hasErrors()){
		return "home";
		}else{
				String systemusername=hsr.getParameter("systemuser");
				String authority=hsr.getParameter("authority");
				long starttime=System.currentTimeMillis();
				su.setSystemusername(systemusername);
				su.setAuthority(authority);
				su.setStarttime(starttime);
				if(us.getAllSteamUsers()==null){
				us.save(su);
				ASFresponse ar = null;
				try {
					ar = bs.uploadBot(su);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s.addAttribute("gg", ar);			
		        return "uploadrs";
				}else{
					List<SteamUser> lsu=us.getAllSteamUsers();
					for(int i=0;i<lsu.size();i++){
						if(lsu.get(i).getSystemusername().equals(systemusername)){
							if(lsu.get(i).getUsername().equals(su.getUsername())){
								ASFresponse ar = null;
								try {
									ar = bs.uploadBot(su);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								s.addAttribute("gg", ar);
								return "uploadrs";
							}else{
								try {
									bs.deleteBot(us.getFromSystemuser(systemusername).getUsername());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								us.updateusername(us.getFromSystemuser(systemusername), su.getUsername());
								ASFresponse ar = null;
								try {
									ar = bs.uploadBot(su);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								s.addAttribute("gg", ar);
								return "uploadrs";
							}
					}
						}
					us.save(su);
					ASFresponse ar = null;
					try {
						ar = bs.uploadBot(su);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					s.addAttribute("gg", ar);			
			        return "uploadrs";
				}
	}
	}
	
	@RequestMapping("/recover")
	public String recover(HttpServletRequest hsr){
		String systemusername=hsr.getParameter("systemusername");
		if(us.getFromSystemuser(systemusername)==null){
			return "redirect:/";
		}
		String facode=hsr.getParameter("facode");
		if(facode.trim().replace(" ", "").equals("")||hsr.getParameter("facode")==null){
			return "redirect:/";
		}else if((facode.trim().replace(" ","").length()!=5)&&
				(facode.trim().replace(" ","").length()!=7)){
			return "redirect:/";
		}
		SteamUser sus=us.getFromSystemuser(systemusername);
		sus.setFacode(facode);
		try {
			usv.startUrl(sus);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			usv.inputFAUrl(sus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			usv.startUrl(sus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "recover";
	}
	
	@RequestMapping("/delete")
	public String deleteBot(@RequestParam("systemusername") String systemusername){
		if(us.getFromSystemuser(systemusername)!=null){
			try {
				bs.deleteBot(us.
						getFromSystemuser(systemusername).getUsername());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "uploadrs";
		}else{
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/findappid")
	public String appid(){
		return "appid";
	}
	
	@RequestMapping("/play")
	public String playGame(@RequestParam("forceappid") String forceappid,HttpServletRequest hsr){
		if(forceappid.contains(" ")||forceappid.length()>6
				||forceappid.length()<2
				||!(forceappid.matches("^[0-9]*[1-9][0-9]*$"))){
			return "redirect:/";
		}else{
		
		String systemusername=hsr.getParameter("systemusername");
		SteamUser su=us.getFromSystemuser(systemusername);
		try {
			usv.play(su, forceappid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "play";
		}
	}
	
	@RequestMapping("/resume")
	public String resumeAuto(@RequestParam("systemusername") String systemusername){
		try {
			usv.resume(us.getFromSystemuser(systemusername));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("ii") String prefix,Model s){
		if(prefix.equals("")){
			return "home";
		}
		ArrayList<Blob> al=gcs.sortAllBlobs(prefix);
		s.addAttribute("ss", al);
		return "searchresult";
	}
	
	@RequestMapping("/watch")
	public String watch(@RequestParam("ff") String name,Model s){
		String trackname = 
				name.substring(0, name.length()-3)+"vtt";
		s.addAttribute("qq", trackname);
		return "watch";
	}
	
	@RequestMapping("/deleteblob")
	public String deleteBlob(@RequestParam("ff") String name){
		Blob b=gcs.listAllBlobs(name).get(0);
		gcs.deleteBlob(b);
		return "save";
	}
	
	@RequestMapping("/handleservlet")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("aa") String name)
	         throws IOException {

	      // Save file on system
	      if ((!file.getOriginalFilename().isEmpty())&&
	    		  (file.getOriginalFilename().
					substring
					(file.getOriginalFilename().length()-4,file.getOriginalFilename().length())
					.equals(".vtt"))) {
	    	  String trackname = 
						name.substring(0, name.length()-4)+".vtt";
	    	  File filed =new File("/var/www/jiaweixin1578493820.info/html/"+trackname);
	    	  if(!filed.exists()){
	    		    filed.getParentFile().mkdir();
	    		    try {
	    		        filed.createNewFile();
	    		    } catch (IOException e) {
	    		        e.printStackTrace();
	    		    }
	    		}
	         BufferedOutputStream outputStream = new BufferedOutputStream(
	               new FileOutputStream(
	                     filed));
	         
	         outputStream.write(file.getBytes());
	         outputStream.flush();
	         outputStream.close();

	         return "save";
	      } else {
	    	       return "save";
	      }
	   }
}
