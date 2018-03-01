package br.com.campaigns.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.campaigns.api.model.Campaign;

@Repository
public interface CampaignRepository extends MongoRepository<Campaign, String>{
	List<Campaign> findByFavoriteTeamID(String favoriteTeamID);
}
