package jedi.core;

public enum Rank {
    YOUNGLING,INITIATE,PADAWAN,KNIGHT_ASPIRANT,KNIGHT,MASTER,BATTLE_MASTER,GRAND_MASTER;

    private static final Rank[] values = values();

    public Rank next(){
        return values[(this.ordinal()+1)%values.length];
    }

    public Rank previous(){
        return values[(this.ordinal()-1+values.length)%values.length];
    }
}