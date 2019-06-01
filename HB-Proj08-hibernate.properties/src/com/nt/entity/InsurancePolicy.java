package com.nt.entity;

public class InsurancePolicy {
			private int InsuranceId;
			private String InsuranceName;
			private int tenure;
			private long initialAmount;
			
			
			
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
			@Override
			public String toString() {
				return "InsurancePolicy [InsuranceId=" + InsuranceId + ", InsuranceName=" + InsuranceName + ", tenure="
						+ tenure + ", initialAmount=" + initialAmount + "]";
			}
			
			
			
			
}
