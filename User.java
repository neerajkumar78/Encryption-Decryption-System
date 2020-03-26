package encryption_decryption;
import java.util.Scanner;

import encryption_decryption.EncAndDecApi;
//for EncAndDecApi   and   EncAndDecAlgo
public class User {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scan1=new Scanner(System.in);
		Scanner scan2=new Scanner(System.in);
		EncAndDecApi obj=new EncAndDecApi();
		while(true) {
		System.out.println("enter 1.encryption 2.decryption 3.exit");
		int choice=scan2.nextInt();
		switch(choice) {
		case 1:
		System.out.println("enter source path for encryption");
		String source=scan1.nextLine();//"E:\\javafiletesting.txt";
		System.out.println("enter destination path for encryption");
		String destin=scan1.nextLine();
		System.out.println("enter 1.keep source file 2.1.delete source file");
		choice=scan2.nextInt();
		boolean flag=choice==1?true:false;
		obj.doEnc(source,destin,flag);
		break;
		case 2:
		System.out.println("enter source path for decryption");
		source=scan1.nextLine();//"E:\\javafiletesting.txt";
		System.out.println("enter destination path for decryption");	
		destin=scan1.nextLine();
		System.out.println("enter 1.keep source file 2.1.delete source file");
		choice=scan2.nextInt();
		 flag=choice==1?true:false;
		obj.doDec(source,destin,flag);
		break;
		case 3:
			System.exit(0);
		}
		}
	}
}