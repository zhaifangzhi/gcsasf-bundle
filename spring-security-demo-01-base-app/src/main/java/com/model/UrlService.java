package com.model;

import com.pojos.ASFresponse;
import com.pojos.SteamEmailUser;
import com.pojos.SteamUser;

public interface UrlService {
	public ASFresponse deleteUrl(String su) throws Exception;
	public ASFresponse startUrl(SteamUser su) throws Exception;
    public ASFresponse postPureUrl(SteamUser su) throws Exception;
    public ASFresponse inputFAUrl(SteamUser su) throws Exception;
    public ASFresponse startUrl(String username) throws Exception;
    public ASFresponse inputEmailCode(SteamEmailUser seu) throws Exception;
    public ASFresponse play(SteamUser su,String forceappid) throws Exception;
    public ASFresponse resume(SteamUser su) throws Exception;
}
