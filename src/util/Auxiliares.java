package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Auxiliares {

	public static SimpleDateFormat sdfDiaMesAno = new SimpleDateFormat("dd/MM/yyyy");

	public static SimpleDateFormat sdfDataEHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static int getIdade(Date data) {
		Calendar cData = Calendar.getInstance();
		Calendar cHoje = Calendar.getInstance();
		cData.setTime(data);
		cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));
		int idade = cData.after(cHoje) ? -1 : 0;
		cData.setTime(data);
		idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);
		return idade;
	}
}
