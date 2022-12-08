package com.snhu.sslserver;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";
@RestController
class HomeController {
	public static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            String s = "0" + Integer.toHexString(bytes[i]);
            stringBuilder.append(s.substring(s.length() - 2, s.length()));
        }
        return stringBuilder.toString();
    }
	//function generating hash
	public static String hashGen(String name, String algorithm) throws NoSuchAlgorithmException{
		// getting message digest SHA-256 instance
		MessageDigest md =  MessageDigest.getInstance(algorithm);
		// digesting name to bytes 
		byte[] hash = md.digest(name.getBytes(StandardCharsets.UTF_8));
		
		return bytesToHex(hash);
	}
    @RequestMapping("/hash")
    public String myHash(){
    	// to change to algorithm just change this variable to any of these Algorithm names MD2 MD5 SHA-1 SHA-224 SHA-256 SHA-384 SHA-512/224 SHA-512/256 SHA3-224
    	String ALGORITHM = "SHA-512/224"; 
    	String data = "Jad Alrehaoui";
    	String hash;
    	// generating hash
    	try {
    		hash = hashGen(data, ALGORITHM);
    	}
    	// catching exception to be thrown by the function
    	catch(Exception e) {
    		hash = "Exception caught !";
    		System.out.println("Exception: "+ e);
    	}
    	// web page rendering text
    	String vData = "<p>data: "+data+"</p>";
    	String vHash = "<p>Name of Cipher Algorithm Used: "+ALGORITHM+"</p>";
    	String vValue = "<p>Value: "+hash+"</p>";
        return vData + vHash + vValue;
    }


}
