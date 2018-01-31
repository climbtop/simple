package simple;

import com.afocus.framework.util.file.FileUtil;

public class AI {

	public static void main(String[] args) {
		for(char a = 'a'; a<='z'; a++){
			for(char b = 'a'; b<='z'; b++){
				for(char c = 'a'; c<='z'; c++){
					for(char d = 'a'; d<='z'; d++){
						if( check(b) && check(d)){
							FileUtil.write
							System.out.println(a+""+b+""+c+""+d);
						}
					}
				}
			}
		}
	}
	
	public static void main1(String[] args) {
		for(char a = 'a'; a<='z'; a++){
			for(char b = 'a'; b<='z'; b++){
				for(char c = 'a'; c<='z'; c++){
					if(check(a) || check(b) || check(c)){
						System.out.println(a+""+b+""+c);
					}
				}
			}
		}
	}
	
	public static boolean check(char c){
		return c=='a' || c=='o' ||c=='e' ||c=='i'||c=='u' ;
	}
	public static boolean check2(char c){
		return c=='a' || c=='o' ||c=='e' ||c=='i'||c=='u' ||c=='v';
	}

}
