package application;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		Department object = new Department(1, "Computers");
		System.out.println(object);
		System.out.println();

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = new Seller(15, "Rafael", "rafael@gmail.com", new Date(), 4500.00, object);
		System.out.println(seller);
		System.out.println();

		System.out.println("===TEST one: seller findById===");
		Seller sellerFind = sellerDao.findById(3);
		System.out.println(sellerFind);

		System.out.println("\n===TEST two: seller findByDepartment===");
		Department department = new Department(4, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller nickname : list) {
			System.out.println(nickname);
		}

		System.out.println("\n===TEST three: seller findAll ====");
		list = sellerDao.findAll();
		for (Seller nickname : list) {
			System.out.println(nickname);
		}

		System.out.println("\n===TEST four: seller INSERT ====");
		Seller newSeller = new Seller(null, "Zilda Safadex", "zilda@gmail", new Date(), 4500.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId() + ", Name of new Seller: " + newSeller.getName());

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
		sc.close();
		

	}

}
