package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.List;

public class TextMap implements WorldNumberPositionMap<String, Integer>{

    private final ArrayList<String> text;

    public TextMap(ArrayList<String> text) {
        this.text = text;
    }

    public ArrayList<String> getText() {
        return text;
    }

    @Override
    public boolean place(String object) {
        text.add(object);
        return true;
    }

    @Override
    public void move(String object, MoveDirection direction) {
        int prevLoc = text.indexOf(object);
        int dir;
        if(direction == MoveDirection.FORWARD || direction == MoveDirection.RIGHT) {
            dir = 1;
        }
        else {
            dir = -1;
        }
        if(canMoveTo(prevLoc+dir)) {
            text.remove(prevLoc);
            text.add(prevLoc+dir, object);
        }
    }

    @Override
    public boolean isOccupied(Integer position) {
        return position >= 0 && position < text.size();
    }

    @Override
    public String objectAt(Integer position) {
        if(position >= 0 && position < text.size()) {
            return text.get(position);
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return position >= 0 && position < text.size();
    }

    @Override
    public String toString() {
        String resString = "[";
        for(int i=0; i<text.size()-1; i++) {
            resString += text.get(i) + ", ";
        }
        resString += text.getLast() + "]";
        return resString;
    }
}
