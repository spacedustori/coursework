package jedi.commands;

import jedi.core.Galaxy;

public class CloseCommand implements Command {
    @Override
    public void execute(Galaxy galaxy) {
        galaxy.setContainingFile(null);
        galaxy.getPlanets().clear();
    }
}