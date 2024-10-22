package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public String toString() {
        switch(this){
            case NORTH -> {
                return "Polnoc";
            }
            case EAST -> {
                return "Wschod";
            }
            case SOUTH -> {
                return "Poludnie";
            }
            case WEST -> {
                return "Zachod";
            }
        }
        return "Bledne dane";
    }

    public MapDirection next(){
        switch(this){
            case NORTH -> {
                return MapDirection.EAST;
            }
            case EAST -> {
                return MapDirection.SOUTH;
            }
            case SOUTH -> {
                return MapDirection.WEST;
            }
            case WEST -> {
                return MapDirection.NORTH;
            }
        }
        return null;
    }

    public MapDirection previous(){
        switch(this){
            case NORTH -> {
                return MapDirection.WEST;
            }
            case EAST -> {
                return MapDirection.NORTH;
            }
            case SOUTH -> {
                return MapDirection.EAST;
            }
            case WEST -> {
                return MapDirection.SOUTH;
            }
        }
        return null;
    }

    public Vector2d toUnitVector(){
        switch(this){
            case NORTH -> {
                return new Vector2d(0,1);
            }
            case EAST -> {
                return new Vector2d(1,0);
            }
            case SOUTH -> {
                return new Vector2d(0,-1);
            }
            case WEST -> {
                return new Vector2d(-1,0);
            }
        }
        return null;
    }
}








