package com.github.marschall.springmetadatatest;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import static java.nio.file.StandardOpenOption.*;

import static java.nio.charset.StandardCharsets.US_ASCII;

public class DAOGenerator {

  public static void main(String[] args) throws IOException {
    Path outputFolder = Paths.get("src/main/java/com/github/marschall/springmetadatatest/generated");
    for (int i = 1; i < 1000; i++) {
      generateDao(outputFolder, i);
    }
  }
  
  private static void generateDao(Path folder, int index) throws IOException {
    String className = generateName(index);
    String fileName = className + ".java";
    Path sourceFile = folder.resolve(fileName);
    try (Writer writer = Files.newBufferedWriter(sourceFile, US_ASCII, CREATE, TRUNCATE_EXISTING)) {
      writer.append("package com.github.marschall.springmetadatatest.generated;\n");
      writer.append("\n");
      writer.append("import com.github.marschall.springmetadatatest.AbstractDAO;\n");
      writer.append("\n");
      writer.append("//@Repository\n");
      writer.append("//@Generated\n");
      writer.append("public final class ").append(className).append(" extends AbstractDAO {\n");
      writer.append("\n");
      writer.append("  //@Autowired\n");
      writer.append("  public ").append(className).append("(Object jdbcTemplate) {\n");
      writer.append("    super(jdbcTemplate);\n");
      writer.append("  }\n");
      writer.append("\n");
      writer.append("}\n");
      writer.append("\n");
    }
  }
  
  private static String generateName(int index) {
    return "Generated"  + index + "DAO";
  }

}
