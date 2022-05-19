package fileExplorer;

import java.io.File;

public class FileExplorer {
    public static String showPathFile(File path, int level) {
        File[] files = path.listFiles();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
            sb.append("\t".repeat(level));
            sb.append(files[i].getName() + "\n");
            if (files[i].isDirectory()) {
                sb.append(showPathFile(files[i], level + 1));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String actualDir = System.getProperty("user.dir");
        File file = new File(actualDir);
        System.out.println(showPathFile(file, 0));
    }
}