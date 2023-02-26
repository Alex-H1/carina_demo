package com.test.carina.demo.api.todos;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/todo/1", methodType = HttpMethodType.GET)
@RequestTemplatePath(path = "api/todos/_get/rq.json")
@ResponseTemplatePath(path = "api/todos/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetTodoMethod extends AbstractApiMethodV2 {

    public GetTodoMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }

}
