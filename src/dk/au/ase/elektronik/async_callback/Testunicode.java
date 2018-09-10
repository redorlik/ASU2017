package dk.au.ase.elektronik.async_callback;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Testunicode {

	public Testunicode() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws IOException {
		String sur = Integer.toHexString(Character.lowSurrogate(0x1f600));// 0001 1111 01 10 0000 0000
		// High surrogate D800 + 07D 
		String text = "Denne lille tekst indholder nogle af de specielle\n danske tegn æøå og ÆØÅ samt"
				+ "valuta symboler $€¥ 🍆🍆🍆🍆 \u1f60 " + Character.highSurrogate(0x1f600)+" j "+
			    sur  +" "+ Character.toChars(0x1f600);
		System.out.println(text);
		Character c = "\u1f60".charAt(0);
		System.out.println(Character.getName(0x1f600));
		byte[] b = text.getBytes("utf-8");
		String decoded = new String(b,"utf-16");
		String decoded_right = new String(b,"utf-8");
		//System.out.println(decoded);
		//System.out.println(decoded_right);
		OutputStream out = new FileOutputStream(new File("buffer.utf-8"));
		out.write(b);
		out.close();
		Path path = FileSystems.getDefault().getPath("", "buffer.utf-8");
		BufferedReader in =  Files.newBufferedReader(path, StandardCharsets.UTF_8);
		String reads = "";
		String tmp = in.readLine();
		while (tmp !=null) {
			reads += "\n"+tmp;
			tmp = in.readLine();
			//System.out.println(".");
		}
		in.close();
		System.out.println(reads+ reads.equals(text));
		
	}

}
