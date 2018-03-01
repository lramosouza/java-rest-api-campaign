package br.com.campaigns.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.campaigns.api.model.Campaign;
import br.com.campaigns.api.repository.CampaignRepository;
import br.com.campaigns.api.util.CampaignUtil;

@Service
@Validated
public class CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;

	public Campaign save(final Campaign campaign) {
		List<Campaign> campaignsList = getAllCampaigns();
		List<Campaign> list = CampaignUtil.adjustDueDate(campaignsList, campaign);
		list.add(campaign);
		list.forEach(Campaign -> this.campaignRepository.save(Campaign));
	
		return campaign;
	}

	public void delete(final Campaign campanha) {
		this.campaignRepository.delete(campanha);
	}

	public Campaign getCampaignByID(final String  id) {
		return this.campaignRepository.findOne(id);
	}

	public List<Campaign> getAllCampaigns() {
		return this.campaignRepository.findAll();
	}

	public List<Campaign> getAllValidCampaigns() {
		List<Campaign> totalList = this.campaignRepository.findAll();
		List<Campaign> validCampaignsList = new ArrayList<Campaign>();
		
		totalList.forEach(Campaign -> {
			if (CampaignUtil.isCampaignValid(Campaign)) {
				validCampaignsList.add(Campaign);
				} 
		});

		return validCampaignsList;
	}

	public List<Campaign> getAllValidCampaignsByTeam(String  favoriteTeamID) {
		return this.campaignRepository.findByFavoriteTeamID(favoriteTeamID).stream()
				.filter(CampaignUtil::isCampaignValid).collect(Collectors.toList());
	}

}