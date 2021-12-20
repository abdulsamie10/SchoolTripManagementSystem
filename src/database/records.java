//package com.pack.Employee;
package database;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;
import java.util.Random;

//		@Entity
//		@Table(name="records")
		public class records { 
		//	@Id
		//	@GeneratedValue(strategy=GenerationType.IDENTITY)
		//	@Column(name = "rec")
			private int id;
			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}
		//	@Column(name = "rec")
			private String rec;
			public String getRec() {
				return rec;
			}

			public void setRec(String rec) {
				this.rec = rec;
			}
//			@Override
//			public String toString() {
//				return "RECORDS:  "+ rec + "  /" + " ID: " + String.valueOf(id);
//			}
		
		}
		
		
		