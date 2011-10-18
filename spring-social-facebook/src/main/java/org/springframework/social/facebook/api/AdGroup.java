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

		private final long adId;
		private final long id;
		private final long accountId;
		private final long campaignId;
		private final String name;
		private final int adStatus;
		private final int adGroupStatus;
		private final int bidType;
		private final String maxBid; //?? String?
		private final AdTargeting targeting;
		private final List<Long> creativeIds;
		private final long adGroupId;
		private final Date startTime;
		private final Date endTime;
		private final Date updatedTime;
		private final Map<String, String> bidInfo;
		private final List<String> disapproveReasonDescriptions;
		
//		public AdGroup() {
//			super();
//		}

		public AdGroup(long adId, long id, long accountId, long campaignId, String name,
				int adStatus, int adGroupStatus, int bidType, String maxBid,
				AdTargeting targeting, List<Long> creativeIds,
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

		public long getId() {
            return id;
        }

        public long getAccountId() {
            return accountId;
        }

        public long getCampaignId() {
			return campaignId;
		}

		public String getName() {
			return name;
		}

		public int getAdStatus() {
            return adStatus;
        }

        public int getAdGroupStatus() {
			return adGroupStatus;
		}

		public int getBidType() {
			return bidType;
		}

		public String getMaxBid() {
			return maxBid;
		}

		public AdTargeting getTargeting() {
			return targeting;
		}

		public List<Long> getCreativeIds() {
			return creativeIds;
		}

		public long getAdGroupId() {
			return adGroupId;
		}

		public Date getStartTime() {
			return startTime;
		}

		public Date getEndTime() {
            return endTime;
        }

        public Date getUpdatedTime() {
			return updatedTime;
		}

		public Map<String, String> getBidInfo() {
			return bidInfo;
		}

		public List<String> getDisapproveReasonDescriptions() {
			return disapproveReasonDescriptions;
		}

}
