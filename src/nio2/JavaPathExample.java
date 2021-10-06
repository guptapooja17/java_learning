package nio2;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

//https://www.baeldung.com/java-nio-2-file-api

public class JavaPathExample {

	public static void main(String[] args) {

		//Creating a directory path using Path.of
		System.out.println("_________________Creating Directory Path_________________");
		Path dirPath = Path.of("nio2", "dir1");
		System.out.println(dirPath);
		System.out.println(dirPath.toAbsolutePath());

		//Creating a file path using Path.of
		System.out.println("_________________Creating File Path______________________");
		Path file1 = Path.of("nio2", "dir1", "file1.txt");
		System.out.println(file1);
		System.out.println(file1.toAbsolutePath());
		System.out.println(file1.getFileName());

		//Creating a directory path using Paths.get
		System.out.println("_________________Creating Directory Path_________________");
		Path dirPath2 = Paths.get("nio2","dir1");
		System.out.println(dirPath2);
		System.out.println(dirPath2.toAbsolutePath());

		//Creating a file path using Paths.get
		System.out.println("_________________Creating File Path______________________");
		Path file2 = Paths.get("nio2", "dir1", "file2.txt");
		System.out.println(file2);
		System.out.println(file2.toAbsolutePath());
		System.out.println(file2.getFileName());

		Path file3, file4;
		/*
		 * try {
		 * 
		 * file3 = Path.of(new URI("file://nio2/dir1/file1.txt"));
		 * System.out.println(file3.getFileName());
		 * 
		 * file4 = Paths.get(new URI("file://nio2/dir1/file2.txt"));
		 * System.out.println(file4.getFileName());
		 * 
		 * } catch (URISyntaxException e) { e.printStackTrace(); }
		 */

		// Creating directory path using FileSystem
		System.out.println("_________________Using File System: Path______________________");
		Path dirPath3 = FileSystems.getDefault().getPath("nio2", "dir1");
		System.out.println(dirPath3);
		System.out.println(dirPath3.toAbsolutePath());

		// Creating file path using FileSystem
		System.out.println("_________________Creating File Path______________________");
		Path file5 = FileSystems.getDefault().getPath("nio2", "dir1", "file1.txt");
		System.out.println(file5);
		System.out.println(file5.toAbsolutePath());
		
		// Creating File to Path
		System.out.println("________________________________________________________");
        Path file6 = new File( "nio2", "dir1\\file3.txt").toPath();
        System.out.println(file6);
        System.out.println(file6.toAbsolutePath());
        System.out.println(file6.getFileName());

        // 10.
        // Creating Path to File
        File file7 = Paths.get("nio2", "dir1", "file3.txt").toFile();
        System.out.println(file7);
        System.out.println(file7.getAbsolutePath());
        System.out.println(file7.getName());


	}

}
