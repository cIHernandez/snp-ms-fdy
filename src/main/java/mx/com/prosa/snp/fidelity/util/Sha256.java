package mx.com.prosa.snp.fidelity.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sha256 {
	
	Logger logger = LoggerFactory.getLogger(Sha256.class);
	
	  public String generatePassword(String passwordToHash, byte[] salt)
	    {
	       String generatedPassword = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            md.update(salt);
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            generatedPassword = new String( Base64.getEncoder().encode(sb.toString().getBytes()));
	        } 
	        catch (NoSuchAlgorithmException e) 
	        {
	        	logger.error("Error generando sha a partir del password", e);
	        }
	        return generatedPassword;
	    }

}
