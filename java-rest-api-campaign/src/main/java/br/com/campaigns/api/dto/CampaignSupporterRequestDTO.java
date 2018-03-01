package br.com.campaigns.api.dto;

import javax.validation.constraints.NotNull;

import br.com.campaigns.api.model.CampaignSupporter;
import lombok.Getter;
import lombok.Setter;

public class CampaignSupporterRequestDTO {
	@Getter @Setter
	@NotNull(message = "O parâmetro de email deve ser preenchido")
	private String email;
	
	@Getter @Setter
	@NotNull(message = "O parâmetro nome do time deve ser preenchido")
	private String teamName;
	
	@Getter @Setter
	@NotNull(message = "O parâmetro código da campanha deve ser preenchido")
	private String campaingID;
	

	public CampaignSupporter toCampaignSupporter(){
		CampaignSupporter campaignSupporter = new CampaignSupporter();
		campaignSupporter.setEmail(email);
		campaignSupporter.setFavoriteTeamName(teamName);
		campaignSupporter.setCampaingID(campaingID);
		return campaignSupporter;
	}
}