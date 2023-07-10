package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.utils.Constants;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Login Success
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Constants.REQ_BODY+"/Login.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Send request post Login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @And("Respons body token was {string}")
    public void responsBodyTokenWas(String token) {
        SerenityRest.and()
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate success post Login user json schema")
    public void validateSuccessPostLoginUserJsonSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/PostLoginSuccesfullSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // Login without password
    @Given("Post login user with without password")
    public void postLoginUserWithWithoutPassword() {
        File json = new File(Constants.REQ_BODY+"/LoginWithoutPassword.json");
        reqresAPI.postLoginUser(json);
    }
    @And("Validate post login unsuccess without password")
    public void validatePostLoginUnsuccessWithoutPassword() {
        File json = new File(Constants.JSON_SCHEMA+"/PostLoginUnsuccesfullWithoutPasswordSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post login user with without email")
    public void postLoginUserWithWithoutEmail() {
        File json = new File(Constants.REQ_BODY+"/LoginWithoutEmail.json");
        reqresAPI.postLoginUser(json);
    }

    @And("Validate post login unsuccess without email")
    public void validatePostLoginUnsuccessWithoutEmail() {
        File json = new File(Constants.JSON_SCHEMA+"/PostLoginUnsuccesfullWithoutEmailSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post login user with without email and password")
    public void postLoginUserWithWithoutEmailAndPassword() {
        File json = new File(Constants.REQ_BODY+"/LoginWithoutEmailAndPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @And("Validate post login unsuccess without email and password")
    public void validatePostLoginUnsuccessWithoutEmailAndPassword() {
        File json = new File(Constants.JSON_SCHEMA+"/PostLoginWithoutEmailAndPasswordSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
