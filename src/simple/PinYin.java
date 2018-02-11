package simple;

import java.util.List;

import com.common.FileUtil;

public class PinYin {

	public static void main(String[] args) {
		String file = "d:/tmp/py.txt";
		List<String> pyList = FileUtil.readFile(file,"utf-8");
		for(String head : pyList){
			for(String last : pyList){
				String full = head + last;
				if(check(full)){
					System.out.println(full);
					FileUtil.writeFile("d:/tmp/py6.txt",full);
				}
			}
		}
	}

	public static boolean check(String full){
		return full.length()==6;
	}
	
}
