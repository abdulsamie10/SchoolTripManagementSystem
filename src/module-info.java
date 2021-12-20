module SchoolTripManagementSystem {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.base;
	requires javafx.graphics;
	requires org.hibernate.orm.core;
	requires java.naming;
	requires java.persistence;
	requires junit;
	requires org.junit.jupiter.api;
	
	opens application to javafx.graphics, javafx.fxml;
}