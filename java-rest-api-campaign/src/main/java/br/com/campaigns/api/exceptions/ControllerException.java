package br.com.campaigns.api.exceptions;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler(ConstraintViolationException.class)
	public void handlerConstraintViolationException(HttpServletResponse response, Exception e) throws IOException {
		String errorMessage = String.format("Erro ao processar sua requisição, verifique os dados de entrada: ",
				e.getMessage());
		response.sendError(HttpStatus.BAD_REQUEST.value(), errorMessage);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public void handleIllegalArgumentException(HttpServletResponse response, Exception e) throws IOException {
		String errorMessage = String.format("Erro ao processar sua requisição, verifique os dados de entrada: ",
				e.getMessage());
		response.sendError(HttpStatus.BAD_REQUEST.value(), errorMessage);
	}

	@ExceptionHandler(DataAccessException.class)
	public void handlerDataAccessException(HttpServletResponse response, Exception e) throws IOException {
		String errorMessage = String.format("Erro ao processar sua requisição: ", e.getMessage());
		response.sendError(HttpStatus.BAD_GATEWAY.value(), errorMessage);
	}

}
