package starter.Reqres;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.JSONAssertion;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USERS =  Constants.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";
    public static String GET_SINGLE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String PUT_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String GET_SINGLE_USER_NOT_FOUND = Constants.BASE_URL+"/api/users/{id}";
    public static String LIST_RESOURCE = Constants.BASE_URL+"/api/unknown/{id}";
    public static String POST_REGISTER = Constants.BASE_URL+"/api/register";
    public static String POST_LOGIN = Constants.BASE_URL+"/api/login";

    @Step("Get list users")
    public void setGetListUsers(int page){
        SerenityRest.given()
                .pathParam("page", page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get single user")
    public void setGetSingleUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get single user not found")
    public void setGetSingleUserNotFound(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get list resource")
    public void setListResource(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Post Register")
    public void postRegister(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get single resource")
    public void GetSingleResource(int id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Post Login")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }



}
