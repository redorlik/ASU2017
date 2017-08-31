package dk.au.ase.elektronik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class File_IO {

	public String convert(String input){
		int i = 0;
		char[] cres = new char[input.length()]; 	// Create a char array to hold the converted characters
		for (char c:input.toCharArray()){ 		// foreach loop
			if (Character.isLowerCase(c)){
				c = Character.toUpperCase(c); 	//convert case
			}else{
				c = Character.toLowerCase(c);	//convert case
			}
			cres[i]=c;							//store converted chararacter
			i += 1;								//increment counter
		}
		return new String(cres);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File_IO fio = new File_IO();
		String conv;
		String ifile = "/Users/alehmann/test_text.txt";
		String ofile = "/Users/alehmann/test_text2.txt";
		
		BufferedReader i_s = new BufferedReader(new FileReader(ifile));
		BufferedWriter o_s = new BufferedWriter(new FileWriter(ofile));

		String x = i_s.readLine();
		while (x!=null){
			conv = fio.convert(x);
			System.out.println(conv);
			o_s.write(conv);
			o_s.write("\n");
			x = i_s.readLine();
		}
		i_s.close();
		o_s.close();
		System.out.println("\u263a");
	}

}
