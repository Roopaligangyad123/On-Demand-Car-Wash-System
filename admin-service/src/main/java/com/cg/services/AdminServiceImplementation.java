package com.cg.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.WashpackNotFoundException;
import com.cg.models.Admin;
import com.cg.models.UserRating;
import com.cg.models.Washpack;
import com.cg.repository.AdminRepo;
import com.cg.repository.RatingRepo;
import com.cg.repository.WashRepo;


@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepo adminrepo;
	@Autowired
	private RatingRepo ratingrepo;
	@Autowired
	private WashRepo washrepo;

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		List<Admin> admin=adminrepo.findAll();
		return admin;
	}

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminrepo.save(admin);

	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Optional<Admin> optionalAdmin = adminrepo.findById(admin.getId());

		if (optionalAdmin == null) {
			throw new AdminNotFoundException("Admin not exising with id: " + admin.getId());
		}
		adminrepo.save(admin);
		
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		
		Optional<Admin> optionalAdmin = adminrepo.findById(id);

		if (optionalAdmin == null) {
			throw new AdminNotFoundException("Admin not exising with id: " + id);
		}

		Admin student = optionalAdmin.get();

		adminrepo.delete(student);

	}


	@Override
	public List<Washpack> getWashpack() {
		// TODO Auto-generated method stub
		List<Washpack> washpack=washrepo.findAll();
		return washpack;
	}

	@Override
	public void saveWashpack(Washpack washpacks) 
	{
		washrepo.save(washpacks);

	}

	@Override
	public void updateWashpack(Washpack updatepack) {
		Optional<Washpack> optionalWashpack = washrepo.findById(updatepack.getId());

		if (optionalWashpack == null) {
			throw new WashpackNotFoundException("Washpack not exising with id: " + updatepack.getId());
		}

		 washrepo.save(updatepack);
	}

	@Override
	public void deleteWashpack(int id) {
		// TODO Auto-generated method stub
		Optional<Washpack> optionalWashpack = washrepo.findById(id);

		if (optionalWashpack == null) {
			throw new WashpackNotFoundException("Washpack not exising with id: " + id);
		}

		Washpack wash = optionalWashpack.get();

		washrepo.delete(wash);

	}

	@Override
	public List<UserRating> getUser() {
		// TODO Auto-generated method stub
		List<UserRating> rating=ratingrepo.findAll();
		return rating;
	}

	

}
