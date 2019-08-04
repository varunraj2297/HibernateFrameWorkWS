package com.nt.service;



import com.nt.dao.ProjectDAO;
import com.nt.dao.ProjectDAOImpl;
import com.nt.dto.ProjectDTO;
import com.nt.entity.Project;


public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO projdao;
	
	
	public ProjectServiceImpl() {
		System.out.println("ProjectServiceImpl - 0 -param con");
		projdao=new ProjectDAOImpl();
	}


	@Override
	public ProjectDTO searchProject(int pid) {
		ProjectDTO projdto=null;
		Project proj=null;
		proj=projdao.findProject(pid);
	
		try {
			if(proj!=null) {
				System.out.println("entering into if.....");
			projdto=new ProjectDTO();
			projdto.setProjid(proj.getProjid());
			projdto.setProjname(proj.getProjname());
			projdto.setDomain(proj.getDomain());
			projdto.setTeamsize(proj.getTeamsize());
			projdto.setProjstartdate(proj.getProjstartdate());
			projdto.setProjenddate(proj.getProjenddate());
			}
			//BeanUtils.copyProperties(projdto, proj);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return projdto;
		
	}

}
