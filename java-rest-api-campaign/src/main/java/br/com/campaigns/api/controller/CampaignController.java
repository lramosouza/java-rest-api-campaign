package br.com.campaigns.api.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.campaigns.api.component.CampaignComponent;
import br.com.campaigns.api.dto.CampaignRequestDTO;
import br.com.campaigns.api.dto.CampaignResponseDTO;
import br.com.campaigns.api.exceptions.InvalidCampaignException;

@RestController
@RequestMapping(value = "api/v1/campanha")
public class CampaignController {

	@Autowired
	private CampaignComponent campaignComponent;

	@ApiOperation(value = "Método responsável pelo salvamento de campanhas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CampaignResponseDTO save(@RequestBody @Valid CampaignRequestDTO campaignRequest) {
		return this.campaignComponent.save(campaignRequest);
	}

	@ApiOperation(value = "Método responsável por alterar campanhas já existentes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public CampaignResponseDTO update(@PathVariable String id, @RequestBody @Valid CampaignRequestDTO campaignRequest)
			throws InvalidCampaignException {
		return this.campaignComponent.update(id, campaignRequest);
	}

	@ApiOperation(value = "Método responsável pela deleção de campanhas", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public void delete(@PathVariable String id) throws InvalidCampaignException {
		this.campaignComponent.delete(id);
	}

	@ApiOperation(value = "Metodo responsável por retornar todas as consultas vigentes", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CampaignResponseDTO> getAllValidCompaigns() {
		return campaignComponent.getAllValidCompaigns();
	}

	@ApiOperation(value = "Método responsável pela consulta de uma campanha pelo id", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public CampaignResponseDTO getByID(@PathVariable String id) throws InvalidCampaignException {
		return this.campaignComponent.getCampaign(id);
	}

	@ApiOperation(value = "Metodo responsável pela consulta de campanhas vigentes por time", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/time/{favoriteTeamID}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<CampaignResponseDTO> getValidCampaignsByTeam(@PathVariable String favoriteTeamID) {
		return campaignComponent.getValidCampaignsByTeam(favoriteTeamID);
	}
}