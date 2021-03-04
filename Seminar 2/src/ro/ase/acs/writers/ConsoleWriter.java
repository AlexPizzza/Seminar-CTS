package ro.ase.acs.writers;

import ro.ase.acs.contracts.Writeable;

public class ConsoleWriter implements Writeable {
	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
	}
}
