package com.example;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DTOGenerator {

    public static void dtoGenerator(String className, String[] primaryKeys) {

        StringBuilder importStatement = new StringBuilder();
        importStatement.append("package com.marutisuzuki.dto;");
        importStatement.append("\n");

        createDefaultImport(importStatement);

        StringBuilder classDeclaration = createClassDeclaration(className);
//        StringBuilder fieldDeclarations = CommonUtility.readFileFromCSV(importStatement, false,false,primaryKeys);
//        fieldDeclarations.append("private BigDecimal qlikSequenceNumber;");

        //Write class
        writeJavaFile(className + "DTO.java", importStatement, classDeclaration);
    }

    private static StringBuilder createClassDeclaration(String className) {

        StringBuilder classDeclarations = new StringBuilder();

        classDeclarations.append("\n");
        classDeclarations.append("@Data");
        classDeclarations.append("\n");
        classDeclarations.append("@NoArgsConstructor");
        classDeclarations.append("\n");
        classDeclarations.append("@AllArgsConstructor");
        classDeclarations.append("\n");
        classDeclarations.append("public class " + className + "DTO extends BaseDTO {");
        classDeclarations.append("\n");
        classDeclarations.append("\n");
        classDeclarations.append("private String id;");
        classDeclarations.append("\n");

        return classDeclarations;
    }

    private static String createDefaultImport(StringBuilder importStatement) {
        importStatement.append("\n");
        importStatement.append("import lombok.Data;");
        importStatement.append("\n");
        importStatement.append("import lombok.NoArgsConstructor;");
        importStatement.append("\n");
        importStatement.append("import com.marutisuzuki.partmaster.dto.base.BaseDTO;");
        importStatement.append("\n");
        importStatement.append("import lombok.AllArgsConstructor;");
        importStatement.append("\n");

        return importStatement.toString();
    }

    public static void writeJavaFile(String fileName, StringBuilder importStatment, StringBuilder classDeclaration) {
        File file = new File("C:\\D\\Learning\\yorker-backend\\src\\main\\java\\com\\yorker\\backend\\dto" + fileName);

//        importStatment.append(classDeclaration).append(fieldsDeclaration).append("\n" + "}");

        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            //convert string to byte array
            byte[] bytes = importStatment.toString().getBytes();
            //write byte array to file
            bos.write(bytes);
            bos.close();
            fos.close();
            System.out.print("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
