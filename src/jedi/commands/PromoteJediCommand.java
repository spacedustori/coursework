package jedi.commands;

import jedi.core.Galaxy;
import jedi.core.JediException;
import jedi.core.RankException;

public class PromoteJediCommand implements Command {
    private String jediName;
    private String multiplier;

    public PromoteJediCommand(String jediName, String multiplier) throws IllegalArgumentException {
        this.jediName = jediName;
        this.multiplier = multiplier;
    }

    @Override
    public void execute(Galaxy galaxy) throws RankException, JediException,CommandException {
        if(galaxy.getContainingFile()!=null){
            double multiplier = Double.parseDouble(this.multiplier);
            galaxy.promoteJedi(jediName,multiplier);
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}
