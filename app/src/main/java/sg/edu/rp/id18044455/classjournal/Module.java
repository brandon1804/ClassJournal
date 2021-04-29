package sg.edu.rp.id18044455.classjournal;

public class Module {

    private String moduleCode;
    private String moduleName;
    private String url;


    public Module(String moduleCode, String moduleName, String url) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.url = url;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}//end of class
