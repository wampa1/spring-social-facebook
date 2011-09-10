package org.springframework.social.facebook.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ddcericm
 *
 * http://developers.facebook.com/docs/reference/ads-api/adgroup/
 *
 */

//ToDo: Will, can you look at the adgroup definition and help me figure out how the complex Array types for Targeting (and bid_info) work?


public class AdGroup {

		private long adId;
		private long id;
		private long accountId;
		private long campaignId;
		private String name;
		private int adStatus;
		private int adGroupStatus;
		private int bidType;
		private String maxBid; //?? String?
		private AdTargets targeting;
		private List<Long> creativeIds;
		private long adGroupId;
		private Date startTime;
		private Date endTime;
		private Date updatedTime;
		private Map<String, String> bidInfo;
		private List<String> disapproveReasonDescriptions;
		
//		public AdGroup() {
//			super();
//		}

		public AdGroup(long adId, long id, long accountId, long campaignId, String name,
				int adStatus, int adGroupStatus, int bidType, String maxBid,
				AdTargets targeting, List<Long> creativeIds,
				long adGroupId, Date startTime, Date endTime,
				Date updatedTime, Map<String, String> bidInfo,
				List<String> disapproveReasonDescriptions) {
			this.adId = adId;
			this.id = id;
			this.accountId = accountId;
			this.campaignId = campaignId;
			this.name = name;
			this.adStatus = adStatus;
			this.adGroupStatus = adGroupStatus;
			this.bidType = bidType;
			this.maxBid = maxBid;
			this.targeting = targeting;
			this.creativeIds = creativeIds;
			this.adGroupId = adGroupId;
			this.startTime = startTime;
			this.endTime = endTime;
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

		public int getAdStatus() {
            return adStatus;
        }

        public void setAdStatus(int adStatus) {
            this.adStatus = adStatus;
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
		
		public AdTargets getTargeting() {
			return targeting;
		}

		public void setTargeting(AdTargets targeting) {
			this.targeting = targeting;
		}

		public List<Long> getCreativeIds() {
			return creativeIds;
		}

		public void setCreativeIds(List<Long> creativeIds) {
			this.creativeIds = creativeIds;
		}

		public long getAdGroupId() {
			return adGroupId;
		}

		public void setAdGroupId(long adGroupId) {
			this.adGroupId = adGroupId;
		}

		public Date getStartTime() {
			return startTime;
		}

		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}

		public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public Date getUpdatedTime() {
			return updatedTime;
		}

		public void setUpdatedTime(Date updatedTime) {
			this.updatedTime = updatedTime;
		}

		public Map<String, String> getBidInfo() {
			return bidInfo;
		}

		public void setBidInfo(Map<String, String> bidInfo) {
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
