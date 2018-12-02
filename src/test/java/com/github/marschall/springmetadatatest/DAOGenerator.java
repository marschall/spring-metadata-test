package com.github.marschall.springmetadatatest;

import static java.nio.charset.StandardCharsets.US_ASCII;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;

import com.github.marschall.springmetadatatest.generated.Generated100DAO;

public class DAOGenerator {

  public static void main(String[] args) throws IOException {
    Path outputFolder = Paths.get("src/main/java/com/github/marschall/springmetadatatest/generated");
//    for (int i = 1; i < 1000; i++) {
//      generateDao(outputFolder, i);
//    }
//    generateConfiguration(outputFolder, 0, 1000);
    generateInitializerWithBeanDefinition(outputFolder, 0, 1000);
//    generateInitializerWithSupplier(outputFolder, 0, 1000);
  }
  
  private static void generateDao(Path folder, int index) throws IOException {
    String className = generateName(index);
    String fileName = className + ".java";
    Path sourceFile = folder.resolve(fileName);
    try (Writer writer = Files.newBufferedWriter(sourceFile, US_ASCII, CREATE, TRUNCATE_EXISTING)) {
      writer.append("package com.github.marschall.springmetadatatest.generated;\n");
      writer.append("\n");
      writer.append("import org.springframework.beans.factory.annotation.Autowired;\n");
      writer.append("import org.springframework.jdbc.core.JdbcOperations;\n");
      writer.append("import org.springframework.stereotype.Repository;\n");
      writer.append("import javax.annotation.Generated;\n");
      writer.append("\n");
      writer.append("import com.github.marschall.springmetadatatest.AbstractDAO;\n");
      writer.append("\n");
      writer.append("@Repository\n");
      writer.append("@Generated(\"").append(DAOGenerator.class.getName()).append("\")\n");
      writer.append("public final class ").append(className).append(" extends AbstractDAO {\n");
      writer.append("\n");
      writer.append("  @Autowired\n");
      writer.append("  public ").append(className).append("(JdbcOperations jdbcTemplate) {\n");
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
      writer.append("import org.springframework.beans.factory.annotation.Autowired;\n");
      writer.append("import org.springframework.context.annotation.Bean;\n");
      writer.append("import org.springframework.context.annotation.Configuration;\n");
      writer.append("import org.springframework.jdbc.core.JdbcOperations;\n");
      writer.append("\n");
      writer.append("@Configuration\n");
      writer.append("public class ").append(className).append(" {\n");
      writer.append("\n");
      writer.append("  @Autowired\n");
      writer.append("  private JdbcOperations jdbcTemplate;\n");
      writer.append("\n");
      for (int i = start; i < end; i++) {
        writer.append("  @Bean\n");
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
    String className = "GeneratedInitializerWithSupplier";
    String fileName = className + ".java";
    Path sourceFile = folder.resolve(fileName);
    try (Writer writer = Files.newBufferedWriter(sourceFile, US_ASCII, CREATE, TRUNCATE_EXISTING)) {
      writer.append("package com.github.marschall.springmetadatatest.generated;\n");
      writer.append("\n");
      writer.append("import org.springframework.context.ApplicationContextInitializer;\n");
      writer.append("import org.springframework.context.support.GenericApplicationContext;\n");
      writer.append("import org.springframework.jdbc.core.JdbcOperations;\n");
      writer.append("\n");
      writer.append("public final class ").append(className).append(" implements ApplicationContextInitializer<GenericApplicationContext> {\n");
      writer.append("\n");
      writer.append("  @Override\n");
      writer.append("  public void initialize(GenericApplicationContext applicationContext) {\n");
      for (int i = start; i < end; i++) {
        String beanClassName = generateName(i);
        writer.append("    applicationContext.registerBean(").append(beanClassName).append(".class, () -> new ").append(beanClassName).append("(applicationContext.getBean(JdbcOperations.class)));\n");
      }
      writer.append("  }\n");
      writer.append("\n");
      writer.append("}\n");
      writer.append("\n");
    }
  }
  
  private static void generateInitializerWithBeanDefinition(Path folder, int start, int end) throws IOException {
    String className = "GeneratedInitializerWithBeanDefinition";
    String fileName = className + ".java";
    Path sourceFile = folder.resolve(fileName);
    try (Writer writer = Files.newBufferedWriter(sourceFile, US_ASCII, CREATE, TRUNCATE_EXISTING)) {
      writer.append("package com.github.marschall.springmetadatatest.generated;\n");
      writer.append("\n");
      writer.append("import org.springframework.beans.factory.config.BeanDefinition;\n");
      writer.append("import org.springframework.beans.factory.support.AbstractBeanDefinition;\n");
      writer.append("import org.springframework.beans.factory.support.BeanDefinitionBuilder;\n");
      writer.append("import org.springframework.context.ApplicationContextInitializer;\n");
      writer.append("import org.springframework.context.support.GenericApplicationContext;\n");
      writer.append("\n");
      writer.append("import com.github.marschall.springmetadatatest.AbstractDAO;\n");
      writer.append("\n");
      writer.append("public final class ").append(className).append(" implements ApplicationContextInitializer<GenericApplicationContext> {\n");
      writer.append("\n");
      writer.append("  @Override\n");
      writer.append("  public void initialize(GenericApplicationContext applicationContext) {\n");
      for (int i = start; i < end; i++) {
        String beanClassName = generateName(i);
        writer.append("    registerBeanDefinition(").append(beanClassName).append(".class, applicationContext);\n");
      }
      writer.append("  }\n");
      writer.append("\n");
      writer.append("  private static void registerBeanDefinition(Class<? extends AbstractDAO> daoClass, GenericApplicationContext applicationContext) {\n");
      writer.append("    AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(daoClass)\n");
      writer.append("      .setScope(BeanDefinition.SCOPE_SINGLETON)\n");
      writer.append("      .setLazyInit(false)\n");
      writer.append("      .setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR)\n");
      writer.append("      .getBeanDefinition();\n");
      writer.append("    applicationContext.registerBeanDefinition(daoClass.getSimpleName(), beanDefinition);\n");
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
