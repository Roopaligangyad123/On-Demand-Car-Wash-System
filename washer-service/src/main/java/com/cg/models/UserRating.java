package com.cg.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ratingdb")
public class UserRating {
	
	     private String washername;
		 private int rating;
		 private String review;
		public UserRating() {
			super();
		}
		public UserRating(String washername, int rating, String review) {
			super();
			this.washername = washername;
			this.rating = rating;
			this.review = review;
		}
		public String getWashername() {
			return washername;
		}
		public void setWashername(String washername) {
			this.washername = washername;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public String getReview() {
			return review;
		}
		public void setReview(String review) {
			this.review = review;
		}
		@Override
		public String toString() {
			return "UserRating [washername=" + washername + ", rating=" + rating + ", review=" + review + "]";
		}
		 
		
}