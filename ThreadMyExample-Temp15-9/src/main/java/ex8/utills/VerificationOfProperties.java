package ex8.utills;

import ex8.view.FrameSelector;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * Данный класс проверяет файл:
 * 1)Есть ли этот файл вообще
 * 2)Какие свойства у этого файла
 */
public class VerificationOfProperties {

    public static void toCheck(String fileName) throws SQLException, IOException, ClassNotFoundException {
        Boolean existFile = false;

        File file = new File(fileName);
        existFile = file.exists();

        if (existFile) {
            Path path = Paths.get(fileName);

            try {
                if (!Files.isReadable(path)){
                    System.out.println("Файл защищен от чтения");
                }
                if (!Files.isWritable(path)){
                    System.out.println("Файл защищен от записи");
                }
                if (!Files.isExecutable(path)){
                    System.out.println("Файл защищен от выполнения");
                }
            }  catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Файл не найден");
            FrameSelector.getInstance().getFrame("Frame2");
        }
    }
}