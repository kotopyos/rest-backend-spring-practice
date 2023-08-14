package com.example.restbackendspringpractice;

import com.example.restbackendspringpractice.domain.UserInfo;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.with;

public class BankControllerTest {


    private RequestSpecification spec =
            with()
            .baseUri("http://localhost:8080")
            .basePath("/");
    @Test
    void bankControllerTest() {
         UserInfo[] userInfos = spec.get("user/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserInfo[].class);

    }
}
