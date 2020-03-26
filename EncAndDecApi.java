package encryption_decryption;
//used by EncAndDecAlgo and Used By User
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
public class EncAndDecApi {
	public void doEnc(String source,String destin,boolean flag) throws Exception{
		File f1=new File(source);
		if(f1.exists()) {
			FileInputStream fis=new FileInputStream(f1);
			int available=fis.available();
			int x=available;
			int p=x/16;
			if(x%16>0)
				p++;
			do {
				byte[] buf=new byte[16];
				fis.read(buf);	
				byte key1[]= {0B00001010,0b00101010,0B01010101,0B01001110,0B01101100,0B00101010,0B00001111,0B00111010,0B00001010,0B00101010,0B01010101,0B00100110,0B01101100,0B01101010,0B00001111,0B00111010};
				for(int i=0;i<16;i++) {
					buf[i]^=key1[i];
				}
				EncAndDecAlgo t=new EncAndDecAlgo();
		        buf=t.enc(buf);
				byte key2[]= {0B00001010,0B00101010,0B01010101,0B01010101,0B00100110,0B01101100,0B01101010,0B00001111,0B00111010,0B01001110,0B01101100,0B00101010,0B00001111,0B00111010,0B00001010,0B00101010};
				for(int i=0;i<16;i++) {
					buf[i]^=key2[i];
				}
				FileOutputStream fos=new FileOutputStream(destin,true);
				fos.write(buf);
				fos.close();
				x-=16;
				p--;
			}while(p>=1);
			if(!flag)
			f1.deleteOnExit();
			fis.close();
		}
	}
	public void doDec(String source,String destin,boolean flag) throws Exception{
		File f1=new File(source);
		if(f1.exists()) {
			FileInputStream fis=new FileInputStream(f1);
			int available=fis.available();
			int x=available;
			int p=x/16;
		do {
			    byte[] buf=new byte[16];
				fis.read(buf);
				byte key2[]= {0B00001010,0b00101010,0B01010101,0B01010101,0B00100110,0B01101100,0B01101010,0B00001111,0B00111010,0B01001110,0B01101100,0B00101010,0B00001111,0B00111010,0B00001010,0B00101010};
				for(int i=0;i<16;i++) {
					buf[i]^=key2[i];
				}
				EncAndDecAlgo t=new EncAndDecAlgo();
		        buf=t.dec(buf);
				byte key1[]= {0B00001010,0b00101010,0B01010101,0B01001110,0B01101100,0B00101010,0B00001111,0B00111010,0B00001010,0B00101010,0B01010101,0B00100110,0B01101100,0B01101010,0B00001111,0B00111010};
				for(int i=0;i<16;i++) {
					buf[i]^=key1[i];
				}
				FileOutputStream fos=new FileOutputStream(destin,true);
				fos.write(buf);
				fos.close();
				x-=16;
			p--;
		}while(p>=1);
		if(!flag)
			f1.deleteOnExit();
			fis.close();	
	}
	}

}
