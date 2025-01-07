package jedi.commands;

import jedi.core.Galaxy;

public class HelpCommand implements Command {

    @Override
    public void execute(Galaxy galaxy) {
        System.out.println("""
                The following commands are supported:
                open <file>    opens file
                help     prints this information
                exit     exists the program""");
        if(galaxy.getContainingFile()!=null){
            System.out.println("""
                close    closes currently opened file
                save     saves the currently open file
                saveas   <file> saves the currently open file in <file>
                add_planet <planet_name>    adds new planet
                create_jedi <planet_name> <jedi_name> <jedi_rank> <jedi_age> <saber_color> <jedi_strength>    creates jedi with specified parameters, if possible
                remove_jedi <jedi_name> <planet_name>    removes the specified jedi
                promote_jedi <jedi_name> <multiplier>     promotes jedi by one rank and increases their strength. multiplier must be positive, grand_master is the highest rank
                demote_jedi <jedi_name> <multiplier>   demotes jedi by one rank and lowers their strength. multiplier must be positive, youngling is the lowest rank
                get_strongest_jedi <planet_name>     gives information about the strongest jedi on a given planet
                get_youngest_jedi <planet_name> <jedi_rank>     gives information about the youngest jedi on a given planet of a given rank, if one exists
                get_most_used_saber_color <planet_name> <jedi_rank>     gives information about the most used saber color by a given rank on a given planet
                get_most_used_saber_color <planet_name>     gives information about the most used saber color on a given planet. the saber color must be used by at least one grand_master
                print_planet <planet_name>     gives information about a planet
                print_jedi <jedi_name>     gives information about a jedi
                <planet_name> + <planet_name>     gives information about two planets""");
        }
    }
}