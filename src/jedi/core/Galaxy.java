package jedi.core;

import java.util.*;

public class Galaxy {
    private String containingFile;
    private List<Planet> planets;
    private static final String newLine = System.lineSeparator();

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

    private Planet findPlanet(String planetName)throws PlanetMissingException{
        for (Planet currentPlanet : planets) {
            if (currentPlanet.getName().equals(planetName)) {
                return currentPlanet;
            }
        }
        throw new PlanetMissingException("Planet not found!");
    }

    private Jedi findJedi(String jediName) throws JediMissingException{
        for(Planet p:planets) {
            for (Jedi j : p.getJedis()) {
                if (j.getName().equals(jediName)) {
                    return j;
                }
            }
        }
        throw new JediMissingException("This jedi is not a part of this galaxy!");
    }

    public boolean createJedi(String planetName,String jediName,Rank jediRank,int age,String color,double strength) throws PlanetMissingException{
        Planet currentPlanet = findPlanet(planetName);
        Jedi jedi = new Jedi(jediName, jediRank, age, color, strength);
        for (Planet p:planets){
            if(p.getJedis().contains(jedi)){
                return false;
            }
        }
        jedi.setCurrentPlanet(currentPlanet.getName());
        return currentPlanet.addJedi(jedi);
    }

    public boolean removeJedi(String jediName,String planetName) throws PlanetMissingException,JediMissingException{
        Planet currentPlanet = findPlanet(planetName);
        Jedi toBeRemoved = currentPlanet.findJedi(jediName);
        return currentPlanet.removeJedi(toBeRemoved);
    }

    public void promoteJedi(String jediName,double multiplier) throws RankException,JediException,JediMissingException{
        Jedi jedi = findJedi(jediName);
        jedi.promoteJedi(multiplier);
        System.out.println("Jedi "+jediName+" has been promoted to rank "+jedi.getRank().toString().toLowerCase()+"!");
    }

    public void demoteJedi(String jediName,double multiplier) throws RankException,JediException,JediMissingException{
        Jedi jedi = findJedi(jediName);
        jedi.demoteJedi(multiplier);
        System.out.println("Jedi "+jediName+" has been demoted to rank "+jedi.getRank().toString().toLowerCase()+"!");
    }

    public String getStrongestJedi(String planetName) throws PlanetMissingException{
        Planet currentPlanet = findPlanet(planetName);
        return currentPlanet.getStrongestJedi();
    }

    public String getYoungestJedi(String planetName,Rank rank) throws PlanetMissingException {
        Planet currentPlanet = findPlanet(planetName);
        Jedi jedi = currentPlanet.getYoungestJedi(rank);
        return jedi.toString();
    }

    public String getMostUsedSaberColor(String planetName) throws PlanetMissingException,JediMissingException{
        Planet currentPlanet = findPlanet(planetName);
        return currentPlanet.getMostUsedSaberColor();
    }

    public String getMostUsedSaberColor(String planetName,Rank rank) throws PlanetMissingException,JediMissingException{
        Planet currentPlanet = findPlanet(planetName);
        return currentPlanet.getMostUsedSaberColor(rank);
    }

    public String printPlanet(String planetName){
        Planet currentPlanet = findPlanet(planetName);
        return currentPlanet.print();
    }

    public String printJedi(String jediName){
        return findJedi(jediName).toString();
    }

    public String print(String planetNameA,String planetNameB){
        Planet planetA = findPlanet(planetNameA);
        Planet planetB = findPlanet(planetNameB);
        return planetA + newLine + planetB;
    }
}