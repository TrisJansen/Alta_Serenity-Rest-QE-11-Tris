package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.utils.Constants;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //post create new body user
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constants.REQ_BODY+"/User.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Respons body name was {} and job was {}")
    public void responsBodyNameWasAndJobWas(String name, int job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    //get single users
    @Given("Get single user with valid parameter page {int}")
    public void getSingleUserWithValidParameterPage(int page) {
        reqresAPI.setGetSingleUser(page);
    }

    @When("Send request get single users")
    public void sendRequestGetSingleUsers() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @Then("Status single user code should be {int} OK")
    public void statusSingleUserCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body id value should be {int}")
    public void responsesBodyPageValueShouldBe(int id) {
        SerenityRest.and().body(ReqresResponses.DATA_ID,equalTo(id));

    }

    @And("Response body email should be email {string}")
    public void responseBodyPageShouldBeEmail(String email) {
        SerenityRest.and().body(ReqresResponses.DATA_EMAIL,equalTo(email));
    }
    // Put user update
    @Given("Put update user with valid id {int} and json")
    public void putUpdateUserWithValidIdAndJson(int id) {
        File json = new File(Constants.REQ_BODY+"/updateUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
    // Delete users
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
    // Single user not found
    @Given("Get single user not found with unvalid parameter page {int}")
    public void getSingleUserNotFoundWithFalidUnvalidParameterPage(int id) {
        reqresAPI.setGetSingleUserNotFound(id);
    }
    @When("send request get single user not found")
    public void sendRequestGetSingleUserNotFound() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER_NOT_FOUND);
    }
    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
    // List <Resource>
    @Given("Get list resource without parameter page {}")
    public void getListResourceWithoutParameterPage(int id) {
        reqresAPI.setListResource(id);
    }
    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(ReqresAPI.LIST_RESOURCE);
    }

    @And("Response body name should be name {string}")
    public void responseBodyNameShouldBeName(String name) {
        SerenityRest.and().body(ReqresResponses.DATA_NAME,equalTo(name));
    }


}
