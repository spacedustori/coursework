package jedi.commands;

import jedi.core.*;
import java.io.*;
import java.util.*;

public class SaveCommand implements Command {

    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()!=null){
            String newLine = System.lineSeparator();
            List<Planet> planets = galaxy.getPlanets();
            try {
                FileWriter writer = new FileWriter(galaxy.getContainingFile());
                for (Planet p:planets){
                    Set<Jedi> jedis = p.getJedis();
                    writer.write(p.getName()+newLine);
                    for (Jedi j:jedis){
                        writer.write(j.getName()+newLine);
                        writer.write(j.getRank().toString()+newLine);
                        writer.write(j.getAge()+newLine);
                        writer.write(j.getColor()+newLine);
                        writer.write(j.getPower()+newLine);
                    }
                    writer.write("-"+newLine);
                }
                writer.close();
                System.out.println("The file has been saved successfully!");
            } catch (IOException e) {
                System.out.println("An error has occurred.");
            }
        }
        else {
            throw new CommandException("This command is currently unavailable.");
        }
    }
}
