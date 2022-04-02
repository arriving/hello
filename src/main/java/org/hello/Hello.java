package org.arriving.hello;

public class Hello {

    public static void main(String[] argc) {

        Team team = new Team();
        team.addMember(new Person("Tom"));
        team.addMember(new Person("Jack"));

        team.say("Hello");
        if (argc.length > 0) {
            team.say(argc[0]);
        }
    }
}
