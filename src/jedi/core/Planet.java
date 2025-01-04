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

    public boolean addJedi(Jedi jedi) {
        return jedis.add(jedi);
    }

    public boolean removeJedi(Jedi jedi){
        return jedis.remove(jedi);
    }

    @Override
    public String toString() {
        List<Jedi> sortedList = new ArrayList<>(jedis);
        sortedList.sort(new NameAndRankComparator());
        Iterator<Jedi> iterator = sortedList.iterator();
        StringBuilder sb = new StringBuilder("Planet ").append(name).append(":\n");
        while (iterator.hasNext()){
            sb.append(iterator.next().toString());
        }
        return sb.toString();
    }

    public Jedi getStrongestJedi(){
        List<Jedi> jediList = new ArrayList<>(jedis);
        jediList.sort(new PowerComparator());
        Iterator<Jedi> it = jediList.iterator();
        return it.next();
    }

    public Jedi getYoungestJedi(Rank rank){
        List<Jedi> sortedList = new ArrayList<>();
        Iterator<Jedi> iterator = jedis.iterator();
        while (iterator.hasNext()){
            Jedi currentJedi = iterator.next();
            if(currentJedi.getRank()==rank){
                sortedList.add(currentJedi);
            }
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

    public String getMostUsedSaberColor(){
        List<Jedi> rankList = new ArrayList<>(jedis);
        Predicate<Jedi> rankRequirement = (i) -> i.getRank() != Rank.GRAND_MASTER;
        rankList.removeIf(rankRequirement);
        return countColor(rankList);
    }

    public String getMostUsedSaberColor(Rank rank){
        List<Jedi> rankList = new ArrayList<>(jedis);
        Predicate<Jedi> rankRequirement = (i) -> i.getRank() !=rank;
        rankList.removeIf(rankRequirement);
        return countColor(rankList);
    }
}