package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class ListUsersStepDef {
      // Disini adalah class untuk step def dari List Users
   @Steps
   ReqresAPI reqresAPI;

    //get list users
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.setGetListUsers(page);
    }
    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("Respons body page value should be {int}")
    public void responsBodyPageValueShouldBePage(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));
    }
    @And("Validate success Get single user json schema")
    public void validateSuccessGetSingleUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/GetlListUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Validate success Get single user not found json schema")
    public void validateSuccessGetSingleUserNotFoundJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/GetListSingleUserNotFound.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Validate success Get list Resource json schema")
    public void validateSuccessGetListResourceJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/GetListResourceSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // Get single users
    @Given("Get single resource with parameter page {int}")
    public void getSingleResourceWithParameterPage(int id) {
        reqresAPI.setGetSingleUser(id);
    }
    @And("Validate success Get single resource json schema")
    public void validateSuccessGetSingleResourceJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/GetSingleResourceSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // Get single resource not found
    @And("Validate success Get single resource not found json schema")
    public void validateSuccessGetSingleResourceNotFoundJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/GetSingleUserNotFoundSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }

}
