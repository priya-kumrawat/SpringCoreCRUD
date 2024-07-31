package com.uni.daoImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import com.uni.dao.StudentDao;
import com.uni.entity.Student;
import com.uni.main.App;

import lombok.Getter;
import lombok.Setter;

@Getter // Use Getter for jdbcTemplate
@Setter // Use Setter for jdbcTemplate
public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	private int input;
	private int yes = 1;
	Scanner sc = new Scanner(System.in);
	Student student = new Student();

	public void insert() {

		do {
			String insertQry = "insert into test (id,name,city) value(?, ?, ?)";
			System.out.print("\t Enter id : ");
			student.setId(sc.nextInt());
			sc.nextLine();

			System.out.print("\t Enter Name : ");
			student.setName(sc.nextLine());

			System.out.print("\t Enter city : ");
			student.setCityName(sc.nextLine());

			this.jdbcTemplate.update(insertQry, student.getId(), student.getName(), student.getCityName());
			System.out.println("\n-----------Student Info Insert Successfully-------------");

			System.out.println();
			System.out.println("\t Insert More Student Informations");
			System.out.println("\t 1.yes");
			System.out.println("\t 2.no \n");
			System.out.print("\t Enter Choice :");
			input = sc.nextInt();
			sc.nextLine();

		} while (input == yes);

		App.StudentCRUD();

	}

	public void update() {

		do {
			String updateQry = "update test set name = ?, city = ? where id = ? ";
			System.out.print("\t Enter id : ");
			student.setId(sc.nextInt());
			sc.nextLine();

			System.out.print("\t Enter Name : ");
			student.setName(sc.nextLine());

			System.out.print("\t Enter city : ");
			student.setCityName(sc.nextLine());

			this.jdbcTemplate.update(updateQry, student.getName(), student.getCityName(), student.getId());
			System.out.println("\n-----------Student Info Update Successfully-----------");

			System.out.println();
			System.out.println("\t Update More Student Informations");
			System.out.println("\t 1.yes");
			System.out.println("\t 2.no \n");
			System.out.print("\t Enter Choice :");
			input = sc.nextInt();
			sc.nextLine();

		} while (input == yes);
		App.StudentCRUD();
	}

	public void delete() {
		do {

				String deleteQry = "delete from test where id = ? ";
				System.out.print("\t Enter id : ");
				student.setId(sc.nextInt());
				sc.nextLine();
				this.jdbcTemplate.update(deleteQry, student.getId());
				
			
			System.out.println("\n-----------Student Info Delete Successfully-----------");
			System.out.println();
			System.out.println("\t Delete More Student Informations");
			System.out.println("\t 1.yes");
			System.out.println("\t 2.no \n");
			System.out.print("\t Enter Choice :");
			input = sc.nextInt();
			sc.nextLine();

		} while (input == yes);
		App.StudentCRUD();

	}

	@Override
	public List<Student> read() {
		// TODO Auto-generated method stub
		return null;
	}

}
