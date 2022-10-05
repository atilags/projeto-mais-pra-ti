import java.text.ParseException;

import domain.Pessoa;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Pessoa p = new Pessoa("Benito", "982310565", "02/03/1990");
		
		System.out.println(p);
	}

}
