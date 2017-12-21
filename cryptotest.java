package cryptotest;

import java.io.*;
import java.nio.file.Files;
import java.security.*;
import javax.crypto.*;
import static java.util.Arrays.copyOfRange;



public class cryptotest {

    public static void main(String[] args) throws Exception{
       
     String filename = "";
        if (0 < args.length){            
               filename = args[0];              
        }
       File file = new File(filename);
       FileInputStream fileIn = new FileInputStream(file);
       byte Content[] = new byte[(int)file.length()];
       fileIn.read(Content);
       String input = new String(Content);
       
       System.out.println(input.length());
       AES128(filename);
       RSA1024(input);
       HMACMD5(filename,"MD5","HmacMD5");
       digSig(input);
    }
    public static void AES128(String f)throws Exception
    {
        System.out.println(f);
        /*KeyGenerator KeyGen = KeyGenerator.getInstance("AES");
        SecureRandom k = SecureRandom.getInstance("SHA1PRNG");
        KeyGen.init(128, k);
        SecretKey key = KeyGen.generateKey();
  
        SecureRandom r = new SecureRandom();
        byte[] iv = new byte[16];
	r.nextBytes(iv);
        for(int x =0;x<5;x++){
        //Encryption
        long startTimeEncrypt = System.currentTimeMillis();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key, r);
            FileInputStream fileIn1 = new FileInputStream(f);
            OutputStream CipherText = new FileOutputStream("C:\\Users\\saikr\\Desktop\\random\\output.txt");
            CipherText = new CipherOutputStream(CipherText, cipher);
            byte[] buf = new byte[16];
            int i;
            while ((i = fileIn1.read(buf))>=0){
                CipherText.write(buf,0,i);
            }
       CipherText.close();
       
        
        
       long stopTimeEncrypt = System.currentTimeMillis();
       long elapsedTimeEncrypt = (stopTimeEncrypt - startTimeEncrypt)/1000;
       System.out.println("AES128 Encrypt Running Time "+" " + elapsedTimeEncrypt+ "sec");
       
       //Decryption
       long startTimeDecrypt = System.currentTimeMillis();
       Cipher de_cipher = Cipher.getInstance("AES");
       de_cipher.init(Cipher.DECRYPT_MODE, key, r);
       FileInputStream fileIn2 = new FileInputStream("C:\\Users\\saikr\\Desktop\\random\\output.txt");
       OutputStream PlainText = new FileOutputStream("C:\\Users\\saikr\\Desktop\\random\\plaintext.txt");
       PlainText = new CipherOutputStream(PlainText, de_cipher);
       int j;
            while ((j = fileIn2.read(buf))>=0){
                PlainText.write(buf,0,j);
            }
        PlainText.close();
        long stopTimeDecrypt = System.currentTimeMillis();
        long elapsedTimeDecrypt = (stopTimeDecrypt - startTimeDecrypt)/1000;
        System.out.println("AES128 Decrypt Running Time "+" " + elapsedTimeDecrypt + "sec");
    }*/
    }
    public static void AES256(String f)throws Exception
    {
        /*KeyGenerator KeyGen = KeyGenerator.getInstance("AES");
        SecureRandom k = SecureRandom.getInstance("SHA1PRNG");
        KeyGen.init(256, k);
        SecretKey key = KeyGen.generateKey();

        SecureRandom r = new SecureRandom();
        byte[] iv = new byte[16];
	r.nextBytes(iv);
    }
    
  public static void RSA1024(String input)throws Exception
{
    //generation of RSA key
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
    keyGen.initialize(2048);
    KeyPair keypair = keyGen.genKeyPair();
    PrivateKey privateKey = keypair.getPrivate();
    PublicKey publicKey = keypair.getPublic();
    
    //encryption
    /*long startTimeEncrypt = System.currentTimeMillis();
    byte[] cipher;
    cipher = null;
    Cipher c = Cipher.getInstance("RSA/ECB/NoPadding");
    c.init(Cipher.ENCRYPT_MODE, publicKey);
    byte[] bytes = input.getBytes();
    int i = 256;
    System.out.println(input.length());
    for(int j =0;j<input.length();j = j+256){
            byte[] x = copyOfRange(bytes, j ,(j + 255));
            c.update(x);
    }
    
    
    long stopTimeEncrypt = System.currentTimeMillis();
    long elapsedTimeEncrypt = (stopTimeEncrypt - startTimeEncrypt)/1000;
    System.out.println("RSA2048 Encrypt Running Time "+" " + elapsedTimeEncrypt+ "sec");
    
    //Decryption
    long startTimeDecrypt = System.currentTimeMillis();
    Cipher d = Cipher.getInstance("RSA/ECB/NoPadding");
    d.init(Cipher.DECRYPT_MODE,privateKey);
    
    
    long stopTimeDecrypt = System.currentTimeMillis();
    long elapsedTimeDecrypt = (stopTimeDecrypt - startTimeDecrypt)/1000;
    System.out.println("RSA2048 Decrypt Running Time "+" " + elapsedTimeDecrypt + "sec");*/
}
  
  public static void HMACMD5(String f,String md_algo,String key_algo) throws Exception
  {
        int count = 4;
        /*int i,j;
        long[] arr = new long[count];
        for(j = 0; j<count;j++){
        KeyGenerator KeyGen = KeyGenerator.getInstance(key_algo);
        SecureRandom k = SecureRandom.getInstance("SHA1PRNG");
        KeyGen.init(256, k);
        SecretKey key = KeyGen.generateKey();
        
        MessageDigest md = MessageDigest.getInstance(md_algo);
        FileInputStream fileIn = new FileInputStream(f);
        
        byte[] buf = new byte[1024];
        
        String digest = null;
        
        long startTime = System.currentTimeMillis();
        while ((i = fileIn.read(buf))!= -1){
            md.update(buf,0,i);
        }
        
        byte[] mdbytes = md.digest();
        
        StringBuffer hash = new StringBuffer();
        for(i=0;i<mdbytes.length;i++){
            String hex = Integer.toHexString(0xFF & mdbytes[i]);
            if(hex.length() == 1){
                hash.append('0');
            }
                hash.append(hex);
        }
                digest = hash.toString();
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                System.out.println("["+j+"]"+" "+"MD5 elapsed Time = " + elapsedTime + "millisec");
                arr[j] = elapsedTime;
        }
                long temp;
                for (i=0;i<count;i++){
                    for(j=1;j<(count-i);j++){
                    if(arr[j-1]>arr[j]){
                        temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
                }
                long sum = 0;
                for (i=0;i<count;i++){
                    sum = sum + arr[i];
                }
                long mean = sum/count;
                long median;
                System.out.println("[HMAC MD5]");
                System.out.println("mean : " + mean );
                if((count % 2) == 0){
                    median = (arr[(count-1)/2] + arr[count/2])/2;
                }
                else{
                    median = arr[(count - 1)/2];
                }
                System.out.println("median : " + median );*/
  }
  public static void digSig(String input)throws Exception{
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(4096);
        KeyPair keypair = keyGen.genKeyPair();
        PrivateKey privateKey = keypair.getPrivate();
        PublicKey publicKey = keypair.getPublic();
        
        KeyGenerator KeyGen = KeyGenerator.getInstance("HmacSHA256");
        SecureRandom k = SecureRandom.getInstance("SHA1PRNG");
        KeyGen.init(256, k);
        SecretKey key = KeyGen.generateKey();

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        byte[] b = input.getBytes();
        signature.update(b);
        byte[] sign = signature.sign();
        
        Signature v = Signature.getInstance("SHA256withRSA");
        v.initVerify(publicKey);
        v.update(b);
        boolean result = v.verify(sign);
        System.out.println("result = "+result);
  }
}

 


