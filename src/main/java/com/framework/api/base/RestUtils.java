package com.framework.api.base;

import com.framework.utils.Reporter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import java.util.Map;
import java.util.List;
import java.io.File;

public class RestUtils extends Reporter {

	private static RestUtils instance;
	private static Response lastResponse;

	public static RestUtils getInstance() {
		if (instance == null) {
			instance = new RestUtils();
		}
		return instance;
	}

	/**
	 * Format JSON response for better readability
	 * 
	 * @param json JSON string to format
	 * @return Formatted JSON string
	 */

	private String beautifyJson(String json) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement jsonElement = JsonParser.parseString(json.trim()); // Ensure no extra spaces
		return gson.toJson(jsonElement);
	}

	// ==============================================
	// POST METHODS
	// ==============================================

	/**
	 * POST with JSON body
	 */
	public RestAssert post(String body, String endpoint) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.JSON).body(body);
		reportStep("POST Request Body (JSON):\n" + beautifyJson(body), "INFO");
		lastResponse = request.post(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * POST with form data (URL encoded)
	 */
	public RestAssert postForm(Map<String, Object> formData, String endpoint) {
		System.out.println("Form Data: " + formData);
		RequestSpecification request = buildBaseRequest().contentType(ContentType.URLENC).formParams(formData);
		reportStep("POST Request Form Data:\n" + formData.toString(), "INFO");
		lastResponse = request.post(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * POST with form data (URL encoded) For authentication
	 */
	public RestAssert postForOAuth(Map<String, Object> formData, String endpoint) {
		RequestSpecification request = RestAssured.given().contentType(ContentType.URLENC).formParams(formData);
		lastResponse = request.post(endpoint);
//		lastResponse.prettyPrint();
		// logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * POST with multipart form data
	 */
	public RestAssert postMultipart(Map<String, Object> formData, String endpoint) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.URLENC);
		formData.forEach(request::multiPart);
		reportStep("POST Request Multipart Data:\n" + formData.toString(), "INFO");
		lastResponse = request.post(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * POST with file upload
	 */
	public RestAssert postFile(String fileParamName, File file, String endpoint) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.URLENC).multiPart(fileParamName,
				file);
		reportStep("POST Request File Upload: " + file.getName(), "INFO");
		lastResponse = request.post(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * POST with custom headers
	 */
	public RestAssert post(String body, String endpoint, Map<String, String> headers) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.JSON).headers(headers).body(body);
		reportStep("POST Request Body (JSON):\n" + beautifyJson(body), "INFO");
		reportStep("POST Request Headers:\n" + headers.toString(), "INFO");
		lastResponse = request.post(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * POST with path parameters
	 */
	public RestAssert postpathParams(String body, String endpoint, Map<String, Object> pathParams) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.JSON).pathParams(pathParams)
				.body(body);
		reportStep("POST Request Body (JSON):\n" + beautifyJson(body), "INFO");
		reportStep("POST Path Parameters:\n" + pathParams.toString(), "INFO");
		lastResponse = request.post(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	// ==============================================
	// GET METHODS
	// ==============================================

	/**
	 * Simple GET request
	 */
	public RestAssert get(String endpoint) {
		RequestSpecification request = buildBaseRequest();
		lastResponse = request.get(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * GET with query parameters
	 */
	public RestAssert get(String endpoint, Map<String, Object> queryParams) {
		RequestSpecification request = buildBaseRequest().queryParams(queryParams);
		reportStep("GET Query Parameters:\n" + queryParams.toString(), "INFO");
		lastResponse = request.get(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * GET with path parameters
	 */
	public RestAssert getWithPathParams(String endpoint, Map<String, Object> pathParams) {
		RequestSpecification request = buildBaseRequest().pathParams(pathParams);
		reportStep("GET Path Parameters:\n" + pathParams.toString(), "INFO");
		lastResponse = request.get(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * GET with custom headers
	 */
	public RestAssert get(String endpoint, Map<String, String> headers, Map<String, Object> queryParams) {
		RequestSpecification request = buildBaseRequest().headers(headers).queryParams(queryParams);
		reportStep("GET Headers:\n" + headers.toString(), "INFO");
		reportStep("GET Query Parameters:\n" + queryParams.toString(), "INFO");
		lastResponse = request.get(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	// ==============================================
	// PUT METHODS
	// ==============================================

	/**
	 * PUT with JSON body
	 */
	public RestAssert put(String body, String endpoint) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.JSON).body(body);
		reportStep("PUT Request Body (JSON):\n" + beautifyJson(body), "INFO");
		lastResponse = request.put(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * PUT with form data
	 */
	public RestAssert putForm(Map<String, Object> formData, String endpoint) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.URLENC).formParams(formData);
		reportStep("PUT Request Form Data:\n" + formData.toString(), "INFO");
		lastResponse = request.put(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * PUT with custom headers
	 */
	public RestAssert put(String body, String endpoint, Map<String, String> headers) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.JSON).headers(headers).body(body);
		reportStep("PUT Request Body (JSON):\n" + beautifyJson(body), "INFO");
		reportStep("PUT Request Headers:\n" + headers.toString(), "INFO");
		lastResponse = request.put(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	// ==============================================
	// DELETE METHODS
	// ==============================================

	/**
	 * Simple DELETE request
	 */
	public RestAssert delete(String endpoint) {
		RequestSpecification request = buildBaseRequest();
		lastResponse = request.delete(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * DELETE with query parameters
	 */
	public RestAssert delete(String endpoint, Map<String, Object> queryParams) {
		RequestSpecification request = buildBaseRequest().queryParams(queryParams);
		reportStep("DELETE Query Parameters:\n" + queryParams.toString(), "INFO");
		lastResponse = request.delete(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * DELETE with path parameters
	 */
	public RestAssert deleteWithPathParams(String endpoint, Map<String, Object> pathParams) {
		RequestSpecification request = buildBaseRequest().pathParams(pathParams);
		reportStep("DELETE Path Parameters:\n" + pathParams.toString(), "INFO");
		lastResponse = request.delete(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

//    /**
//     * DELETE with custom headers
//     */
//    public RestAssert delete(String endpoint, Map<String, String> headers) {
//        RequestSpecification request = buildBaseRequest()
//                .headers(headers);
//        reportStep("DELETE Headers:\n" + headers.toString(), "INFO");
//        lastResponse = request.delete(endpoint);
//        logResponse();
//        return new RestAssert(lastResponse, this);
//    }

	/**
	 * DELETE with body (some APIs support DELETE with body)
	 */
	public RestAssert deleteWithBody(String body, String endpoint) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.JSON).body(body);
		reportStep("DELETE Request Body (JSON):\n" + beautifyJson(body), "INFO");
		lastResponse = request.delete(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	// ==============================================
	// PATCH METHODS
	// ==============================================

	/**
	 * PATCH with JSON body
	 */
	public RestAssert patch(String body, String endpoint) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.JSON).body(body);
		reportStep("PATCH Request Body (JSON):\n" + beautifyJson(body), "INFO");
		lastResponse = request.patch(endpoint);
		// Print the response for debugging
		System.out.println("PATCH Response:");
		lastResponse.prettyPrint();
		System.out.println("PATCH Response***********");
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	/**
	 * PATCH with custom headers
	 */
	public RestAssert patch(String body, String endpoint, Map<String, String> headers) {
		RequestSpecification request = buildBaseRequest().contentType(ContentType.JSON).headers(headers).body(body);
		reportStep("PATCH Request Body (JSON):\n" + beautifyJson(body), "INFO");
		reportStep("PATCH Request Headers:\n" + headers.toString(), "INFO");
		lastResponse = request.patch(endpoint);
		logResponse();
		return new RestAssert(lastResponse, this);
	}

	// ==============================================
	// UTILITY METHODS
	// ==============================================

	/**
	 * Build base request with common configurations
	 */
	private RequestSpecification buildBaseRequest() {
		String baseUri = APIBase.prop.getProperty("api.baseuri");
		String authToken = APIBase.prop.getProperty("api.token"); // Load from config

		return RestAssured.given().baseUri(baseUri).relaxedHTTPSValidation().header("Authorization",
				"Bearer " + authToken); // Add Auth globally
	}

	/**
	 * Log response details
	 */
	private void logResponse() {
		if (lastResponse != null) {
			reportStep("Response Status Code: " + lastResponse.getStatusCode(), "pass", false);
			reportStep("Response Headers:\n" + lastResponse.getHeaders().toString(), "pass", false);

			// Use beautifyJson to format the response body
			String beautifiedBody = beautifyJson(lastResponse.asString());
			reportStep("Response Body:\n" + beautifiedBody, "pass", false);

			reportStep("Response Time: " + lastResponse.getTime() + "ms", "pass", false);
		}
		// Clear RestAssured configurations to prevent sharing headers/baseURI between
		// requests
		RestAssured.reset();
	}

	/**
	 * Get the last response for additional operations
	 */
	public Response getLastResponse() {
		return lastResponse;
	}

	// ==============================================
	// FLUENT VALIDATION CLASS
	// ==============================================

	public static class RestAssert {
		private Response response;
		private RestUtils reporter;

		public RestAssert(Response response, RestUtils reporter) {
			this.response = response;
			this.reporter = reporter;
		}

		/**
		 * Validate status code
		 */
		public RestAssert validateStatus(int expectedStatus) {
			response.prettyPrint();
			int actualStatus = response.getStatusCode();
			System.out.println("Validating status code: Expected = " + expectedStatus + ", Actual = " + actualStatus);
			if (actualStatus != expectedStatus) {
				reporter.reportStep(
						"Status validation failed. Expected: " + expectedStatus + ", Actual: " + actualStatus, "FAIL");
				throw new AssertionError("Expected status: " + expectedStatus + " but got: " + actualStatus);
			}
			reporter.reportStep("Status validation passed: " + actualStatus, "PASS");
			return this;
		}

		/**
		 * Validate response time
		 */
		public RestAssert validateResponseTime(long maxTimeInMs) {
			long actualTime = response.getTime();
			if (actualTime > maxTimeInMs) {
				reporter.reportStep("Response time validation failed. Expected: <" + maxTimeInMs + "ms, Actual: "
						+ actualTime + "ms", "FAIL");
				throw new AssertionError(
						"Response time exceeded. Expected: <" + maxTimeInMs + "ms, Actual: " + actualTime + "ms");
			}
			reporter.reportStep("Response time validation passed: " + actualTime + "ms", "PASS");
			return this;
		}

		/**
		 * Validate response body contains text
		 */
		public RestAssert validateBodyContains(String expectedText) {
			String responseBody = response.asString();
			if (!responseBody.contains(expectedText)) {
				reporter.reportStep("Body validation failed. Expected text not found: " + expectedText, "FAIL");
				throw new AssertionError("Response body does not contain expected text: " + expectedText);
			}
			reporter.reportStep("Body validation passed. Found text: " + expectedText, "PASS");
			return this;
		}

		/**
		 * Validate response body does not contain text
		 */
		public RestAssert validateBodyNotContains(String unexpectedText) {
			String responseBody = response.asString();
			if (responseBody.contains(unexpectedText)) {
				reporter.reportStep("Body validation failed. Unexpected text found: " + unexpectedText, "FAIL");
				throw new AssertionError("Response body contains unexpected text: " + unexpectedText);
			}
			reporter.reportStep("Body validation passed. Text not found: " + unexpectedText, "PASS");
			return this;
		}

		/**
		 * Validate JSON path value
		 */
		public RestAssert validateJsonPath(String jsonPath, Object expectedValue) {
			Object actualValue = response.jsonPath().get(jsonPath);
			if (!actualValue.equals(expectedValue)) {
				reporter.reportStep("JSON path validation failed. Path: " + jsonPath + ", Expected: " + expectedValue
						+ ", Actual: " + actualValue, "FAIL");
				throw new AssertionError(
						"JSON path validation failed. Expected: " + expectedValue + ", Actual: " + actualValue);
			}
			reporter.reportStep("JSON path validation passed. Path: " + jsonPath + ", Value: " + actualValue, "PASS");
			return this;
		}

		/**
		 * Validate JSON path exists
		 */
		public RestAssert validateJsonPathExists(String jsonPath) {
			try {
				response.jsonPath().get(jsonPath);
				reporter.reportStep("JSON path validation passed. Path exists: " + jsonPath, "PASS");
			} catch (Exception e) {
				reporter.reportStep("JSON path validation failed. Path does not exist: " + jsonPath, "FAIL");
				throw new AssertionError("JSON path does not exist: " + jsonPath);
			}
			return this;
		}

		/**
		 * Validate JSON path list size
		 */
		public RestAssert validateJsonPathListSize(String jsonPath, int expectedSize) {
			List<Object> list = response.jsonPath().getList(jsonPath);
			int actualSize = list.size();
			if (actualSize != expectedSize) {
				reporter.reportStep("JSON path list size validation failed. Path: " + jsonPath + ", Expected size: "
						+ expectedSize + ", Actual size: " + actualSize, "FAIL");
				throw new AssertionError(
						"JSON path list size validation failed. Expected: " + expectedSize + ", Actual: " + actualSize);
			}
			reporter.reportStep("JSON path list size validation passed. Path: " + jsonPath + ", Size: " + actualSize,
					"PASS");
			return this;
		}

		/**
		 * Validate header value
		 */
		public RestAssert validateHeader(String headerName, String expectedValue) {
			String actualValue = response.getHeader(headerName);
			if (actualValue == null || !actualValue.equals(expectedValue)) {
				reporter.reportStep("Header validation failed. Header: " + headerName + ", Expected: " + expectedValue
						+ ", Actual: " + actualValue, "FAIL");
				throw new AssertionError(
						"Header validation failed. Expected: " + expectedValue + ", Actual: " + actualValue);
			}
			reporter.reportStep("Header validation passed. Header: " + headerName + ", Value: " + actualValue, "PASS");
			return this;
		}

		/**
		 * Validate header exists
		 */
		public RestAssert validateHeaderExists(String headerName) {
			String headerValue = response.getHeader(headerName);
			if (headerValue == null) {
				reporter.reportStep("Header validation failed. Header does not exist: " + headerName, "FAIL");
				throw new AssertionError("Header does not exist: " + headerName);
			}
			reporter.reportStep("Header validation passed. Header exists: " + headerName, "PASS");
			return this;
		}

		/**
		 * Validate content type
		 */
		public RestAssert validateContentType(String expectedContentType) {
			String actualContentType = response.getContentType();
			if (actualContentType == null || !actualContentType.contains(expectedContentType)) {
				reporter.reportStep("Content type validation failed. Expected: " + expectedContentType + ", Actual: "
						+ actualContentType, "FAIL");
				throw new AssertionError("Content type validation failed. Expected: " + expectedContentType
						+ ", Actual: " + actualContentType);
			}
			reporter.reportStep("Content type validation passed: " + actualContentType, "PASS");
			return this;
		}

		/**
		 * Validate using Hamcrest matchers
		 */
		public RestAssert validateJsonPath(String jsonPath, Matcher<?> matcher) {
			response.then().body(jsonPath, matcher);
			reporter.reportStep("JSON path validation with matcher passed. Path: " + jsonPath, "PASS");
			return this;
		}

		/**
		 * Retrieve a value from the JSON response using a JSON path.
		 *
		 * @param jsonPath The JSON path to extract the value.
		 * @return The value extracted from the JSON response.
		 * @throws IllegalStateException if the last response is null.
		 */
		public Object getValueFromJsonResponse(String jsonPath) {
			if (lastResponse == null) {
				throw new IllegalStateException(
						"No response available. Ensure a request has been made before calling this method.");
			}
			try {
				return lastResponse.jsonPath().get(jsonPath);
			} catch (Exception e) {
				throw new RuntimeException("Failed to retrieve value from JSON response for path: " + jsonPath, e);
			}
		}

		/**
		 * Custom validation with lambda
		 */
		public RestAssert validateCustom(java.util.function.Predicate<Response> validator, String validationMessage) {
			if (!validator.test(response)) {
				reporter.reportStep("Custom validation failed: " + validationMessage, "FAIL");
				throw new AssertionError("Custom validation failed: " + validationMessage);
			}
			reporter.reportStep("Custom validation passed: " + validationMessage, "PASS");
			return this;
		}

		/**
		 * Get the response for additional operations
		 */
		public Response getResponse() {
			return response;
		}

		/**
		 * Extract value from JSON path
		 */
		public <T> T extractValue(String jsonPath) {
			return response.jsonPath().get(jsonPath);
		}

		/**
		 * Extract header value
		 */
		public String extractHeader(String headerName) {
			return response.getHeader(headerName);
		}

		/**
		 * Print response for debugging
		 */
		public RestAssert printResponse() {
			reporter.reportStep("Response Details:\n" + response.asString(), "INFO");
			return this;
		}
	}

	@Override
	public long takeSnap() {
		// Since this is for API testing, we don't need screenshots
		// Return 0 or implement if needed for your framework
		return 0;
	}
}