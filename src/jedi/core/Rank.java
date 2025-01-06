package jedi.core;

public enum Rank {
    YOUNGLING,INITIATE,PADAWAN,KNIGHT_ASPIRANT,KNIGHT,MASTER,BATTLE_MASTER,GRAND_MASTER;

    private static final Rank[] values = values();

    public Rank next() throws RankException{
        if(this==GRAND_MASTER){
            throw new RankException("The jedi is the highest possible rank!");
        }
        return values[(this.ordinal()+1)%values.length];
    }

    public Rank previous() throws RankException{
        if(this==YOUNGLING){
            throw new RankException("The jedi is the lowest possible rank!");
        }
        return values[(this.ordinal()-1+values.length)%values.length];
    }
}