package testCases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.Map;

public class BaseTest {
    String BASE_URI = "https://restcountries.com/v3.1";
    String CONTENT_TYPE_JSON = "application/json";
    RequestSpecification requestSpecification;

    @BeforeSuite
    public void beforeSuite(ITestContext ctx) {
        Map<String, String> suitParamMap = ctx.getSuite().getXmlSuite().getParameters();
        // put all parameters.
        suitParamMap.putAll(RestCountriesTestApp.paramMap);
    }

    @BeforeClass
    public void BeforeClass(){
        //Using Request spec builder
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri(BASE_URI).
                setContentType(CONTENT_TYPE_JSON);
        requestSpecification = requestSpecBuilder.build();
    }

}