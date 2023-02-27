package com.test.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.test.carina.demo.api.todos.DeleteTodoMethod;
import com.test.carina.demo.api.todos.GetAllTodoMethod;
import com.test.carina.demo.api.todos.GetTodoMethod;
import com.test.carina.demo.api.todos.PostTodoMethod;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class APITest implements IAbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(APITest.class);

    @Test
    public void testCreateTodo() {
        setCases("4555,54545");
        PostTodoMethod api = new PostTodoMethod();
//        api.setProperties("api/todos/todo.properties");
        AtomicInteger counter = new AtomicInteger(0);
        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test
    public void testGetTodo(){
        GetTodoMethod api = new GetTodoMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/todos/_get/rs.schema");
    }

    @Test
    public void testGetTodos(){
        GetAllTodoMethod api = new GetAllTodoMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/todos/_getall/rs.schema");
    }

    @Test
    @TestPriority(Priority.P1)
    public void testDeleteTodo(){
        DeleteTodoMethod api = new DeleteTodoMethod();
//        api.setProperties("api/todos/todo.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}
