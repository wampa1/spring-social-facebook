package org.springframework.social.facebook.api;

import java.util.List;

/**
 * @author ddcericm
 *
 * http://developers.facebook.com/docs/reference/ads-api/adgroup/
 *
 */

//ToDo: Will, can you look at the adgroup definition and help me figure out how the complex Array types for Targeting (and bid_info) work?


public class AdGroup {

		private long adId;
		private long campaignId;
		private String name;
		private int adGroupStatus;
		private int bidType;
		private String maxBid; //?? String?
		private List<AdTargets> targeting;
		private List<AdCreative> creative;
		private long adGroupId;
		private int startTime;
		private int updatedTime;
		private List<AdBidInfo> bidInfo;
		private List<String> disapproveReasonDescriptions;
		
		
		
		public AdGroup() {
			super();
		}

		public AdGroup(long adId, long campaignId, String name,
				int adGroupStatus, int bidType, String maxBid,
				List<AdTargets> targeting, List<AdCreative> creative,
				long adGroupId, int startTime, int updatedTime,
				List<AdBidInfo> bidInfo,
				List<String> disapproveReasonDescriptions) {
			super();
			this.adId = adId;
			this.campaignId = campaignId;
			this.name = name;
			this.adGroupStatus = adGroupStatus;
			this.bidType = bidType;
			this.maxBid = maxBid;
			this.targeting = targeting;
			this.creative = creative;
			this.adGroupId = adGroupId;
			this.startTime = startTime;
			this.updatedTime = updatedTime;
			this.bidInfo = bidInfo;
			this.disapproveReasonDescriptions = disapproveReasonDescriptions;
		}

		public long getAdId() {
			return adId;
		}

		public void setAdId(long adId) {
			this.adId = adId;
		}

		public long getCampaignId() {
			return campaignId;
		}

		public void setCampaignId(long campaignId) {
			this.campaignId = campaignId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAdGroupStatus() {
			return adGroupStatus;
		}

		public void setAdGroupStatus(int adGroupStatus) {
			this.adGroupStatus = adGroupStatus;
		}

		public int getBidType() {
			return bidType;
		}

		public void setBidType(int bidType) {
			this.bidType = bidType;
		}

		public String getMaxBid() {
			return maxBid;
		}

		public void setMaxBid(String maxBid) {
			this.maxBid = maxBid;
		}

		public List<AdTargets> getTargeting() {
			return targeting;
		}

		public void setTargeting(List<AdTargets> targeting) {
			this.targeting = targeting;
		}

		public List<AdCreative> getCreative() {
			return creative;
		}

		public void setCreative(List<AdCreative> creative) {
			this.creative = creative;
		}

		public long getAdGroupId() {
			return adGroupId;
		}

		public void setAdGroupId(long adGroupId) {
			this.adGroupId = adGroupId;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getUpdatedTime() {
			return updatedTime;
		}

		public void setUpdatedTime(int updatedTime) {
			this.updatedTime = updatedTime;
		}

		public List<AdBidInfo> getBidInfo() {
			return bidInfo;
		}

		public void setBidInfo(List<AdBidInfo> bidInfo) {
			this.bidInfo = bidInfo;
		}

		public List<String> getDisapproveReasonDescriptions() {
			return disapproveReasonDescriptions;
		}

		public void setDisapproveReasonDescriptions(
				List<String> disapproveReasonDescriptions) {
			this.disapproveReasonDescriptions = disapproveReasonDescriptions;
		}
		
		
		
		
		
}
