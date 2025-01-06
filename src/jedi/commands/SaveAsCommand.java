package jedi.commands;

import jedi.core.Galaxy;

public class SaveAsCommand implements Command{
    private String containingFile;

    public SaveAsCommand(String containingFile) {
        this.containingFile = containingFile;
    }

    @Override
    public void execute(Galaxy galaxy) {

    }
}