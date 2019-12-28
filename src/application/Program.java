package application;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);

		Department object = new Department(1, "Computers");
		System.out.println(object);
		System.out.println();
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = new Seller(15, "Rafael", "rafael@gmail.com", new Date(), 4500.00, object);
		System.out.println(seller);
		System.out.println();
		
		System.out.println("===TEST one: seller findById");
		Seller sellerFind = sellerDao.findById(3);
		System.out.println(sellerFind);
		
		System.out.println("------------------------");
		System.out.println("\n===TEST two: seller findByDepartment===");
		Department department = new Department(4, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller nickname : list) {
			System.out.println(nickname);
		}

		
		
		

	}

}
