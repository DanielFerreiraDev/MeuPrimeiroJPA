package br.edu.ifce.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Read {
	
	public byte [] getFoto(String path) throws IOException {
		File file = new File(path);
		byte[] foto = new byte[(int) file.length()];
		FileInputStream fileInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(foto);
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return foto;
	}

}
