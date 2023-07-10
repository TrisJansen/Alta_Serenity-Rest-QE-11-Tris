package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;


public class UpdateStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Put update user with valid id {int} and job was numerik")
    public void putUpdateUserWithValidIdJsonAndWasNumerik(int id) {
        File json = new File(Constants.REQ_BODY+"/LogUpdateUserWithJobWasNumerik.json");
        reqresAPI.putUpdateUser(id, json);

    }

    @Given("Put update user with valid id {int} without job body")
    public void putUpdateUserWithValidIdWithoutJobBody(int id) {
        File json = new File(Constants.REQ_BODY+"/UpdateUserWithoutJobBody.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @And("Validate success put update user json schema without job body")
    public void validateSuccessPutUpdateUserJsonSchemaWithoutJobBody() {
        File json = new File(Constants.JSON_SCHEMA+"/PutUpdateUserWithoutJobBodySchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update user with valid id {int} without user name on name body")
    public void putUpdateUserWithValidIdWithoutUserNameOnNameBody(int id) {
        File json = new File(Constants.REQ_BODY+"/UpdateUserWithoutNameBody.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @And("Validate success put update user json schema without name body")
    public void validateSuccessPutUpdateUserJsonSchemaWithoutNameBody() {
        File json = new File(Constants.JSON_SCHEMA+"/PutUpdateUserWithoutNameBodySchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update user with valid id {int} without user name and job body")
    public void putUpdateUserWithValidIdWithoutUserNameAndJobBody(int id) {
        File json = new File(Constants.REQ_BODY+"/UpdateUserWithoutNameAndJobBody.json");
        reqresAPI.putUpdateUser(id, json);
    }
}
