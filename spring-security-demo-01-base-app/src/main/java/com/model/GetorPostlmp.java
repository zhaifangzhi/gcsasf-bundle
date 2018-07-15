package com.model;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pojos.ASFresponse;
import com.pojos.SteamEmailUser;
import com.pojos.SteamUser;
@Component
public class GetorPostlmp implements UrlService {
	
	@Autowired
	private GetPostService gps;

	@Override
	public ASFresponse deleteUrl(String su) throws Exception{
		String targetURL = "http://127.0.0.1:1242/Api/Bot/"+su+"?password=139738";
        ASFresponse aa = gps.deleteUrl(targetURL);
        return aa;
	}

	@Override
	public ASFresponse postPureUrl(SteamUser su) throws Exception{
		String targetURL = "http://127.0.0.1:1242/Api/Bot/"+su.getUsername()+"?password=139738";
        String input;
        if(su.getGamesPlayedWhileIdle()==null||su.getGamesPlayedWhileIdle().equals("")){
        input = "{\"BotConfig\":{\"SteamLogin\":\""+su.getUsername()+"\",\"SteamPassword\":\""+su.getPassword()+"\",\"Enabled\":true},\"KeepSensitiveDetails\":false}";
        }else{
        input = "{\"BotConfig\":{\"SteamLogin\":\""+su.getUsername()+"\",\"SteamPassword\":\""+su.getPassword()+"\",\"Enabled\":true,\"GamesPlayedWhileIdle\":["+su.getGamesPlayedWhileIdle().replaceAll("\\s+", ",")+"]},\"KeepSensitiveDetails\":false}";
	
        }
        ASFresponse aa = gps.postUrl(targetURL, input);
        return aa;
	}

	@Override
	public ASFresponse startUrl(SteamUser su) throws Exception {
		String targetURL = "http://127.0.0.1:1242/Api/Command/start%20"+su.getUsername()+"?password=139738";
        String input = "";
        ASFresponse aa = gps.postUrl(targetURL, input);
        return aa;
	}

	@Override
	public ASFresponse inputFAUrl(SteamUser su) throws Exception {
		
		String targetURL = "http://127.0.0.1:1242/Api/Command/input%20"+su.getUsername()+"%20TwoFactorAuthentication%20"+su.getFacode()+"?password=139738";
        String input = "";
        ASFresponse aa = gps.postUrl(targetURL, input);
        return aa;
	}

	@Override
	public ASFresponse startUrl(String username) throws Exception {
		String targetURL = "http://127.0.0.1:1242/Api/Command/start%20"+username+"?password=139738";
        String input = "";
        ASFresponse aa = gps.postUrl(targetURL, input);
        return aa;
	}

	@Override
	public ASFresponse inputEmailCode(SteamEmailUser seu) throws Exception {
		String targetURL = "http://127.0.0.1:1242/Api/Command/input%20"+seu.getUsername()+"%20SteamGuard%20"+seu.getEmailcode()+"?password=139738";
        String input = "";
        ASFresponse aa = gps.postUrl(targetURL, input);
        return aa;
	}

	@Override
	public ASFresponse play(SteamUser su, String forceappid) throws Exception {
		String targetURL = "http://127.0.0.1:1242/Api/Command/play%20"+su.getUsername()+"%20"+forceappid+"?password=139738";
        String input = "";
        ASFresponse aa = gps.postUrl(targetURL, input);
        return aa;
	}

	@Override
	public ASFresponse resume(SteamUser su) throws Exception {
		String targetURL = "http://127.0.0.1:1242/Api/Command/resume%20"+su.getUsername()+"?password=139738";
        String input = "";
        ASFresponse aa = gps.postUrl(targetURL, input);
        return aa;
	}

}
