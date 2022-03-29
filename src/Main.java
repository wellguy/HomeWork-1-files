import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String targetDir = "F://java/JavaCore/Games";
        File dirGames = new File(targetDir);
        dirGames.mkdir();

        StringBuilder sb = new StringBuilder();

        String dirList[] = new String[]{"src", "res", "savegames", "temp"};
        sb.append(makeDirectory(targetDir, dirList));

        String dirList2[] = new String[]{"main", "test"};
        sb.append(makeDirectory(targetDir + "/src", dirList2));

        String dirList3[] = new String[]{"drawables", "vectors", "icons"};
        sb.append(makeDirectory(targetDir + "/res", dirList3));

        String fileList1[] = new String[]{"Main.java", "Utils.java"};
        sb.append(makeFile(targetDir + "/res/", fileList1));

        String report = sb.toString();
        System.out.println(report);

        File temp = new File(targetDir + "/temp/temp.txt");
        try {
            temp.createNewFile();
        } catch (IOException e) {
            System.out.println("Файл не создан");
        }

        try (FileWriter text = new FileWriter(targetDir + "/temp/temp.txt")) {
            text.write(report);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String makeDirectory(String mainDir, String[] dirList) {
        StringBuilder sb = new StringBuilder();
        for (String dir : dirList) {
            File newDir = new File(mainDir + "/" + dir);
            if (newDir.mkdir()) {
                sb.append("Каталог " + mainDir + "/" + dir + " создан" + "\n");
            } else {
                sb.append("Каталог " + mainDir + "/" + dir + " не создан" + "\n");
            }
        }
        return sb.toString();
    }

    public static String makeFile(String mainDir, String[] fileList) {
        StringBuilder sb = new StringBuilder();
        for (String file : fileList) {
            File newFile = new File(mainDir + file);
            try {
                if (newFile.createNewFile()) {
                    sb.append("Файл " + file + " создан" + "\n");
                } else {
                    sb.append("Файл " + file + " не создан" + "\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return sb.toString();
    }
}
