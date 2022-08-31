package CRUDPerson;

import java.util.LinkedList;
import java.util.Scanner;

public class PersonManagement {
	LinkedList<Person> list;

	public PersonManagement() {
		list = new LinkedList<>();
	}

	// add data
	public void add(Person person) {
		// checking data
		if (!find(person.getId())) {
			list.add(person);
		} else {
			System.out.println("Data sudah ada di dalam list");
		}
	}

	// search data
	public boolean find(int id) {
		// iterasi person list
		for (Person l : list) {
			// checking by id
			if (l.getId() == id) {
				System.out.println(l);
				return true;
			}
		}
		return false;
	}

	// delete data
	public void delete(int recId) {
		Person personDel = null;

		// iterasi person list
		for (Person ll : list) {
			// finding data and delete by id
			if (ll.getId() == recId) {
				personDel = ll;
			}
		}

		// data null and show error message
		if (personDel == null) {
			System.out.println("Data tidak ada!!!");
		} else {
			list.remove(personDel);
			System.out.println("Data berhasil dihapus...");
		}
	}

	// show person
	public Person findPerson(int id) {
		// iterasi person list
		for (Person l : list) {
			// checking data
			if (l.getId() == id) {
				return l;
			}
		}
		return null;
	}

	// update data
	public void update(int id, Scanner input) {
		if (find(id)) {
			Person rec = findPerson(id);

			System.out.print("Masukkan id terbaru = ");
			int idPerson = input.nextInt();
			System.out.print("Masukkan nama terbaru = ");
			input.nextLine();
			String namePerson = input.nextLine();
			System.out.print("Masukkan umur terbaru = ");
			int agePerson = input.nextInt();

			rec.setId(idPerson);
			rec.setName(namePerson);
			rec.setAge(agePerson);
			System.out.println("Data berhasil diperbarui...");
		} else {
			System.out.println("Data tidak ada!!!");
		}
	}

	// display data
	public void display() {
		// ketika data list kosong
		if (list.isEmpty()) {
			System.out.println("Data tidak ada di list Person!!!\n");
		}

		// iterasi data list
		for (Person person : list) {
			System.out.println(person.getId() + ", " + person.getName() + ", " + person.getAge());
		}
	}
}
