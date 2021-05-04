package com.amt.uae.config;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.Options;


@Configuration
public class MockServiceInitializer {
	
	@Value("${mock.server.port}")
	private int mockServerPort;
	
	@Value("${filesPath}")
	private String filesPath;

	
	@Bean
	public WireMockServer wireMockServer (){
		System.out.println("response xml file path : "+filesPath);
		Options options = options().port(mockServerPort)
		.usingFilesUnderDirectory(filesPath);
		WireMockServer wms = new WireMockServer(options);
		wms.start();
		return wms;
	}

}