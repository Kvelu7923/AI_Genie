package com.framework.api.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class APIBase extends RestUtils {

    static String configFile = "./src/main/resources/config.properties";

    public static String id;
	
	public static Properties prop;

	static {
		try {
			FileInputStream fis = new FileInputStream(configFile);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load properties file", e);
		}
	}

	protected RestUtils api() {
		return RestUtils.getInstance();
	}

	@Override @BeforeMethod
	public synchronized void setNode() {
		super.setNode();
	}
	
	
	
	public void generateOAuthToken() {
		System.out.println("Generating OAuth Token...");
		String domain = prop.getProperty("api.domain");
		String endpoint = prop.getProperty("api.tokenurl");
		String tokenEndpoint = domain + endpoint;
		String clientId = prop.getProperty("api.client_id");
		String clientSecret = prop.getProperty("api.client_secret");
		String username = prop.getProperty("api.username");
		String password = prop.getProperty("api.password");

		Map<String, Object> params = new HashMap<>();
		params.put("grant_type", "password");
		params.put("client_id", clientId);
		params.put("client_secret", clientSecret);
		params.put("username", username);
		params.put("password", password);

		// ✅ Using RestUtils (STATIC method)
		RestUtils utils = RestUtils.getInstance();
		RestUtils.RestAssert restAssert = utils.postForOAuth(params, tokenEndpoint);
		String token = restAssert.getResponse().jsonPath().getString("access_token");

		if (token != null && !token.isEmpty()) {
			System.out.println("OAuth Token generated: " + token);
			saveTokenToProperties(token);
			// Save to properties
		} else {
			throw new RuntimeException("Failed to fetch token. Response: " + restAssert.getResponse().asString());
		}
		
	}
	
	 public static void saveTokenToProperties(String newToken) {
	        List<String> lines = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                if (line.trim().startsWith("api.token=")) {
	                    // Update the token line
	                    line = "api.token=" + newToken;
	                }
	                lines.add(line);
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to read the properties file", e);
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configFile))) {
	            for (String line : lines) {
	                writer.write(line);
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to write to the properties file", e);
	        }

	        System.out.println("Token updated successfully in the properties file.");
	    }

}
