package br.com.campaigns.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.campaigns.api.model.Campaign;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CampaignResponseDTO {
	
	@Getter @Setter
	private String  id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String  favoriteTeamID;
	@Getter @Setter
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class)  
	private LocalDate startDate;
	@Getter @Setter
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class)  
	private LocalDate dueDate;

	public CampaignResponseDTO(Campaign campaign) {
		id = campaign.getId();
		name = campaign.getName();
		favoriteTeamID = campaign.getFavoriteTeamID();
		startDate = campaign.getStartDate();
		dueDate = campaign.getDueDate();
	}	
}