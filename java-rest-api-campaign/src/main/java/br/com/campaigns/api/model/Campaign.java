package br.com.campaigns.api.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
public class Campaign {

	@Id
	@Getter @Setter
	private String id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private String favoriteTeamID;
	@Getter @Setter
	private LocalDate startDate;
	@Getter @Setter
	private LocalDate dueDate;

}