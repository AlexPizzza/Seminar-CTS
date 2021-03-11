package ro.ase.acs.main;

import ro.ase.acs.contracts.Readable;
import ro.ase.acs.contracts.Writeable;
import ro.ase.acs.readers.Reader;
import ro.ase.acs.writers.ConsoleWriter;

public class Main {
	public static void main(String[] args) {
		IoC ioc = new IoC();
		ioc.register(Readable.class, Reader.class);
		ioc.register(Writeable.class, ConsoleWriter.class);
	
		Orchestrator orchestrator = null;
		try {
			orchestrator = new Orchestrator(ioc.resolve(Readable.class), ioc.resolve(Writeable.class));
		} catch (IllegalArgumentException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orchestrator.execute();
	}
}
