package org.hello;

import java.util.ArrayList;
import java.util.List;

public class Team {

    List<Person> members = new ArrayList<>();

    public void addMember(Person person) {
        this.members.add(person);
    }

    public void say(String word) {
        for (Person member : members) {
            member.say(word);
        }
    }
}
