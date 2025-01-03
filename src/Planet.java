import java.util.*;

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
}
