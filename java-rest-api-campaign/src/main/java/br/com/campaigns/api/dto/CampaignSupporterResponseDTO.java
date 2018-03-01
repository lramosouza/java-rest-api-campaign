package br.com.campaigns.api.dto;

import br.com.campaigns.api.model.CampaignSupporter;
import lombok.Getter;
import lombok.Setter;

public class CampaignSupporterResponseDTO {
	
	@Getter @Setter
	private String  affiliationCode;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String teamName;
	@Getter @Setter
	private String campaingID;
	
	public CampaignSupporterResponseDTO(CampaignSupporter campaignSupporter){
		affiliationCode = campaignSupporter.getId();
		email = campaignSupporter.getEmail();
		teamName = campaignSupporter.getFavoriteTeamName();
		campaingID = campaignSupporter.getCampaingID();
	}
	
}