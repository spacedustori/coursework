package jedi.commands;

import jedi.core.Galaxy;

public class OpenCommand implements Command {
    private String fileName;

    public OpenCommand(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute(Galaxy galaxy) {

    }
}