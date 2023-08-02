package testCases;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class NameTest extends BaseTest {

    private static final String SEARCH_BY_COUNTRY_NAME = "/name";

    //Assert status code for valid country name
    @Parameters({ "name" })
    @Test(description = "Enter a valid country name and verify the status code")
    public void validateGETStatusCodeForValidCountryName(String name) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }

//  Assert capital for partial valid country name
    @Parameters({ "name" })
    @Test(description = "Enter a valid country name with partial chars and verify the response. Ex: Germ")
    public void validateCapitalForPartialValidCountryName(String name) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK);
    }

    //Extract and assert capital city from the response when there is only 1 match
    @Parameters({ "name" })
    @Test(description = "Enter the full valid country name and verify the response. Ex: germany")
    public void verifyCapitalForCountryWithSingleMatch(String name) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<String> jsonResponse = response.jsonPath().getList("capital[0]");

        String capital = jsonResponse.get(0);
        Assert.assertNotNull(capital,"Capital value is wrong or not found for the given country");
    }

    //Extract and assert capital city from the response when there are multiple matches
    @Parameters({ "name" })
    @Test(description = "Enter the full valid country name and verify the response. Ex: india")
    public void verifyCapitalForCountryWithMultipleMatch(String name) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<List<String>> capitals = response.jsonPath().getList("capital");

        for (List<String> capital : capitals) {
            Assert.assertNotNull(capital, "Capital is not present");
            for (int i = 0; i < capital.size(); i++) {
                Assert.assertNotNull(capital.get(i), "Capital value is wrong or not found");
            }
        }
    }

    //Verify capital when common country value has space
    @Parameters({ "name" })
    @Test(description = "Enter the valid country name with space and verify the response. Ex: United States")
    public void verifyCapitalForCountryWithSpaces(String name) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<List<String>> capitals = response.jsonPath().getList("capital");

        for (List<String> capital : capitals) {
            Assert.assertNotNull(capital, "Capital is not present");
            for (int i = 0; i < capital.size(); i++) {
                Assert.assertNotNull(capital.get(i), "Capital value is wrong or not found");
            }
        }
    }


    //Verify capital for case sensitive country value
    @Parameters({ "name" })
    @Test(description = "Enter the valid country name caps on and verify the response. Ex: GERMANY")
    public void verifyCapitalForCountryWithCapsOn(String name) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<List<String>> capitals = response.jsonPath().getList("capital");

        for (List<String> capital : capitals) {
            Assert.assertNotNull(capital, "Capital is not present");
            for (int i = 0; i < capital.size(); i++) {
                Assert.assertNotNull(capital.get(i), "Capital value is wrong or not found");
            }
        }
    }

    //Verify capital for official country value with spaces
    @Parameters({ "name" })
    @Test(description = "Enter the valid country name and verify the response. Ex: United States of America")
    public void verifyCapitalForOfficialCountryWithSpaces(String name) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<List<String>> capitals = response.jsonPath().getList("capital");

        for (List<String> capital : capitals) {
            Assert.assertNotNull(capital, "Capital is not present");
            for (int i = 0; i < capital.size(); i++) {
                Assert.assertNotNull(capital.get(i), "Capital value is wrong or not found");
            }
        }
    }

    //Verify capital for partial official country value
    @Parameters({ "name" })
    @Test(description = "Enter the valid official partial country name and verify the response. Ex: Republic of")
    public void verifyCapitalForPartialOfficialCountry(String name) {
        Response response = given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().
                response();
        List<List<String>> capitals = response.jsonPath().getList("capital");

        for (List<String> capital : capitals) {
            Assert.assertNotNull(capital, "Capital is not present");
            for (int i = 0; i < capital.size(); i++) {
                Assert.assertNotNull(capital.get(i), "Capital value is wrong or not found");
            }
        }
    }

    //Verify capital when common country value has no space
    @Parameters({ "name" })
    @Test(description = "Enter the valid country name without spaces and verify the response. Ex: UnitedStates")
    public void verifyCapitalForCountryWithNoSpace(String name) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    //Verify capital for official country value with no spaces
    @Parameters({ "name" })
    @Test(description = "Enter the valid country name with no space and verify the response. Ex: UnitedStatesofAmerica")
    public void verifyCapitalForOfficialCountryWithNoSpaces(String name) {
         given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    // Verify capital response for an invalid country with numeric value
    @Parameters({ "name" })
    @Test(description = "Enter numeric value as country name and verify the response. Ex: 355")
    public void verifyCapitalForCountryWithNumeric(String name) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    // Verify capital response for an invalid country with alpha numeric value
    @Parameters({ "name" })
    @Test(description = "Enter the valid country name with numeric and verify the response. Ex: United 45")
    public void verifyCapitalForCountryWithAlphaNumeric(String name) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    // Verify capital response for an invalid country with special characters
    @Parameters({ "name" })
    @Test(description = "Enter the country name with special char and verify the response. Ex: India !#@")
    public void verifyCapitalForCountryWithSpecialCharacters(String name) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    // Verify capital response for a country value which does not exist
    @Parameters({ "name" })
    @Test(description = "Enter an invalid country name and verify the response. Ex: mbo")
    public void verifyCapitalForCountryDoesNotExist(String name) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

    // Verify capital response for null country value
    @Parameters({ "name" })
    @Test(description = "Enter empty string as country name and verify the response ")
    public void verifyCapitalForNullCountry(String name) {
        given().
                spec(requestSpecification).
                when().
                pathParam("countryName", name).
                get(SEARCH_BY_COUNTRY_NAME + "/{countryName}").
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                extract().
                response();
    }

}
