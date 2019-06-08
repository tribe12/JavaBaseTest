package cn.wgh.json.pojo;

/**
 * 奖惩信息
 */
public class RewardsPenalties {
	// 奖励单位
	private String rewardCompany;
	// 所获荣誉
	private String reward;
	// 奖励级别
	private String rewardLevel;
	// 获奖时间
	private String rewardDate;
	// 惩处级别
	private String penaltyLevel;
	// 惩处单位
	private String penaltyCompany;
	// 惩处时间
	private String penaltyDate;

	public String getRewardCompany() {
		return rewardCompany;
	}

	public void setRewardCompany(String rewardCompany) {
		this.rewardCompany = rewardCompany;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getRewardLevel() {
		return rewardLevel;
	}

	public void setRewardLevel(String rewardLevel) {
		this.rewardLevel = rewardLevel;
	}

	public String getRewardDate() {
		return rewardDate;
	}

	public void setRewardDate(String rewardDate) {
		this.rewardDate = rewardDate;
	}

	public String getPenaltyLevel() {
		return penaltyLevel;
	}

	public void setPenaltyLevel(String penaltyLevel) {
		this.penaltyLevel = penaltyLevel;
	}

	public String getPenaltyCompany() {
		return penaltyCompany;
	}

	public void setPenaltyCompany(String penaltyCompany) {
		this.penaltyCompany = penaltyCompany;
	}

	public String getPenaltyDate() {
		return penaltyDate;
	}

	public void setPenaltyDate(String penaltyDate) {
		this.penaltyDate = penaltyDate;
	}

	@Override
	public String toString() {
		return "RewardsPenalties [rewardCompany=" + rewardCompany + ", reward=" + reward + ", rewardLevel="
				+ rewardLevel + ", rewardDate=" + rewardDate + ", penaltyLevel=" + penaltyLevel + ", penaltyCompany="
				+ penaltyCompany + ", penaltyDate=" + penaltyDate + "]";
	}
	
}
