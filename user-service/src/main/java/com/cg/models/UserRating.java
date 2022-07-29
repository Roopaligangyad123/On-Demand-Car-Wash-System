package com.cg.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratingdb")
public class UserRating {
	
	     @Id
	     @NotEmpty(message="Rating must not be empty")
	     private int rating;
	     @NotEmpty(message="Name must not be empty")
	     private String washerName;
		 private String review;
		public UserRating() {
			super();
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public String getWasherName() {
			return washerName;
		}
		public void setWasherName(String washerName) {
			this.washerName = washerName;
		}
		public String getReview() {
			return review;
		}
		public void setReview(String review) {
			this.review = review;
		}
		@Override
		public String toString() {
			return "UserRating [rating=" + rating + ", washerName=" + washerName + ", review=" + review + "]";
		}
		public UserRating(@NotEmpty(message = "Rating must not be empty") int rating,
				@NotEmpty(message = "Name must not be empty") String washerName, String review) {
			super();
			this.rating = rating;
			this.washerName = washerName;
			this.review = review;
		}
		
}