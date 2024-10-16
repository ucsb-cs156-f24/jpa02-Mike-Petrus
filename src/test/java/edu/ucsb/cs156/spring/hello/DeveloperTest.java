package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Mike", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)


    @Test
    public void geGithubId_returns_correct_githubId() {
        assertEquals("Mike-Petrus", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Amber"),"Team should contain Amber");
        assertTrue(t.getMembers().contains("Caleb"),"Team should contain Caleb");
        assertTrue(t.getMembers().contains("Christy"),"Team should contain Christy");
        assertTrue(t.getMembers().contains("Divyani"),"Team should contain Divyani");
        assertTrue(t.getMembers().contains("Mike"),"Team should contain Mike");
        assertTrue(t.getMembers().contains("Oscar"),"Team should contain Oscar");

    }
}
