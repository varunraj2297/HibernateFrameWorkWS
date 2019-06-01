package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

public class ProjectDTO implements Serializable {
	private int projid;
	private String projname;
	private int teamsize;
	private String domain;
	private Date projstartdate;
	private Date projenddate;
	
	public ProjectDTO() {
		System.out.println("ProjectDTO-0-param con");
	}

	public int getProjid() {
		return projid;
	}

	public void setProjid(int projid) {
		this.projid = projid;
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public int getTeamsize() {
		return teamsize;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Date getProjstartdate() {
		return projstartdate;
	}

	public void setProjstartdate(Date projstartdate) {
		this.projstartdate = projstartdate;
	}

	public Date getProjenddate() {
		return projenddate;
	}

	public void setProjenddate(Date projenddate) {
		this.projenddate = projenddate;
	}

	@Override
	public String toString() {
		return "ProjectDTO [projid=" + projid + ", projname=" + projname + ", teamsize=" + teamsize + ", domain="
				+ domain + ", projstartdate=" + projstartdate + ", projenddate=" + projenddate + "]";
	}

}
