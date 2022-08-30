package CRUDPerson;

import java.util.Scanner;

public class MenuPerson {

	// create menu
	public static void menu() {
		System.out.println("====================================");
		System.out.println("Daftar Menu:");
		System.out.println("====================================");
		System.out.println("1: Add Person");
		System.out.println("2: Delete Person");
		System.out.println("3: Update Person");
		System.out.println("4: Search Person");
		System.out.println("5: Display Person");
		System.out.println("6: Exit Menu");
		System.out.println("====================================\n");
		System.out.println("Masukkan menu yang diinginkan: ");
	}

	public static void main(String[] args) {
		PersonManagement hr = new PersonManagement();
		Person person = new Person();

		// data default
		person.setId(1);
		person.setName("Muhammad Nazli");
		person.setAge(23);

		// add data
		hr.add(person);

		Scanner input = new Scanner(System.in);

		int option = 0;
		do {
			menu();
			option = input.nextInt();

			switch (option) {
				case 1:
					System.out.print("Masukkan id = ");
					int idPerson = input.nextInt();
					System.out.print("Masukkan nama = ");
					input.nextLine();
					String namePer = input.nextLine();
					System.out.print("Masukkan umur = ");
					int agePerson = input.nextInt();

					person = new Person(idPerson, namePer, agePerson);
					hr.add(person);
					System.out.println(person.toString());
					break;

				case 2:
					System.out.print("Masukkan id = ");
					int rId = input.nextInt();

					hr.delete(rId);
					break;

				case 3:
					System.out.print("Masukkan id = ");
					int rIdPerson = input.nextInt();
					hr.update(rIdPerson, input);
					break;

				case 4:
					System.out.print("Masukkan id = ");
					int findId = input.nextInt();

					if (!hr.find(findId)) {
						System.out.println("Data Person tidak ada!!!");
					}
					break;

				case 5:
					hr.display();
					break;

				case 6:
					System.out.println("Terima kasih sudah berkunjung... :)");
					System.exit(0);
					break;

				default:
					System.out.println("Input salah...");
					break;
			}
		} while (option != 6);
	}
}
