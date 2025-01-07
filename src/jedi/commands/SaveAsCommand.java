package jedi.commands;

import jedi.core.Galaxy;
import jedi.core.Jedi;
import jedi.core.Planet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class SaveAsCommand implements Command{
    private String containingFile;

    public SaveAsCommand(String containingFile) {
        this.containingFile = containingFile;
    }

    @Override
    public void execute(Galaxy galaxy) {
        String newLine = System.lineSeparator();
        List<Planet> planets = galaxy.getPlanets();
        try {
            File newFile = new File(containingFile);
            if(!newFile.createNewFile()){
                System.out.println("This file already exists in the given directory. Please rename it or pick a different path.");
            }
            else {
                galaxy.setContainingFile(containingFile);
                FileWriter writer = new FileWriter(newFile);
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
            }
            System.out.println("The file has been saved successfully!");
        } catch (IOException e) {
            System.out.println("An error has occurred.");
        }
    }
}