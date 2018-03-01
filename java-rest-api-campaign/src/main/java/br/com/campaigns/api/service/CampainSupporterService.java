package br.com.campaigns.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.campaigns.api.model.CampaignSupporter;
import br.com.campaigns.api.repository.CampaignSupporterRepository;

@Service
@Validated
public class CampainSupporterService {
	
	@Autowired
	private CampaignSupporterRepository campaignSupporterRepository;
	
	public CampaignSupporter save(final CampaignSupporter campaignSupporter){
		return this.campaignSupporterRepository.save(campaignSupporter);
	}
	
	public void delete(final CampaignSupporter campaignSupporter) {
		this.campaignSupporterRepository.delete(campaignSupporter);
	}
	
	public CampaignSupporter getCampaignByID(final String  id) {
		return this.campaignSupporterRepository.findOne(id);
	}
	
	public List<CampaignSupporter> getAllCampaigns(){
		return this.campaignSupporterRepository.findAll();
	}
	
	public List<CampaignSupporter> getByCampaingID(String campaingID){
		return this.campaignSupporterRepository.findByCampaingID(campaingID);
	}
	
	public List<CampaignSupporter> getByEmail(String email){
		return this.campaignSupporterRepository.findByEmail(email);
	}
}