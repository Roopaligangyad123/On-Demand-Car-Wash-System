package com.cg.services;

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

import com.cg.exception.WasherNotFoundException;
import com.cg.models.DatabaseSequence;
import com.cg.models.Washers;
import com.cg.repository.WasherRepo;

@Service
public class WasherServiceImpl implements WasherService
{
	@Autowired
	private WasherRepo repo;



	@Override
	public void save(Washers washer) {
		// TODO Auto-generated method stub
		repo.save(washer);
		
	}

	@Override
    public void updateWasherDetails(Washers washer) {
        // TODO Auto-generated method stub 
        Optional<Washers> optionalWasher = repo.findById(washer.getId());

        if (optionalWasher == null) {
            throw new WasherNotFoundException("Washer not exising with id: " + washer.getId());
        }

         repo.save(washer);

    }

		@Override
	    public void deleteWasher(int id) { 
	        Optional<Washers> optionalWasher = repo.findById(id);

	        if (optionalWasher == null) {
	            throw new WasherNotFoundException("Washer not existing with id: " + id);
	        }
	        Washers washer = optionalWasher.get();
	        repo.delete(washer);
	    } 
		

	@Override
	public List<Washers> getWashers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	
	}
	@Autowired
    private  MongoOperations mongoOperations;

	 public long getSequenceNumber(String sequenceName) {
	        //get sequence no
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        //update the sequence no
	        Update update = new Update().inc("seq", 1);
	        //modify in document
	        DatabaseSequence counter = mongoOperations.findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DatabaseSequence.class);

	        return !Objects.isNull(counter) ? counter.getSeq() : 1;
	    

	 }


}

