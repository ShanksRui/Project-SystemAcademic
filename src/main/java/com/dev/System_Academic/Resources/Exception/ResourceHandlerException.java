package com.dev.System_Academic.Resources.Exception;

import java.net.HttpURLConnection;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.dev.System_Academic.Services.Exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceHandlerException {

	public ResponseEntity<ResourceNotFoundException> NotFound(ResourceNotFoundException e, ServletServerHttpRequest request){
         String erro = "Resource not Found";
         Integer status = HttpURLConnection.HTTP_NOT_FOUND;
         StandardError ste = new StandardError(Instant.now(), status, erro, e.getMessage() ,request.getURI().getPath());
         return ResponseEntity.status(status).body(ste);
	}
}
