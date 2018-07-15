package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.databasemodel.UserService;
import com.model.BotService;
import com.model.UrlService;
import com.pojos.ASFresponse;
import com.pojos.SteamEmailUser;

@Controller
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private BotService bs;
	
	@Autowired
	private UrlService us;
	
	@Autowired
	private UserService ss;
	
	@InitBinder
	public void init(WebDataBinder wdb){
		StringTrimmerEditor ste=new StringTrimmerEditor(true);
		wdb.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping("/email")
	public String toEmail(Model k){
		k.addAttribute("bb", new SteamEmailUser());
		return "email";
	}
	
	@RequestMapping("/sentemailcode")
	public String sentemailcode(@RequestParam("systemusername") String systemusername){
		String username = ss.getFromSystemuser(systemusername)
				.getUsername();
		try {
			us.startUrl(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fetch";
	}
	
	@RequestMapping("/emailcode")
	public String submitEmailcode(@Valid @ModelAttribute("bb") SteamEmailUser seu,BindingResult br,Model p,HttpServletRequest hsr){
		if(br.hasErrors()){
			return "email";
		}else{
			String systemusername=hsr.getParameter("systemusername");
			seu.setUsername(ss.getFromSystemuser(systemusername).getUsername()); 
			try {
				ASFresponse aes=bs.uploadEmailcode(seu);
				p.addAttribute("gg",aes);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "emailuploadrs";
		}
	}
}
