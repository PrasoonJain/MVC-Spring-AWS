package com.maven.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maven.models.Employee;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

//@Service("employeeService")
//@Transactional
@Repository
public class EmployeeService implements IEmployeeService {

	@Autowired
	private MongoTemplate mongoTemplate;
	public static final String COLLECTION_NAME = "employees";

	@Override
	public List<Employee> getAll() {
		return mongoTemplate.findAll(Employee.class, COLLECTION_NAME);
	}

	@Override
	public Employee get(Double id) {
		return mongoTemplate.findById(id, Employee.class, COLLECTION_NAME);
	}

	@Override
	public void add(Employee employee) {
		mongoTemplate.insert(employee, COLLECTION_NAME);
	}

	@Override
	public void update(Employee employee) {
		mongoTemplate.save(employee, COLLECTION_NAME);
	}

	@Override
	public void delete(Double id) {
		mongoTemplate.remove(mongoTemplate.findById(id, Employee.class, COLLECTION_NAME), COLLECTION_NAME);
	}

	// public List<Employee> getAll() {
	// // ArrayList<Employee> employee_list = new ArrayList<Employee>();
	// // try {
	// // MongoClient mongo = new MongoClient("localhost", 27017);
	// // MongoDatabase db = mongo.getDatabase("emsdb");
	// // MongoCollection<Document> employeeCollection =
	// db.getCollection("employees");
	// // FindIterable<Document> iterDocs = employeeCollection.find();
	// // Iterator<Document> iterator = iterDocs.iterator();
	// //
	// // while (iterator.hasNext()) {
	// // System.out.println(iterator);
	// // Document doc = iterator.next();
	// // Employee employee = new Employee(doc.getString("name"),
	// // doc.getString("lastName"),
	// // doc.getString("birthDate"), doc.getString("role"),
	// // doc.getString("department"),
	// // doc.getString("email"));
	// // employee.setId(doc.getDouble("_id"));
	// // System.out.println("Id coming from doc - should be similar to db : " +
	// // employee.getId());
	// // employee_list.add(employee);
	// // }
	// // // mongo.close();
	// // return employee_list;
	// // } catch (Exception e) {
	// // System.out.println("Error occured in connectng to db : " +
	// e.getMessage());
	// // return null;
	// // }
	// return mongoTemplate.findAll(Employee.class, COLLECTION_NAME);
	// }
	//
	// public Employee get(Double id) {
	// try {
	// MongoClient mongo = new MongoClient("localhost", 27017);
	// MongoDatabase db = mongo.getDatabase("emsdb");
	// MongoCollection<Document> employeeCollection = db.getCollection("employees");
	// FindIterable<Document> iterDocs = employeeCollection.find(Filters.eq("_id",
	// id));
	// Iterator<Document> iterator = iterDocs.iterator();
	//
	// while (iterator.hasNext()) {
	// System.out.println(iterator);
	// Document doc = iterator.next();
	//
	// Employee employee = new Employee(doc.getString("name"),
	// doc.getString("lastName"),
	// doc.getString("birthDate"), doc.getString("role"),
	// doc.getString("department"),
	// doc.getString("email"));
	// employee.setId(id);
	// System.out.println("Id in getEmployee method = " + id);
	// // mongo.close();
	// return employee;
	// }
	// // mongo.close();
	// System.out.println("No such employee exists");
	// return null;
	// } catch (Exception e) {
	// System.out.println("Error occured in connectng to db : " + e.getMessage());
	// return null;
	// }
	//
	// }
	//
	// public boolean add(Employee employee) {
	// boolean output = false;
	// System.out.println("Adding a new user to the mongo database; Entered
	// user_name is= " + employee.getName());
	// try {
	// MongoClient mongo = new MongoClient("localhost", 27017);
	// MongoDatabase db = mongo.getDatabase("emsdb");
	// MongoCollection<Document> employeeCollection = db.getCollection("employees");
	// System.out.println("Collection fetched: " + employeeCollection);
	//
	// Document doc = new Document("_id", employee.getId());
	// doc.append("name", employee.getName());
	// doc.append("lastName", employee.getLastName());
	// doc.append("birthDate", employee.getBirthDate());
	// doc.append("role", employee.getRole());
	// doc.append("department", employee.getDepartment());
	// doc.append("email", employee.getEmail());
	//
	// // Save a new user to the mongo collection.
	// employeeCollection.insertOne(doc);
	// output = true;
	// // mongo.close();
	// } catch (Exception e) {
	// output = false;
	// System.out.println("An error occurred while saving a new user to the mongo
	// database" + e.getMessage());
	// }
	// return output;
	// }
	//
	// public boolean update(Employee employee) {
	// boolean output = false;
	// System.out.println("Updating user to the mongo database; Entered user_name
	// is= " + employee.getName());
	// try {
	// MongoClient mongo = new MongoClient("localhost", 27017);
	// MongoDatabase db = mongo.getDatabase("emsdb");
	// MongoCollection<Document> employeeCollection = db.getCollection("employees");
	// System.out.println("Collection fetched: " + employeeCollection);
	//
	// Document doc = new Document("_id", employee.getId());
	// doc.append("name", employee.getName());
	// doc.append("lastName", employee.getLastName());
	// doc.append("birthDate", employee.getBirthDate());
	// doc.append("role", employee.getRole());
	// doc.append("department", employee.getDepartment());
	// doc.append("email", employee.getEmail());
	//
	// System.out.println("Id coming to update method = " + employee.getId());
	// System.out.println(
	// employeeCollection.updateOne(Filters.eq("_id", employee.getId()), new
	// Document("$set", doc)));
	// output = true;
	// // mongo.close();
	// } catch (Exception e) {
	// output = false;
	// System.out.println("An error occurred while saving a new user to the mongo
	// database" + e.getMessage());
	// }
	//
	// return output;
	// }
	//
	// public boolean delete(Double id) {
	// boolean output = false;
	// System.out.println("Updating user to the mongo database; Entered id is= " +
	// id);
	// try {
	// MongoClient mongo = new MongoClient("localhost", 27017);
	// MongoDatabase db = mongo.getDatabase("emsdb");
	// MongoCollection<Document> employeeCollection = db.getCollection("employees");
	// System.out.println("Collection fetched: " + employeeCollection);
	//
	// System.out.println(employeeCollection.deleteOne(Filters.eq("_id", id)));
	// output = true;
	// // mongo.close();
	// } catch (Exception e) {
	// output = false;
	// System.out.println("An error occurred while deleting an employee to the mongo
	// database" + e.getMessage());
	// }
	//
	// return output;
	// }

}
