package jedi.core;

import java.util.Objects;

public class Jedi implements Comparable<Jedi> {
    private String name;
    private Rank rank;
    private int age;
    private String color;
    private double power;
    private String currentPlanet;
    private static final String newLine = System.lineSeparator();

    public Jedi(String name, Rank rank, int age, String color, double power) {
        this.name = name;
        this.rank = rank;
        this.age = age;
        this.color = color;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public double getPower() {
        return power;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setCurrentPlanet(String currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jedi jedi)) return false;

        return Objects.equals(name, jedi.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public void promoteJedi(double multiplier) throws RankException,JediException{
            this.setRank(getRank().next());
            if(multiplier<=0){
                throw new JediException("Power multiplier must be a positive number!");
            }
            double raisedPower = getPower();
            raisedPower+=power*multiplier;
            setPower(raisedPower);
        }

    public void demoteJedi(double multiplier) throws RankException,JediException{
            this.setRank(getRank().previous());
            if(multiplier<=0){
            throw new JediException("Power multiplier must be a positive number!");
            }
            double loweredPower = getPower();
            loweredPower-=power*multiplier;
            setPower(loweredPower);
    }

    @Override
    public String toString() {
        return "name -> " + name +", rank -> " + rank + ", age -> " + age + ',' + newLine
                + "power = " + power+ ", saber color -> " + color + ", currently on "+currentPlanet;
    }

    @Override
    public int compareTo(Jedi o) {
        return this.name.compareTo(o.name);
    }
}