package br.com.campaigns.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.campaigns.api.component.CampaignSupporterAssociationComponent;
import br.com.campaigns.api.dto.CampaignSupporterRequestDTO;
import br.com.campaigns.api.dto.CampaignSupporterResponseDTO;
import br.com.campaigns.api.exceptions.InvalidAssociationException;
import br.com.campaigns.api.exceptions.InvalidCampaignException;
import br.com.campaigns.api.exceptions.InvalidRequestException;
import br.com.campaigns.api.exceptions.InvalidSupporterException;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api/v1/associacoes")
public class CampaignSupporterController {

	@Autowired
	private CampaignSupporterAssociationComponent campaignSupporterAssociationComponent;

	@ApiOperation(value = "Método responsável pela associação de campanhas e torcedores", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public CampaignSupporterResponseDTO associate(@RequestBody @Valid CampaignSupporterRequestDTO campaignSupporterRequest)
			throws InvalidRequestException, InvalidAssociationException, InvalidCampaignException,
			InvalidSupporterException {
		return campaignSupporterAssociationComponent.save(campaignSupporterRequest);
	}

	@ApiOperation(value = "Método responsável pela exclusão de associacao", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable String id) throws InvalidAssociationException, InvalidSupporterException {
		this.campaignSupporterAssociationComponent.delete(id);
	}

	@ApiOperation(value = "Método que consulta uma associacao por id da campanha", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/campanha/{campaignID}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<CampaignSupporterResponseDTO> buscarPorCampanha(@PathVariable String campaignID)
			throws InvalidCampaignException {
		return campaignSupporterAssociationComponent.getCampaingByID(campaignID);
	}

	@ApiOperation(value = "Método que retorna todas as associações", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CampaignSupporterResponseDTO> buscarTodasAssociacoes() {
		return campaignSupporterAssociationComponent.getAllCampaigns();
	}

	@ApiOperation(value = "Método que consulta uma associacao por email do torcedor", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/torcedor", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CampaignSupporterResponseDTO> buscarPorEmailTorcedor(@RequestBody @Valid String email)
			throws InvalidCampaignException {
		return campaignSupporterAssociationComponent.getCampaingByEmail(email);
	}
}