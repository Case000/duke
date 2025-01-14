package Task;

import java.util.ArrayList;

/**
 * Stores and creates tasks with description and marking
 * Main class that generate Tasks
 */
public class Task {
    protected String description;
    protected Boolean isMarked;
    protected ArrayList<String> tags;
    public Task(String description){
        this.description = description;
        isMarked = false;
        this.tags = new ArrayList<>();
    }
    public void replaceDescription(String newdescription) {
        this.description = newdescription;
    }
    public String printStatusIcon(){
        String mark = " ";
        if(this.isMarked){
            mark = "X";
        }
        return mark;
    }
    public String getStatus(){
        String mark = "~";
        if(this.isMarked){
            mark = "X";
        }
        return mark;
    }
    public String getDescription(){
        return description;
    }
    public static void setMarked(Task task){
        task.isMarked = true;
    }
    public static void setUnmarked(Task task){
        task.isMarked = false;
    }
    public String getTagSeries(){
        String tagSeries = "";
        for(String tag : this.tags){
            tagSeries += ("#" + tag);
        }
        return tagSeries;
    }
    public String TagString(){
        String tagString = String.join(",", this.tags);
        if(tagString.isEmpty()){
            return "~";
        }
        return tagString;
    }
    public static void addTag(Task task, String tag){
        task.tags.add(tag);
        System.out.println("Tag: #"+ tag +" is added");
    }
    public static void removeTag(Task task, String tag){
        Boolean removed = false;
        for (int i = 0; i < task.tags.size(); i++) {
            if(task.tags.get(i).equals(tag)){
                task.tags.remove(tag);
                removed = true;
                System.out.println("Tag: #"+ tag +" is removed");
            }
        }
            if(!removed){
                System.out.println("The '" + tag + "' tag you are trying to remove is not found, please remove another one!");
            }

    }
}
