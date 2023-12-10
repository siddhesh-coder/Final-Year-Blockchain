/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Blockchain;

import java.security.MessageDigest;
import java.util.Date;
import java.util.*;


public class Block {
	
	public static String hash;
	public String previousHash; 
	private String data; //our data will be a simple message.
	public static long timeStamp; //as number of milliseconds since 1/1/1970.
	public static int nonce;
	public static Map<Integer, String> blocklist = new HashMap<Integer, String>();
	 
	//Block Constructor.  
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		Block.timeStamp = new Date().getTime();
		
		Block.hash = calculateHash(); //Making sure we do this after we set the other values.
	 
        }

//Applies Sha256 to a string and returns the result. 
	public static String applySha256(String input){
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");//is used to obtain an instance of the MessageDigest class that can perform cryptographic hashing using the SHA-256 algorithm. //sha256-bit (32-byte) hash value.
	        
			//Applies sha256 to our input, 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));//hash array
	        
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) { //A loop is used to iterate over each byte in the hash array.
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0'); //add 0 to first of the string
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
//Calculate new hash based on blocks contents
	public String calculateHash() {
		String calculatedhash = applySha256( 
				previousHash +
				Long.toString(timeStamp) + //he timeStamp variable represents the timestamp or time when the block was created.
				Integer.toString(nonce) +  //The nonce variable is an integer value used in blockchain mining algorithms.
				data //This variable represents the data stored in the current block. It is assumed to be a string.
				);
		return calculatedhash;
	}
	
	public void mineBlock1(int difficulty) {//The replace('\0', '0') method is called on the target string to replace all occurrences of the null character with the character '0'. This creates a string consisting of difficulty number of '0' characters.
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;//After incrementing the nonce, the hash value of the block is recalculated by calling the calculateHash() method. This updates the hash variable with the new hash value based on the updated contents of the block.
			hash = calculateHash();
			//System.out.println(hash);
			//The loop continues until a hash value is found that has the required number of leading zeroes specified by the difficulty. Once a matching hash is found, the loop terminates, indicating that the block has been successfully mined.                     
		}
             
        }
	

}