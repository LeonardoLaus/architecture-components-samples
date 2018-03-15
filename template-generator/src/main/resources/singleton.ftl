package ${entity.javaPackage};

/**
 * @author ${entity.author}
 */
public class ${entity.className}
<#if entity.superclass?has_content> extends ${entity.superclass}</#if>
<#if entity.interfacesToImpl?has_content> implements <#list entity.interfacesToImpl as inf>${inf}<#if inf_has_next>, </#if></#list></#if>{

    private static volatile ${entity.className} _instance;

    public static ${entity.className} get() {
        if (_instance == null) {
            synchronized (${entity.className.class}) {
                if (_instance == null) {
                    _instance = new ${entity.className}();
                }
            }
        }
        return _instance;
    }

    private ${entity.className}() {
        //TODO: init attrs
    }
}