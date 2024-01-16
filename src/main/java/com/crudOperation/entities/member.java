package com.crudOperation.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class member {
		@Id
		private String email;
		private String password;
		
		public member() {}
		public member(String email, String password) {
			super();
			this.email = email;
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
	}
