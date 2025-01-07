package jedi.commands;

import jedi.core.*;

import java.io.*;
import java.util.Scanner;

public class OpenCommand implements Command {
    private String filePath;

    public OpenCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute(Galaxy galaxy) {
        if(galaxy.getContainingFile()==null){
            try {
                File currentFile = new File(filePath);
                galaxy.setContainingFile(filePath);
                if(currentFile.createNewFile()){
                    System.out.println("New file has been created. Please add planets and jedi to your new galaxy.");
                }
                else {
                    Scanner scanner = new Scanner(currentFile);
                    while (scanner.hasNext()){
                        String planetName = scanner.nextLine();
                        galaxy.addPlanet(planetName);
                        String currentLine = scanner.nextLine();
                        while (!currentLine.equals("-")){
                            Rank rank = Rank.valueOf(scanner.nextLine().toUpperCase());
                            int age = Integer.parseInt(scanner.nextLine());
                            String color = scanner.nextLine();
                            double strength = Double.parseDouble(scanner.nextLine());
                            galaxy.createJedi(planetName,currentLine,rank,age,color,strength);
                            currentLine=scanner.nextLine();
                        }
                    }
                    scanner.close();
                    System.out.println("File information has been loaded.");
                }
            } catch (IOException e) {
                System.out.println("An error has occurred.");
            }
        }
        else {
            throw new CommandException("This command is currently unavailable. Please close the currently open file.");
        }

    }
}