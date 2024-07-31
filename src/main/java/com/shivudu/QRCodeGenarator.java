package com.shivudu;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeGenarator {

	public static void main(String[] args) {
		String userId ="12345";
		String userName = "Adigonda Shivudu";
		String address = "Gattu Raipakula";
		String email = "shivudua3745@gmail.com";
		String mobNumber = "+91 9553240655";
		
		String userData = "User Id:"+userId+"\n"
				+"Username:"+userName+"\n"
				+"Address:"+address+"\n"
				+"Email:"+email+"\n"
				+"Mobile Number:"+mobNumber;
				
     String dirPath ="qr_codes";
	String filePath = dirPath+File.separator+userName+"user_qr_code.png";	
		
		
	Path dir = FileSystems.getDefault().getPath(dirPath);
	
	if (!Files.exists(dir)) {
		try {
		Files.createDirectories(dir);
		System.out.println("Directory Created: "+dir);
		}catch (Exception e) {
			System.out.println("Error Creating Directory :"+e.getMessage());
			e.printStackTrace();
		}
		try {
			Map<EncodeHintType,Object> hintmap = new HashMap<>();
			hintmap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			
			BitMatrix mat = new MultiFormatWriter().encode(userData, BarcodeFormat.QR_CODE, 300, 300,hintmap);
		
			MatrixToImageWriter.writeToStream(mat, "PNG",new FileOutputStream(filePath));
			
			System.out.println("QR Code Generated Successfully.!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
