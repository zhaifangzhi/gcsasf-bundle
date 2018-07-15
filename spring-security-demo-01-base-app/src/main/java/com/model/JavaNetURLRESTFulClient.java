package com.model;
import java.net.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.ASFresponse;
import com.pojos.SteamEmailUser;
import com.pojos.SteamUser;

import java.io.*;

@Component
public class JavaNetURLRESTFulClient implements BotService{
	
	@Autowired
	UrlService us;
 
	@Override
	public ASFresponse uploadBot(SteamUser su) throws Exception{
		    ASFresponse aa=us.postPureUrl(su);
            if(su.getFacode()==null||su.getFacode().equals("")){
            	return aa;
            }else{	
            	Thread.currentThread().sleep(15000);
            	us.startUrl(su);
            	Thread.currentThread().sleep(3000);
                us.inputFAUrl(su);
                ASFresponse aa1=us.startUrl(su);
                return aa1;
            }
     }

	@Override
	public ASFresponse deleteBot(String su) throws Exception {
		ASFresponse ar=us.deleteUrl(su);
		return ar;
	}

	@Override
	public ASFresponse uploadEmailcode(SteamEmailUser seu) throws Exception {
		us.inputEmailCode(seu);
		ASFresponse ar=us.startUrl(seu.getUsername());
		return ar;
	}
	}
