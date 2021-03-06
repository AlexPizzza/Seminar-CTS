package ro.ase.acs.readers;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class Reader implements Closeable, ro.ase.acs.contracts.Readable {
	private Scanner sc = new Scanner(System.in);

    public String read(){
        System.out.println("Message:");
        String message = sc.nextLine();

        return message;
    }

    @Override
    public void close() throws IOException {
        sc.close();
    }
}
