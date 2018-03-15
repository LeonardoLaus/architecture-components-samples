package ${entity.javaPackage};

/**
 * @author ${entity.author}
 */
public class ${entity.className}
<#if entity.superclass?has_content> extends ${entity.superclass}</#if>
<#if entity.interfacesToImpl?has_content> implements <#list entity.interfacesToImpl as inf>${inf}<#if inf_has_next>, </#if></#list></#if>{
    <#list entity.attrs as attr>
    private ${attr.type} ${attr.name};
    </#list>

    <#list entity.attrs as attr>
    public void set${attr.name?cap_first}(${attr.type} ${attr.name}) {
        this.${attr.name} = ${attr.name};
    }

    public ${attr.type} get${attr.name?cap_first}(){
        return this.${attr.name};
    }
    </#list>
}