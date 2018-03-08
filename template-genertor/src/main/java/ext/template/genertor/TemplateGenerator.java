package ext.template.genertor;


import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

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
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("template not found entity.ftl");
        }
        return config;
    }
}
