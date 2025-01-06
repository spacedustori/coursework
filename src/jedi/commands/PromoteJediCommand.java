package jedi.commands;

import jedi.core.Galaxy;

public class PromoteJediCommand implements Command {
    private String jediName;
    private double multiplier;

    public PromoteJediCommand(String jediName, String multiplier) throws IllegalArgumentException {
        this.jediName = jediName;
        this.multiplier = Double.parseDouble(multiplier);
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
