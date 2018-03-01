package br.com.campaigns.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.campaigns.api.model.CampaignSupporter;

@Repository
public interface CampaignSupporterRepository extends MongoRepository<CampaignSupporter, String >{
	List<CampaignSupporter> findByCampaingID(String  campaingID);
	List<CampaignSupporter> findByEmail(String email);
	CampaignSupporter findByCampaingIDAndEmail(String  campaingID, String email);
}
