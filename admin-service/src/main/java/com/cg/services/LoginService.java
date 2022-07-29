package com.cg.services;



import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.models.Admin;
import com.cg.repository.AdminRepo;


@Service
public class LoginService {
	@Autowired
	private AdminRepo adminrepo;

	public String adminLogin(Admin login) {
		ArrayList<Admin> list = (ArrayList<Admin>) adminrepo.findAll();
		int count = 0;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getName().equals(login.getName())
					&& list.get(i).getPassword().equals(login.getPassword())) {

				count++;
			}
		}

		if (count == 1) {
			return "logged in";
		} else {
			return "wrong credentials";
		}

	}

}
