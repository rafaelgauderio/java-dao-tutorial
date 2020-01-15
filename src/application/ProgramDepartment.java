package application;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = new Department(30, "Miscellany");
		System.out.println(department);
		System.out.println();

		System.out.println("===TEST one: department findByid===");
		department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n===TEST two: department findAll===");
		List<Department> list = departmentDao.findAll();
		for (Department nickname : list) {
			System.out.println(nickname);
		}

		System.out.println("\n===TEST three: Department INSERT");
		Department newDepartment = new Department(null, "data processing center");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId() + ", Name of the new department: "
				+ newDepartment.getName());

		System.out.println("\n===TEST four Department UPDATE");
		Department departmentBefore = departmentDao.findById(3);
		departmentBefore.setName("Sales");
		System.out.println("Before update: " + departmentBefore);
		departmentDao.update(departmentBefore);
		System.out.println("Update complete");
		Department departmentupd = departmentDao.findById(3);
		System.out.println(departmentupd);

		System.out.println("\n===TEST five: Department DeletebyId===");
		System.out.println("Inform an id to delete data");
		int idDelete = sc.nextInt();
		departmentDao.deleteById(idDelete);
		System.out.println("Delete complete");

		sc.close();

	}

}
