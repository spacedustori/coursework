package jedi.core;

import java.util.*;
import java.util.function.Predicate;

public class Planet {
    private String name;
    private Set<Jedi> jedis = new HashSet<>();

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Jedi> getJedis() {
        return jedis;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet planet)) return false;

        return Objects.equals(getName(), planet.getName()) && Objects.equals(jedis, planet.jedis);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getName());
        result = 31 * result + Objects.hashCode(jedis);
        return result;
    }

    public boolean addJedi(Jedi jedi) {
        return jedis.add(jedi);
    }

    public boolean removeJedi(Jedi jedi){
        return jedis.remove(jedi);
    }

    public String toString() {
        List<Jedi> sortedList = new ArrayList<>(jedis);
        sortedList.sort(null);
        Iterator<Jedi> iterator = sortedList.iterator();
        StringBuilder sb = new StringBuilder("Planet ").append(name).append(":\n");
        while (iterator.hasNext()){
            sb.append(iterator.next().toString());
        }
        return sb.toString();
    }

    public String print() {
        List<Jedi> sortedList = new ArrayList<>(jedis);
        sortedList.sort(new NameAndRankComparator());
        Iterator<Jedi> iterator = sortedList.iterator();
        StringBuilder sb = new StringBuilder("Planet ").append(name).append(":\n");
        while (iterator.hasNext()){
            sb.append(iterator.next().toString());
        }
        return sb.toString();
    }

    public Jedi getStrongestJedi() throws PlanetException{
        if(jedis.isEmpty()){
            throw new PlanetException("There are no jedi on this planet!");
        }
        List<Jedi> jediList = new ArrayList<>(jedis);
        jediList.sort(new PowerComparator());
        Iterator<Jedi> it = jediList.iterator();
        return it.next();
    }

    public Jedi getYoungestJedi(Rank rank) throws PlanetException{
        List<Jedi> sortedList = new ArrayList<>();
        Iterator<Jedi> iterator = jedis.iterator();
        while (iterator.hasNext()){
            Jedi currentJedi = iterator.next();
            if(currentJedi.getRank()==rank){
                sortedList.add(currentJedi);
            }
        }
        if(sortedList.isEmpty()){
            throw new PlanetException("There are no Jedi with this rank on the given planet!");
        }
        sortedList.sort(new AgeComparator().reversed());
        iterator=sortedList.iterator();
        return iterator.next();
    }

    private String countColor(List<Jedi> rankList){
        Iterator<Jedi> iterator = rankList.iterator();
        Map<String, Integer> countColors = new HashMap<>();
        while (iterator.hasNext()){
            countColors.put(iterator.next().getColor(),0);
        }
        iterator = jedis.iterator();
        while (iterator.hasNext()){
            String currentColor = iterator.next().getColor();
            if (countColors.containsKey(currentColor)){
                Integer count = countColors.get(currentColor);
                countColors.replace(currentColor,count+1);
            }
        }
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(countColors.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        return entryList.getFirst().toString();
    }

    public String getMostUsedSaberColor() throws PlanetException{
        if(jedis.isEmpty()){
            throw new PlanetException("There are no jedi on this planet!");
        }
        List<Jedi> rankList = new ArrayList<>(jedis);
        Predicate<Jedi> rankRequirement = (i) -> i.getRank() != Rank.GRAND_MASTER;
        rankList.removeIf(rankRequirement);
        if(rankList.isEmpty()){
            throw new PlanetException("There are no grand master jedi on this planet!");
        }
        return countColor(rankList);
    }

    public String getMostUsedSaberColor(Rank rank){
        if(jedis.isEmpty()){
            throw new PlanetException("There are no jedi on this planet!");
        }
        List<Jedi> rankList = new ArrayList<>(jedis);
        Predicate<Jedi> rankRequirement = (i) -> i.getRank() !=rank;
        rankList.removeIf(rankRequirement);
        if(rankList.isEmpty()){
            throw new PlanetException("There are no jedi of the given rank on this planet!");
        }
        return countColor(rankList);
    }
}