package ext.template.genertor;


import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

/**
 * Created by roothost on 2018/3/8.
 */

public class TemplateGenerator {

    public static void main(String[] args) {
        new TemplateGenerator().getConfiguration();
    }

    private Configuration getConfiguration() {
        Configuration config = new Configuration(Configuration.VERSION_2_3_23);
        config.setClassForTemplateLoading(getClass(), "/");
        config.setDefaultEncoding("UTF-8");
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        try {
            config.getTemplate("entity.ftl");
        }catch (TemplateNotFoundException e) {
            e.printStackTrace();
            File dir = new File("src/main/resources/");
            System.out.println("" + dir.exists());
            System.out.println("template not found entity.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}
