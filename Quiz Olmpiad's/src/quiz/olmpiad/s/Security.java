/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.olmpiad.s;

/**
 *
 * @author Anmol
 */

//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

//import sun.misc.BASE64Decodr;


public class Security {
    
    private static final String ALGO = "AES";
    private byte[] keyValue;

    public Security(String key) {
        keyValue = key.getBytes();
    }
    
    public String encrypt(String Data) throws Exception{
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    
    }
    
    public String decrypt(String encryptedData) throws Exception{
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    
    }
    
    public Key generateKey() throws Exception{
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    
    }

    
    public static void main(String[] arg){
        try {
            User user = new User();
            Security secure = new Security("lv39eptlvuhaqqsr");
            String encdata = secure.encrypt(user.getPassword());
            System.out.println("Encrypted Data : "+ encdata);
            String decdata = secure.decrypt(encdata);
            System.out.println("Decrypted Data : "+ decdata);
        } catch (Exception e) {
//            e.printStackTrace();
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, e);
        }
    
    }
    
    
    
}
