package ext.template.genertor;


import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

public class TemplateGenerator {

    public static void main(String[] args) {
        try {
            Configuration configuration = new TemplateGenerator().getConfiguration("entity.ftl");
            System.out.println(configuration + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Configuration getConfiguration(String probingTemplate) throws IOException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_23);
        config.setClassForTemplateLoading(getClass(), "/");
        config.setDefaultEncoding("UTF-8");
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        try {
            config.getTemplate(probingTemplate);
        } catch (TemplateNotFoundException e) {
            File dir = new File("src/main/resources/");
            if (!dir.exists()) {
                dir = new File("template-generator/src/main/resources/");
            }
            if (dir.exists() && new File(dir, probingTemplate).exists()) {
                config.setDirectoryForTemplateLoading(dir);
                config.getTemplate(probingTemplate);
            } else {
                throw e;
            }
        }
        return config;
    }
}
