package jedi.commands;

import java.util.*;

public class CommandFactory {
    private List<String> commandInfo;
    private Map<String,Command> possibleCommands;

    public CommandFactory(List<String> commandInfo) throws IndexOutOfBoundsException,NullPointerException,IllegalArgumentException,CommandException {
            this.commandInfo = commandInfo;
            this.possibleCommands = new HashMap<>();
            if(commandInfo.size()==1){
                possibleCommands.put("close",new CloseCommand());
                possibleCommands.put("help",new HelpCommand());
                possibleCommands.put("save",new SaveCommand());
            }
            else if(commandInfo.size()==2){
                possibleCommands.put("add_planet",new AddPlanetCommand(commandInfo.get(1)));
                possibleCommands.put("get_strongest_jedi",new GetStrongestJediCommand(commandInfo.get(1)));
                possibleCommands.put("open",new OpenCommand(commandInfo.get(1)));
                possibleCommands.put("print_jedi",new PrintJediCommand(commandInfo.get(1)));
                possibleCommands.put("print_planet",new PrintPlanetCommand(commandInfo.get(1)));
                possibleCommands.put("saveas",new SaveAsCommand(commandInfo.get(1)));
                possibleCommands.put("get_most_used_saber_color",new GetMostUsedSaberColorCommand(commandInfo.get(1)));
            }
            else if(commandInfo.size()==3){
                possibleCommands.put("demote_jedi",new DemoteJediCommand(commandInfo.get(1),commandInfo.get(2)));
                possibleCommands.put("get_most_used_saber_color",new GetMostUsedSaberColorCommand(commandInfo.get(1),commandInfo.get(2)));
                possibleCommands.put("get_youngest_jedi",new GetYoungestJediCommand(commandInfo.get(1), commandInfo.get(2)));
                possibleCommands.put("promote_jedi",new PromoteJediCommand(commandInfo.get(1),commandInfo.get(2)));
                possibleCommands.put("remove_jedi",new RemoveJediCommand(commandInfo.get(1),commandInfo.get(2)));
                possibleCommands.put("+",new PrintTwoPlanetsCommand(commandInfo.getFirst(),commandInfo.get(2)));
            }
            else if(commandInfo.size()==7) {
                possibleCommands.put("create_jedi",new CreateJediCommand(commandInfo.get(1),commandInfo.get(2),commandInfo.get(3),commandInfo.get(4),commandInfo.get(5),commandInfo.get(6)));
            }
            else {
                throw new CommandException("Invalid number of command parameters!");
            }
    }

    public Command create() throws CommandException{
        if(possibleCommands.containsKey(commandInfo.getFirst())) {
            return possibleCommands.get(commandInfo.getFirst());
        }
        else if(possibleCommands.containsKey(commandInfo.get(1))){
            return possibleCommands.get("+");
        }
        else {
            throw new CommandException("Command doesn't exist!");
        }
    }
}