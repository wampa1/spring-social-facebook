package org.springframework.social.facebook.api;

/**
 * @author Eric Mayhew
 *
 * http://developers.facebook.com/docs/reference/ads-api/adcampaign/
 *
 */
public class AdCampaign {
	private long id;
	private long accountId;
	private String name;
	private int startTime;
	private int endTime;
	private int dailyBudget;
	private int lifetimeBudget;
		
	public AdCampaign() {
		super();
	}
	
	public AdCampaign(long id, long accountId, String name, int startTime,
			int endTime, int dailyBudget, int lifetimeBudget) {
		super();
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
	public void setId(long id) {
		this.id = id;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getDailyBudget() {
		return dailyBudget;
	}
	public void setDailyBudget(int dailyBudget) {
		this.dailyBudget = dailyBudget;
	}
	public int getLifetimeBudget() {
		return lifetimeBudget;
	}
	public void setLifetimeBudget(int lifetimeBudget) {
		this.lifetimeBudget = lifetimeBudget;
	}
	
	
	
	
}
