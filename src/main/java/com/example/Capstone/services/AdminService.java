package com.example.Capstone.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Capstone.entities.Admin;
import com.example.Capstone.repositories.AdminRepository;


@Service
public class AdminService {
	private static Logger logger = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private AdminRepository adminRepository;
	
	public Admin findAdminById(int id) {
		return adminRepository.findAdminById(id);
	}

	public boolean validateAdmin(Admin admin) {
		logger.info("admin: "+ admin.toString());
		return adminRepository.findById(admin.getId()) != null;
	}

	public Admin findByUsername(String username){
		return adminRepository.findByUsername(username);
	}
	
	public void updateAdmin(Admin admin) {
		adminRepository.save(admin);
	}


}
