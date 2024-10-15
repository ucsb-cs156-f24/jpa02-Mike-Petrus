package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");   
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   @Test
   public void toString_returns_correct_string() {
    assertEquals("Team(name=test-team, members=[])", team.toString());
   }

   @Test
   public void equals_returns_correct_case_1_and_2() {
    assertEquals(true, team.equals(team));
    assertEquals(false, team.equals(team.getMembers()));
   }

   @Test
   public void equals_returns_correct_case_3() {
    Team t1 = new Team("test-team");
    assertEquals(true, team.equals(t1));

    t1.setName("wrong");
    assertEquals(false, team.equals(t1));

    t1.setName("test-team");
    t1.addMember("wrong");
    assertEquals(false, team.equals(t1));
   }

   @Test
   public void test_hash_code() {
    Team t1 = new Team();
    t1.setName("foo");
    t1.addMember("bar");

    int result = t1.hashCode();
    int expectedResult = 130294;
    assertEquals(expectedResult, result);
   }



    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
