package br.com.campaigns.api.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
public class CampaignSupporter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Getter @Setter
	private String id;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String favoriteTeamName;
	@Getter @Setter
	private String campaingID;


}