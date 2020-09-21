package controller;

import http.request.HttpMethod;
import http.request.HttpRequest;
import http.response.HttpResponse;

public abstract class AbstractController implements Controller {
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        if (httpRequest.isMatchMethod(HttpMethod.GET)) {
            doGet(httpRequest, httpResponse);
        }
        if (httpRequest.isMatchMethod(HttpMethod.POST)) {
            doPost(httpRequest, httpResponse);
        }
    }

    void doPost(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.methodNotAllowed();
    }

    ;


    void doGet(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.methodNotAllowed();
    }

    ;
}
