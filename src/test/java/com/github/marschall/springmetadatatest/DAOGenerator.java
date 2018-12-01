package com.github.marschall.springmetadatatest;

import static java.nio.charset.StandardCharsets.US_ASCII;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DAOGenerator {

  public static void main(String[] args) throws IOException {
    Path outputFolder = Paths.get("src/main/java/com/github/marschall/springmetadatatest/generated");
//    for (int i = 1; i < 1000; i++) {
//      generateDao(outputFolder, i);
//    }
    generateConfiguration(outputFolder, 0, 1000);
//    generateInitializerWithBeanDefinition(outputFolder, 0, 1000);
//    generateInitializerWithSupplier(outputFolder, 0, 1000);
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
  
  private static void generateConfiguration(Path folder, int start, int end) throws IOException {
    String className = "GeneratedConfiguration";
    String fileName = className + ".java";
    Path sourceFile = folder.resolve(fileName);
    try (Writer writer = Files.newBufferedWriter(sourceFile, US_ASCII, CREATE, TRUNCATE_EXISTING)) {
      writer.append("package com.github.marschall.springmetadatatest.generated;\n");
      writer.append("\n");
      writer.append("//@Configuration\n");
      writer.append("public final class ").append(className).append(" {\n");
      writer.append("\n");
      writer.append("  //@Autowired\n");
      writer.append("  private Object jdbcTemplate;\n");
      writer.append("\n");
      for (int i = start; i < end; i++) {
        writer.append("  //@Bean\n");
        String beanClassName = generateName(i);
        writer.append("  public ").append(beanClassName).append(" dao").append(Integer.toString(i)).append("() {\n");
        writer.append("    return new ").append(beanClassName).append("(this.jdbcTemplate);\n");
        writer.append("  }\n");
        writer.append("\n");
      }
      writer.append("}\n");
      writer.append("\n");
    }
  }
  
  private static void generateInitializerWithSupplier(Path folder, int start, int end) throws IOException {
    String className = "InitializerWithSupplier";
    String fileName = className + ".java";
    Path sourceFile = folder.resolve(fileName);
    try (Writer writer = Files.newBufferedWriter(sourceFile, US_ASCII, CREATE, TRUNCATE_EXISTING)) {
      
    }
  }
  
  private static void generateInitializerWithBeanDefinition(Path folder, int start, int end) throws IOException {
    String className = "InitializerWithBeanDefinition";
    String fileName = className + ".java";
    Path sourceFile = folder.resolve(fileName);
    try (Writer writer = Files.newBufferedWriter(sourceFile, US_ASCII, CREATE, TRUNCATE_EXISTING)) {
      
    }
  }
  
  private static String generateName(int index) {
    return "Generated"  + index + "DAO";
  }

}
