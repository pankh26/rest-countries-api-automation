package testCases;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CodeTest extends BaseTest {
    private static final String SEARCH_BY_COUNTRY_CODE = "/alpha";

    //Verify capital for valid cca2 country code
    @Parameters({ "code" })
    @Test(description = "Enter the valid country code cca2 and verify the response. Ex: for germany, cca2 is DE")
    public void validateCapitalForValidCCA2(String code) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<String> jsonResponse = response.jsonPath().getList("capital[0]");

        String capital = jsonResponse.get(0);
        Assert.assertNotNull(capital,"Capital value is wrong or not found for the given country");
    }

    //Verify capital for valid ccn3 country code
    @Parameters({ "code" })
    @Test(description = "Enter the valid country code ccn3 and verify the response. Ex: for germany, ccn3 is 276")
    public void validateCapitalForValidCCN3(String code) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<String> jsonResponse = response.jsonPath().getList("capital[0]");

        String capital = jsonResponse.get(0);
        Assert.assertNotNull(capital, "Capital value is wrong or not found for the given country");
    }

    //Verify capital for valid cca3 country code
    @Parameters({ "code" })
    @Test(description = "Enter the valid country code cca3 and verify the response. Ex: for germany, cca3 is DEU")
    public void validateCapitalForValidCCA3(String code) {
            Response response = given().
                    spec(requestSpecification).
                    when().
                    pathParam("countryCode", code).
                    get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                    then().
                    assertThat().
                    statusCode(HttpStatus.SC_OK).
                    extract().
                    response();
            List<String> jsonResponse = response.jsonPath().getList("capital[0]");

            String capital = jsonResponse.get(0);
            Assert.assertNotNull(capital, "Capital value is wrong or not found for the given country");
        }

    //Verify capital for valid cioc country code
    @Parameters({ "code" })
    @Test(description = "Enter the valid country code cioc and verify the response. Ex: for germany, cioc is GER")
    public void validateCapitalForValidCIOC(String code) {
       Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<String> jsonResponse = response.jsonPath().getList("capital[0]");

        String capital = jsonResponse.get(0);
        Assert.assertNotNull(capital,"Capital value is wrong or not found for the given country");
    }

    //Verify capital for case-sensitive country code
    @Parameters({ "code" })
    @Test(description = "Enter country code cca2 in lowercase and verify the response. Ex: in ")
    public void validateCapitalForCaseSensitiveCountryCode(String code) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<String> jsonResponse = response.jsonPath().getList("capital[0]");

        String capital = jsonResponse.get(0);
        Assert.assertNotNull(capital,"Capital value is wrong or not found for the given country");
    }

    //Verify capital for case-sensitive cca3 country code
    @Parameters({ "code" })
    @Test(description = "Enter country code cca2 in lowercase and verify the response. Ex: deu ")
    public void validateCapitalForCaseSensitiveCca3CountryCode(String code) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<String> jsonResponse = response.jsonPath().getList("capital[0]");

        String capital = jsonResponse.get(0);
        Assert.assertNotNull(capital,"Capital value is wrong or not found for the given country");
    }

    //Verify capital for case-sensitive cioc country code
    @Parameters({ "code" })
    @Test(description = "Enter country code cioc in lowercase and verify the response. Ex: ger ")
    public void validateCapitalForCaseSensitiveCiocCountryCode(String code) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<String> jsonResponse = response.jsonPath().getList("capital[0]");

        String capital = jsonResponse.get(0);
        Assert.assertNotNull(capital,"Capital value is wrong or not found for the given country");
    }

    //Verify capital for invalid cca2 country code
    @Parameters({ "code" })
    @Test(description = "Enter an invalid country code cca2 and verify the response. Ex: og ")
    public void validateCapitalForInvalidCCA2CountryCode(String code) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    //Verify capital for invalid ccn3 country code
    @Parameters({ "code" })
    @Test(description = "Enter an invalid country code ccn3 and verify the response. Ex: 50 ")
    public void validateCapitalForInvalidCCN3CountryCode(String code) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    //Verify capital for invalid cioc or cca3 country code
    @Parameters({ "code" })
    @Test(description = "Enter an invalid country code cioc/cca3 and verify the response. Ex: ghl ")
    public void validateCapitalForInvalidCiocOrCca3CountryCode(String code) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    //Verify capital for alpha numeric country code
    @Parameters({ "code" })
    @Test(description = "Enter an invalid country code ccn3 and verify the response. Ex: IN67 ")
    public void validateCapitalForAlphaNumericCountryCode(String code) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    //Verify capital for special characters country code
    @Parameters({ "code" })
    @Test(description = "Enter an invalid country code ccn3 and verify the response. Ex: DE@& ")
    public void validateCapitalForSpecialCharCountryCode(String code) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                extract().
                response();
    }

    //Verify capital for null country code
    @Parameters({ "code" })
    @Test(description = "Enter empty country code ccn3 and verify the response")
    public void validateCapitalForNullCountryCode(String code) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                extract().
                response();
    }

    //Verify capital for numeric country code more than 3 digit
    @Parameters({ "code" })
    @Test(description = "Enter country code ccn3 more than 3digit and verify the response. Ex: 27654 ")
    public void validateCapitalForMoreThan3digitNumericCountryCode(String code) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                extract().
                response();
    }

    //Verify capital for country code more than 3 character
    @Parameters({ "code" })
    @Test(description = "Enter an invalid country code cca3/cioc/cca2 and verify the response. Ex: INDI ")
    public void validateCapitalForMoreThan3CharacterCountryCode(String code) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryCode", code).
                get(SEARCH_BY_COUNTRY_CODE + "/{countryCode}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                extract().
                response();
    }

}
