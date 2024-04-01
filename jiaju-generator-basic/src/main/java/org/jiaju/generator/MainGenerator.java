package org.jiaju.generator;

import freemarker.template.TemplateException;
import org.jiaju.model.MainTemplateConfig;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void doGenerate(Object model) throws TemplateException, IOException{
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath);
        // 输入路径
        String inputPath =
                new File(parentFile,
                        "jiaju-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        // 生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);

        // 生成动态文件
        String inputDynamicFilePath
                = projectPath + File.separator + "jiaju-generator-basic" + File.separator
                + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath =
                outputPath + File.separator
                        + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
}
