package com.nt.entity;

public class InsurancePolicy {
			private int InsuranceId;
			private String InsuranceName;
			private int tenure;
			private long initialAmount;
			//private int updateCount;

			
			public InsurancePolicy() {
			System.out.println("constructor-0 prm");
			}
			public int getInsuranceId() {
				return InsuranceId;
			}
			public void setInsuranceId(int insuranceId) {
				InsuranceId = insuranceId;
			}
			public String getInsuranceName() {
				return InsuranceName;
			}
			public void setInsuranceName(String insuranceName) {
				InsuranceName = insuranceName;
			}
			public int getTenure() {
				return tenure;
			}
			public void setTenure(int tenure) {
				this.tenure = tenure;
			}
			public long getInitialAmount() {
				return initialAmount;
			}
			public void setInitialAmount(long initialAmount) {
				this.initialAmount = initialAmount;
			}
			
	/*	public int getUpdateCount() {
			return updateCount;
		}
		public void setUpdateCount(int updateCount) {
			this.updateCount = updateCount;
		}*/
			
			@Override
			public String toString() {
				return "InsurancePolicy [InsuranceId=" + InsuranceId + ", InsuranceName=" + InsuranceName + ", tenure="
				+ tenure + ", initialAmount=" + initialAmount + /*",updateCount="+updateCount+*/"]";
			}
			
			
}
