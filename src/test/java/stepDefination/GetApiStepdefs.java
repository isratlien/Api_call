package stepDefination;

import Core.ApiCall;
import Core.DatabaseManager;
import Core.HeaderFormatHelper;
import Repository.localRepo.dbModel.GetApiDbModel;
import Repository.remoteRepo.responseRepo.UserGetApiResponseModel;
import Repository.remoteRepo.responseRepo.UserPostApiResponseModel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.response.Response;

import java.sql.ResultSet;
import java.sql.SQLException;

import static Core.CoreConstrainHelper.base_url;

public class GetApiStepdefs {
    String url;
    private Response responseGetApi;

    GetApiDbModel getApiDbModel;
    private final Gson gson = new Gson();

    @Given("user has the base api")
    public void userHasTheBaseApi() {
        url = base_url + "users";
    }

    @When("user call the {string} and {string}")
    public void userCallTheParameterAndParamsValue( String parameter,String paramsValue) {
        url = url +parameter + "="+ paramsValue;
        System.out.println(url);
        responseGetApi = ApiCall.getCall(HeaderFormatHelper.commonHeaders(),url);
        System.out.println(responseGetApi.body().asString());
    }

    @Then("it will return valid date")
    public void itWillReturnValidDate() throws SQLException, ClassNotFoundException {
        System.out.println(url);
        System.out.println("hlwwwwwwwwww");


        UserGetApiResponseModel getApiResponseModel = gson.fromJson(responseGetApi.getBody().asString(), UserGetApiResponseModel.class);
        System.out.println(getApiResponseModel.getPage());
        System.out.println(getApiResponseModel.getData().get(0).getFirst_name());
        for(int i=11;i<=33;i=i+11){
        ResultSet rs =  DatabaseManager.executeQueries("select * from qa_test1 where id =" + i + " ");

        while (rs.next()) {

            getApiDbModel = new GetApiDbModel();
            getApiDbModel.setJob(rs.getString(3));
            getApiDbModel.setName(rs.getString(1));
            getApiDbModel.setId(rs.getInt(2));
            getApiDbModel.setSalary(rs.getInt(4));
            System.out.println(getApiDbModel.getId());
            System.out.println(getApiDbModel.getJob());
            System.out.println(getApiDbModel.getName());
            System.out.println(getApiDbModel.getSalary());

            // System.out.println(rs.getString(2));
        }

        }
    }

}
