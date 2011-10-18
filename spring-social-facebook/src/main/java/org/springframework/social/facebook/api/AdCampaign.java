package org.springframework.social.facebook.api;

/**
 * @author Eric Mayhew
 *
 * http://developers.facebook.com/docs/reference/ads-api/adcampaign/
 *
 */
public class AdCampaign {
	private final long id;
	private final long accountId;
	private final String name;
	private final int startTime;
	private final int endTime;
	private final int dailyBudget;
	private final int lifetimeBudget;
		
	public AdCampaign(long id, long accountId, String name, int startTime,
			int endTime, int dailyBudget, int lifetimeBudget) {
		this.id = id;
		this.accountId = accountId;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dailyBudget = dailyBudget;
		this.lifetimeBudget = lifetimeBudget;
	}

	public long getId() {
		return id;
	}
	public long getAccountId() {
		return accountId;
	}
	public String getName() {
		return name;
	}
	public int getStartTime() {
		return startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public int getDailyBudget() {
		return dailyBudget;
	}
	public int getLifetimeBudget() {
		return lifetimeBudget;
	}
	
}
