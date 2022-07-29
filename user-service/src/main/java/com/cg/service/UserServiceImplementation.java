package com.cg.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;



import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.cg.exception.UserNotFoundException;

import com.cg.models.DatabaseSequence;
import com.cg.models.Payment;
import com.cg.models.Signup;
import com.cg.repository.UserRepo;
@Service
public class UserServiceImplementation implements UserService{

	
	@Autowired
	private UserRepo repo;
	
	
	
	@Override
	public Signup addUser(Signup signup)
	{
		Signup addUser=repo.save(signup);
		return addUser;
	
	}

	@Override
	public List<Signup> getuser() {
		List<Signup> users=repo.findAll();
		return users;
	}

	@Override
	public Signup Updateuser(Signup update) {
		    
		    Optional<Signup> optionalUser = repo.findById(update.getId());

	        if (optionalUser == null) {
	            throw new UserNotFoundException("User not exising with id: " + update.getId());
	        }

	        Signup updateUser = repo.save(update);

	        return updateUser;
	    }

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		Optional<Signup> optionalUser = repo.findById(id);

		if (optionalUser == null) {
			throw new UserNotFoundException("User not exising with id: " + id);
		}

		Signup deleteUser = optionalUser.get();

		repo.delete(deleteUser);

	}
	
	  @Autowired
	  private MongoOperations mongoOperations;



	  public int getSequenceNumber(String sequenceName) {
	  //get sequence no
	  Query query = new Query(Criteria.where("id").is(sequenceName));
	  //update the sequence no
	  Update update = new Update().inc("seq", 1);
	  //modify in document
	  DatabaseSequence counter = mongoOperations.findAndModify(query,
	  update, options().returnNew(true).upsert(true),
	  DatabaseSequence.class);



	  return (int) (!Objects.isNull(counter) ? counter.getSeq() : 1);



	  }

	@Override
	public void deleteUser(Signup user) {
		// TODO Auto-generated method stub
		repo.delete(user);
		
	
}
}