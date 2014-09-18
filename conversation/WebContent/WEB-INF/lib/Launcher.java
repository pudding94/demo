import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.junit.runner.JUnitCore;

public class Launcher {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		List<String> tests = new ArrayList<String>();
		//tests.add("ListTest");
		//String[] tests = new String[]{
		//		"com.demo.test.ListTest",
		//		"com.demo.test.StringTest"
		//};
		//String currentDir = System.getProperty("user.dir");
		String path =  "d:\\test\\test.jar";
		String testPackagePrefix = "com.demo.test";
		JarFile jarFile = new JarFile(path);
		Enumeration<JarEntry> entries = jarFile.entries();
		while (entries.hasMoreElements()) {
			JarEntry theEntry = entries.nextElement();
			String aTest = theEntry.getName();
			aTest = aTest.replace('/', '.');
			if (aTest.startsWith(testPackagePrefix)) {
				int lastDotIndex = aTest.lastIndexOf('.');
				aTest = aTest.substring(0, lastDotIndex);
				tests.add(aTest);
			}
		}
		
		JUnitCore.main(tests.toArray(new String[]{}));
	}

}
