package starter.stepdef;

import com.github.fge.jsonschema.main.JsonSchema;
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

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Restration sucsesful
    @Given("Post Register user with valid json")
    public void postRegisterUSerWithValidJson() {
        File json = new File(Constants.REQ_BODY+"/RegisterValidUser.json");
        reqresAPI.postRegister(json);
    }

    @When("Send request post Register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @And("Respons body id was {int} and token was {string}")
    public void responsBodyIdWasAndTokenWas(int id, String token) {
        SerenityRest.and()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }
    //Register unsucsesful
    @Given("post Register user without password")
    public void postRegisterUserWithoutPassword() {
        File json = new File(Constants.REQ_BODY + "/RegisterUnvalidUser.json");
        reqresAPI.postRegister(json);
    }

    @Then("Status code should be {int} BadRequest")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Respons body was {string}")
    public void responsBodyErrorMissingPassword(String MissingPassword) {
        SerenityRest.and()
                .body(ReqresResponses.ERROR,equalTo(MissingPassword));
    }

    @And("Validate success post register user json schema")
    public void validateSuccessPostRegisterUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/RegisterSuccesSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate Unsuccess post register user json schema")
    public void validateUnsuccessPostRegisterUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/RegisterUnsuccesSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //Register unsucsesful2
    @Given("post Register user without email")
    public void postRegisterUserWithoutEmail() {
        File json = new File(Constants.REQ_BODY + "/RegisterWithoutEmail.json");
        reqresAPI.postRegister(json);
    }

    @And("Validate Unsuccess post register without email json schema")
    public void validateUnsuccessPostRegisterWithoutEmailJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/RegisterUnsuccesWithoutEmailSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("post Register user without email and password")
    public void postRegisterUserWithoutEmailAndPassword() {
        File json = new File(Constants.REQ_BODY + "/RegisterWithoutEmailAndPassword.json");
        reqresAPI.postRegister(json);
    }

    @And("Validate Unsuccess post register without email and password json schema")
    public void validateUnsuccessPostRegisterWithoutEmailAndPasswordJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/RegisterUnsuccesWithoutEmailAndPasswordSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
