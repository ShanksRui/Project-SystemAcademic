package com.dev.System_Academic.Resources.Exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dev.System_Academic.Services.Exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceHandlerException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> NotFound(ResourceNotFoundException e, HttpServletRequest request){
         String erro = "Resource not Found";
         HttpStatus status = HttpStatus.NOT_FOUND;
         StandardError ste = new StandardError();
         ste.setError(erro);
         ste.setStatus(status.value());
         ste.setMessage(e.getMessage());
         ste.setMoment(Instant.now());
         ste.setPath(request.getRequestURI());
         return ResponseEntity.status(status).body(ste);
	}
}

