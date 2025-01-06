package jedi.commands;

import jedi.core.*;
import java.io.*;
import java.util.*;

public class SaveCommand implements Command {

    @Override
    public void execute(Galaxy galaxy) {
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
        } catch (IOException e) {
            System.out.println("An error has occurred.");
        }
    }
}
