import java.util.*;

public class Encoder_Decoder {

	//Alex, this function is used in conjunction with encoder and decoder
	//functions. This is just a faster way to find what letter the 5 bit
	//representation corresponds to. 
	public static String find_rep(String input)
	{
		String output;
		String[]value_array = {"00000", "00001", "00010", "00011",
							"00100", "00101", "00110", "00111",
							"01000","01001", "01010",  "01011", "01100",
							"01101", "01110",  "01111", "10000", "10001",
							"10010",  "10011", "10100", "10101", "10110",
							"10111", "11000", "11001", "11010", "11011"};
		String[]letter_array= {"a", "b" ,"c", "d", "e", "f", "g", 
								"h", "i", "j", "k", "l", 
								"m", "n", "o", "p", "q", "r", "s",
								"t","u","v","w","x","y","z", ".", " "};
		
		for(int count=0; count<28; count++)
		{
			
			if(value_array[count].equals(input))
			{
				output=letter_array[count];
				System.out.print(letter_array[count]);
				return letter_array[count];	
			}
			else
				return "?";
		}
		return null;	
	}
	
	public static String[] turn_into_5array(String input)
	{
		
		int length = input.length();
		String[] output = new String[length/5];
		int temp=0;
		for(int i=0; i<length-1; i+=5)
		{
			String temp2 = input.substring(i, i+5);
			output[temp]= temp2.toString();
			temp+=1;
		}		
		return output;
	}
	
	public static void decoder(String input)
	{
		String[] five_array = turn_into_5array(input);
		/*for(int i=0; i< five_array.length; i++)
		{
			System.out.println(five_array[i]);
		} */
		int length= five_array.length;
		//System.out.println(length);
		String[] output = new String[length];
		//System.out.print(length);
		for(int i=0; i<length; i++)
		{
			find_rep(five_array[i]);
			output[i]=find_rep(five_array[i]);
			
		}
		for(int i=0; i<output.length; i++)
		{
			System.out.print(output[i]);
		}	
	}

	public static String rolling_XOR(String key, String plaintext)
	{
		String temp = key;
		while(key.length != plaintext.length)
		{
			temp += key;
		}
		return temp^plaintext;
	}

	public static void lorenz_matcher(String input)
	{
		int length = input.length;
		String[] pt_array = new String[input.length];
		int keyLength = 0;
		for(keyLength = 1; keyLength < length; keyLength++)
		{
			String key = input.substring(0, keyLength);
			pt_array = rolling_XOR(key, input);
			decoder(pt_array);
		}

	}

	public static void main(String[] args) 
	{
		String test2 = "01101001010110110001101111010111100001110011000110000001010000000101001101111000101000001010111010101010011001000110101110000110000110010100010110001100111100110011000000000100100000101101001010110100101111010000001110100110010011111101110001001010110101110001000010000000011100011110011000001111011100101001000100111100001011001010011001100000000111001110000000011110001101100001101011110001100001001001010111001001101000100010110110110000101110100110010011110000001011001011001110110000100100001111011011001100000011001111100010010110101111100100111010111011000011101010110110111100000111110100011101110001001110000010000000001101011110101010110111100101000000010011110111000100111101000100000110100101101101000001100011101101011111001000100111001011011100010010011010001111100101101111010000000000111000000111111001101010001011010100010100011111111001000000100010101011100111001101001110110000000000011101011110111111100010001011101100001110001100000110110110101000011011110110010111110100000000001011110101000100111101010010111011100001001001110001100110010111011101111100101011100010111100000111110111111000010000100100001011100111000111101010011001101011110100110100001111110000011001111011100000111101111101101001000111101100000000000001011011111011000111100000110111011110111010000111110011111101001010000011001101001100101111001111100101011100010100011010111101";
		lorenz_matcher(test2);
	}

}