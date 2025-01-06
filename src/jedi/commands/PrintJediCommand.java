package jedi.commands;

import jedi.core.Galaxy;

public class PrintJediCommand implements Command {
    private String jediName;

    public PrintJediCommand(String jediName) {
        this.jediName = jediName;
    }

    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()!=null){

        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}
