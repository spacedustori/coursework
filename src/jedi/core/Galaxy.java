package jedi.core;

import java.util.*;

public class Galaxy {
    private String containingFile;
    private List<Planet> planets;

    public Galaxy(String containingFile) {
        this.containingFile = containingFile;
        planets = new ArrayList<>();
    }

    public String getContainingFile() {
        return containingFile;
    }

    public void setContainingFile(String containingFile) {
        this.containingFile = containingFile;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void addPlanet(String planetName){
        planets.add(new Planet(planetName));
    }

    public String print(Planet planetA,Planet planetB){
        return planetA.toString() + "/n/n" + planetB.toString();
    }

    public boolean createJedi(String planetName,String jediName,Rank jediRank,int age,String color,double strength){
        for (Planet currentPlanet : planets) {
            if (currentPlanet.getName().equals(planetName)) {
                return currentPlanet.addJedi(new Jedi(jediName, jediRank, age, color, strength));
            }
        }
        return false;
    }

    public boolean removeJedi(String jediName,String planetName){
        Jedi toBeRemoved = new Jedi(jediName);
        for (Planet currentPlanet : planets) {
            if (currentPlanet.getName().equals(planetName)) {
                if (currentPlanet.getJedis().contains(toBeRemoved)){
                    return currentPlanet.removeJedi(toBeRemoved);
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
}