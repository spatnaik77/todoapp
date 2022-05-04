package com.sidd.todoapp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public class TodoItem 
{
    private @Getter @Setter String id;
    private @Getter @Setter String description;
    private @Getter @Setter String owner;
    private @Getter @Setter boolean finished;

    /*public TodoItem() {
    }*/

    public TodoItem(String id, String description, String owner) {
        this.description = description;
        this.id = id;
        this.owner = owner;
        this.finished = false;
    }

    /*public boolean isFinished() {
        return finished;
    }

    public void setFinish(boolean finished) {
        this.finished = finished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }*/

}