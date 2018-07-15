package com.model;

import com.pojos.ASFresponse;
import com.pojos.SteamEmailUser;
import com.pojos.SteamUser;

public interface BotService {
	public ASFresponse uploadBot(SteamUser su) throws Exception;
	public ASFresponse deleteBot(String steamusername) throws Exception;
	public ASFresponse uploadEmailcode(SteamEmailUser seu) throws Exception;
}
