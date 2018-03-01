package br.com.campaigns.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Torcedor não localizado")
public class InvalidSupporterException extends Exception {

	private static final long serialVersionUID = 1L;
}
