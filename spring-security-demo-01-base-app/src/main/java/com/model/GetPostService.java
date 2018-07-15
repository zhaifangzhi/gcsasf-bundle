package com.model;

import com.pojos.ASFresponse;

public interface GetPostService {
	public ASFresponse getUrl(String targetURL) throws Exception;
	public ASFresponse deleteUrl(String targetURL) throws Exception;
	public ASFresponse postUrl(String targetURL,String input) throws Exception;
}
