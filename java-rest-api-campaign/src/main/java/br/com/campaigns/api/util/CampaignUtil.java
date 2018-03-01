package br.com.campaigns.api.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.campaigns.api.model.Campaign;

public class CampaignUtil {
	
	public static Boolean isCampaignValid(Campaign campaign) {
		Boolean result = Boolean.FALSE;
		LocalDate now = LocalDate.now();
		if (campaign.getStartDate().isBefore(LocalDate.now())&& campaign.getDueDate().isAfter(now)) {
			result = Boolean.TRUE;
		}
		
		return result;
	}
	
	public static List<Campaign> adjustDueDate(List<Campaign> campaignList, Campaign campaign) {
		List<Campaign> list = campaignList;
		List<String> datesList = new ArrayList<String>();
		List<Campaign> updatedList = new ArrayList<Campaign>();
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String campaignDate = campaign.getDueDate().format(formatters);
		if (!list.isEmpty()) {
			list.forEach(Campaign -> {
				datesList.add(Campaign.getDueDate().format(formatters));
			});
			for (Campaign c : list) {
				datesList.remove((c.getDueDate().format(formatters)));
				LocalDate data = c.getDueDate();
				data = data.plusDays(1);
				c.setDueDate(data);

				datesList.add(c.getDueDate().format(formatters));
				updatedList.add(c);
			}
			if (datesList.contains(campaignDate)) {
				adjustDueDate(updatedList, campaign);
			}
		}
		return list;
	}

}
