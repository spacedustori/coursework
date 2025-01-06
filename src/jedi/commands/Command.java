package jedi.commands;

import jedi.core.Galaxy;

public interface Command {
    void execute(Galaxy galaxy);
}