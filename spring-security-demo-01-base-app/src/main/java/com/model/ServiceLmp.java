package com.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.ASFresponse;

@Component
public class ServiceLmp implements GetPostService{

	@Override
	public ASFresponse getUrl(String targetURL) throws Exception {
		URL restServiceURL = new URL(targetURL);

        HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("Accept", "application/json");

        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
               (httpConnection.getInputStream())));

        String output=responseBuffer.readLine();
        ObjectMapper mapper = new ObjectMapper();
        ASFresponse aa = mapper.readValue(output, ASFresponse.class);
        
        httpConnection.disconnect();
        return aa;
	}

	@Override
	public ASFresponse deleteUrl(String targetURL) throws Exception {
		URL restServiceURL = new URL(targetURL);

        HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
        httpConnection.setRequestMethod("DELETE");
        httpConnection.setRequestProperty("Accept", "application/json");

        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
               (httpConnection.getInputStream())));

        String output=responseBuffer.readLine();
        ObjectMapper mapper = new ObjectMapper();
        ASFresponse aa = mapper.readValue(output, ASFresponse.class);
        
        httpConnection.disconnect();
        return aa;
	}

	@Override
	public ASFresponse postUrl(String targetURL, String input) throws Exception {
		URL targetUrl = new URL(targetURL);
        HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
        httpConnection.setDoOutput(true);
        httpConnection.setRequestMethod("POST");
        httpConnection.setRequestProperty("Content-Type", "application/json");
        OutputStream outputStream = httpConnection.getOutputStream();
        outputStream.write(input.getBytes());
        outputStream.flush();

        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                      (httpConnection.getInputStream())));

        String output=responseBuffer.readLine();
        ObjectMapper mapper = new ObjectMapper();
        ASFresponse aa = mapper.readValue(output, ASFresponse.class);
        
        httpConnection.disconnect();
        return aa;
	}



}
