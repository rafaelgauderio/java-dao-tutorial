package application;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ProgramDepartment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = new Department(30,"Miscellany");
		System.out.println(department);
		System.out.println();
		
		System.out.println("===TEST one: department findByid===");
		department = departmentDao.findById(30);
		System.out.println(department);
		
		System.out.println("\n===TEST two: department findAll===");
		List<Department> list = departmentDao.findAll();
		for (Department nickname : list) {
			System.out.println(nickname);
		}
		
		System.out.println("\n===TEST four: Department INSERT");
		Department newDepartment = new Department(null,"data processing center");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId() + ", Name of the new department: "+ newDepartment.getName());
						
		/*		
				System.out.println("\n===TEST five: selle UPDATE===");
		Seller sellerupd = sellerDao.findById(41);
		sellerupd.setName("Karla Kingston");
		sellerupd.setEmail("karla@gmail.com");
		sellerDao.update(sellerupd);
		System.out.println("Update complete");
		Seller sellerFind2 = sellerDao.findById(41);
		System.out.println(sellerFind2);
		
		System.out.println("\n===TEST six: selle DeletebyId===");
		System.out.println("Inform a id to delete data");
		int idDel = sc.nextInt();
		sellerDao.deleteById(idDel);
		System.out.println("Delete complete");	
		
		*/	
			
		sc.close();
		
		
		

	}

}
