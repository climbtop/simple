package simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		//String folder = "D:/workspace/wechat/trunk/src/main/java/com-";
		String folder = "D:/workspace/qcsoft/src/main/java/";
		
		replaceFolder(folder);
	}

	
	public static void replaceFolder(String filePath)
			throws Exception {
		File folder = new File(filePath);
		if (!folder.exists())
			return;
		if (folder.isFile()) {
			replaceFile(filePath);
			return;
		}
		File[] files = folder.listFiles();
		for (File file : files) {
			try {
				if (file.isDirectory()) {
					replaceFolder(file.getAbsolutePath());
				}
				if (file.isFile()) {
					replaceFile(file.getAbsolutePath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean replaceFile(String filePath)
			throws Exception {
		File fileCur = new File(filePath);
		if (!fileCur.exists())
			return true;
		if(!fileCur.getName().toLowerCase().endsWith(".java")){
			return true;
		}
		String filePathBak = filePath+".bak";
		
		String enc = "UTF-8";
		try{
			Reader fr = enc == null ?
					new FileReader(filePath) :
					new InputStreamReader (new FileInputStream(filePath),enc);

			Writer fw = enc == null ? new OutputStreamWriter(new FileOutputStream(filePathBak, true))
					: new OutputStreamWriter(new FileOutputStream(filePathBak, true), enc);

			PrintWriter printWriter = new PrintWriter(new BufferedWriter(fw));
					
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			
			int x=0,y=0,z=0;
			while((line=br.readLine())!=null){
				String text = line.trim();
				
				if(text.indexOf("XYSM\\Desktop\\afocus-framework-1.0.7-SNAPSHOT.jar")>=0) {
					x = 1;
					continue;
				}
				if(text.indexOf("Qualified Name:     com.afocus")>=0) {
					y = 1;
					continue;
				}
				if(text.indexOf("JD-Core Version:    0.7.0.1")>=0) {
					z = 1;
					continue;
				}
				
				if(text.equals("*/") && x>0 && y>0 && z>0) {
					continue;
				}

				printWriter.println(line);
			}
			br.close();
			fr.close();
			
			printWriter.flush();
			printWriter.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		new File(filePath).delete();
		new File(filePathBak).renameTo(new File(filePath));

		System.out.println(filePath + "\t" + ("[Done]"));
		return true;
	}
	
	public static boolean replaceFile2(String filePath)
			throws Exception {
		File fileCur = new File(filePath);
		if (!fileCur.exists())
			return true;
		if(!fileCur.getName().toLowerCase().endsWith(".java")){
			return true;
		}
		String filePathBak = filePath+".bak";
		
		String enc = "UTF-8";
		try{
			Reader fr = enc == null ?
					new FileReader(filePath) :
					new InputStreamReader (new FileInputStream(filePath),enc);

			Writer fw = enc == null ? new OutputStreamWriter(new FileOutputStream(filePathBak, true))
					: new OutputStreamWriter(new FileOutputStream(filePathBak, true), enc);

			PrintWriter printWriter = new PrintWriter(new BufferedWriter(fw));
					
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while((line=br.readLine())!=null){
				String text = line.trim();
				if(text.startsWith("/*") && text.indexOf("*/")>0){
						String temp = line.substring(0, line.indexOf("/*"));
						temp += line.substring(line.indexOf("*/")+2);
					printWriter.println(temp);
				}else{
					printWriter.println(line);
				}
			}
			br.close();
			fr.close();
			
			printWriter.flush();
			printWriter.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		new File(filePath).delete();
		new File(filePathBak).renameTo(new File(filePath));

		System.out.println(filePath + "\t" + ("[Done]"));
		return true;
	}
	
	
}
