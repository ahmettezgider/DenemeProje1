package OrangeHRM;

public enum MenuLinks {
    ProjectReports ("Time", "Reports", "Project Reports"),
    JobTitles ("Admin", "Job", "Job Titles"),
    Admin("Admin"),
    Candidates("Recruitment", "Candidates")
    ;


    String[] items;
    MenuLinks(String...items) {
        this.items = items;
    }

    public int length(){
        return items.length;
    }

    public String get(int index){
        return items[index];
    }
}
