package br.com.campaigns.api.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import br.com.campaigns.api.model.Campaign;
import lombok.Getter;
import lombok.Setter;

public class CampaignRequestDTO {
	@Getter @Setter
	@NotNull(message = "O parâmetro nome da campanha deve ser preenchido")
	private String name;
	
	@Getter @Setter
	@NotNull(message = "O parâmetro código do time da campanha deve ser preenchido")
	private String  favoriteTeamID;
	
	@Getter @Setter
	@NotNull(message = "O parâmetro data de início da campanha deve ser preenchido")
	private LocalDate startDate;
	
	@Getter @Setter
	@NotNull(message = "A data de fim da campanha deve ser preenchida")
	private LocalDate dueDate;

	public Campaign toCampaign() {
		Campaign campaign = new Campaign();
		campaign.setName(name);
		campaign.setFavoriteTeamID(favoriteTeamID);
		campaign.setStartDate(startDate);
		campaign.setDueDate(dueDate);
		return campaign;
	}
}