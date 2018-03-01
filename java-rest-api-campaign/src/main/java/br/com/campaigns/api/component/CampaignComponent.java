package br.com.campaigns.api.component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.campaigns.api.dto.CampaignRequestDTO;
import br.com.campaigns.api.dto.CampaignResponseDTO;
import br.com.campaigns.api.exceptions.InvalidCampaignException;
import br.com.campaigns.api.model.Campaign;
import br.com.campaigns.api.service.CampaignService;

@Component
public class CampaignComponent {

	@Autowired
	private CampaignService campaignService;

	public CampaignResponseDTO getCampaign(String  id) throws InvalidCampaignException {
		return Optional.ofNullable(campaignService.getCampaignByID(id)).map(CampaignResponseDTO::new)
				.orElseThrow(() -> new InvalidCampaignException());
	}

	public List<CampaignResponseDTO> getAllCampaigns() {
		return campaignService.getAllCampaigns().stream().map(CampaignResponseDTO::new).collect(Collectors.toList());
	}

	public CampaignResponseDTO save(CampaignRequestDTO campaignRequest) {
		return new CampaignResponseDTO(this.campaignService.save(campaignRequest.toCampaign()));
	}

	public CampaignResponseDTO update(String id, CampaignRequestDTO campaignRequest) throws InvalidCampaignException {
		Optional.ofNullable(campaignService.getCampaignByID(id)).orElseThrow(() -> new InvalidCampaignException());

		Campaign campaign = campaignRequest.toCampaign();
		campaign.setId(id);
		return new CampaignResponseDTO(campaignService.save(campaign));
	}

	public void delete(String id) throws InvalidCampaignException {
		Campaign campaign = Optional.ofNullable(campaignService.getCampaignByID(id))
				.orElseThrow(() -> new InvalidCampaignException());
		this.campaignService.delete(campaign);
	}

	public List<CampaignResponseDTO> getValidCampaignsByTeam(String codigoTime) {
		return campaignService.getAllValidCampaignsByTeam(codigoTime).stream().map(CampaignResponseDTO::new)
				.collect(Collectors.toList());
	}

	public List<CampaignResponseDTO> getAllValidCompaigns() {
		return campaignService.getAllValidCampaigns().stream().map(CampaignResponseDTO::new).collect(Collectors.toList());
	}
}