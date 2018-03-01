package br.com.campaigns.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Campanha não encontrada ou inválida")
public class InvalidCampaignException extends Exception{
	private static final long serialVersionUID = 1L;
}
