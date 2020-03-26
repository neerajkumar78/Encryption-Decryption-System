package encryption_decryption;
import java.util.Arrays;
//used by EncAndDecApi and Used By User
public class EncAndDecAlgo {
	public byte[] enc(byte[] b1) {
		byte b=0;
		for(int i=3,j=0;i>=0&&j<16;i--,j+=4) {
			int k=0;
			for(k=i;k<=12+i;k+=4) {
				if(k==i) {
					b=b1[k];
				}
				else {
					b1[k-4]=b1[k];
				}
			}
			b1[k-4]=b;
			int l=0;
			for(l=j+3;l>=j;l--) {
				if(l==j+3) {
					b=b1[j+3];
				}
				else {
					b1[l+1]=b1[l];
				}
			}
			b1[j]=b;
		}
		return b1;
	}
	public byte[] dec(byte[] b1) {	
	byte b=0;
	for(int i=0,j=12;i<4&&j>=0;i++,j-=4) {
		int k=0;
		for(k=j;k<=j+3;k++) {
			if(k==j) {
				b=b1[k];
			}
			else {
				b1[k-1]=b1[k];
			}
		}
		b1[k-1]=b;
		int l=0;
		for(l=12+i;l>=i;l-=4) {
			if(l==i+12) {
				b=b1[l];
			}
			else {
				b1[l+4]=b1[l];
			}
		}
		b1[i]=b;	
	}
	return b1;
	}
	
}
