package swa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1928 {
	private static int base64[] = new int[128];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		init();
		for(int testCase = 1; testCase <= T; testCase++) {
			char[] encoded = br.readLine().toCharArray();
			String decoded = String.valueOf(decode(encoded));
//			String decoded = new String(Base64.getDecoder().decode(encoded));
			//result
			System.out.println("#"+testCase+" "+decoded);
		}
	}
	
	private static void init() {
		for(int i = 0; i < 26; i++)	base64['A'+i] = i;
		for(int i = 0; i < 26; i++)	base64['a'+i] = 26 + i;
		for(int i = 0; i < 11; i++)	base64['0'+i] = 52 + i;
		base64['+'] = 62;
		base64['/'] = 62;		
	}
	
	private static char[] decode(char[] src) {
		char[] dst = new char[src.length];
		int bits, pos = 0, des = 0;
		while(pos < src.length) {
			//24bits
			bits = base64[src[pos++]] << 18;
			bits += base64[src[pos++]] << 12;
			bits += base64[src[pos++]] << 6;
			bits += base64[src[pos++]];
			
			dst[des++] = (char) (bits >> 16 & 0xFF);
			dst[des++] = (char) (bits >> 8 & 0xFF);
			dst[des++] = (char) (bits  & 0xFF);
		}
		return dst;
	}

}
