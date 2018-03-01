package br.com.campaigns.api.component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.campaigns.api.dto.CampaignSupporterRequestDTO;
import br.com.campaigns.api.dto.CampaignSupporterResponseDTO;
import br.com.campaigns.api.exceptions.InvalidAssociationException;
import br.com.campaigns.api.exceptions.InvalidCampaignException;
import br.com.campaigns.api.exceptions.InvalidSupporterException;
import br.com.campaigns.api.model.CampaignSupporter;
import br.com.campaigns.api.repository.CampaignRepository;
import br.com.campaigns.api.repository.CampaignSupporterRepository;
import br.com.campaigns.api.service.CampainSupporterService;

@Component
public class CampaignSupporterAssociationComponent {
	@Autowired
	private CampainSupporterService campainSupporterService;

	@Autowired
	private CampaignSupporterRepository campaignSupporterRepository;

	@Autowired
	private CampaignRepository campaignRepository;

	public CampaignSupporterResponseDTO save(CampaignSupporterRequestDTO campaignSupporterRequest)
			throws InvalidCampaignException, InvalidSupporterException, InvalidAssociationException {
		
		Optional.ofNullable(campaignRepository.findOne(campaignSupporterRequest.getCampaingID()))
				.orElseThrow(() -> new InvalidCampaignException());
		
		if (campaignSupporterRepository.findByCampaingIDAndEmail(campaignSupporterRequest.getCampaingID(),
				campaignSupporterRequest.getEmail()) != null) {
			throw new InvalidSupporterException();
		}
		
		return new CampaignSupporterResponseDTO(
				campainSupporterService.save(campaignSupporterRequest.toCampaignSupporter()));
	}

	public List<CampaignSupporterResponseDTO> getAllCampaigns() {
		return campainSupporterService.getAllCampaigns().stream().map(CampaignSupporterResponseDTO::new)
				.collect(Collectors.toList());
	}

	public CampaignSupporterResponseDTO getCammpaing(String id) throws InvalidCampaignException {
		return Optional.ofNullable(campainSupporterService.getCampaignByID(id)).map(CampaignSupporterResponseDTO::new)
				.orElseThrow(() -> new InvalidCampaignException());
	}

	public void delete(String id) throws InvalidAssociationException, InvalidSupporterException {
		CampaignSupporter campaignSupporter = Optional.ofNullable(campainSupporterService.getCampaignByID(id))
				.orElseThrow(() -> new InvalidSupporterException());
		this.campainSupporterService.delete(campaignSupporter);
	}

	public List<CampaignSupporterResponseDTO> getCampaingByEmail(String email) throws InvalidCampaignException {
		List<CampaignSupporterResponseDTO> list = campainSupporterService.getByEmail(email).stream()
				.map(CampaignSupporterResponseDTO::new).collect(Collectors.toList());
		if (list.isEmpty())
			throw new InvalidCampaignException();
		return list;
	}

	public List<CampaignSupporterResponseDTO> getCampaingByID(String campaignID) throws InvalidCampaignException {
		List<CampaignSupporterResponseDTO> list = campainSupporterService.getByCampaingID(campaignID).stream()
				.map(CampaignSupporterResponseDTO::new).collect(Collectors.toList());
		if (list.isEmpty())
			throw new InvalidCampaignException();
		return list;
	}

}