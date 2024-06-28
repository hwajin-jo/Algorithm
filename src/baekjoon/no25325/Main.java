package baekjoon.no25325;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();

        sc.nextLine();
        String[] people = sc.nextLine().split(" ");

        for (int i = 0; i < people.length; i++) {
            map.put(people[i], 0);
        }

        for (int i = 0; i < n; i++) {
            String[] votes = sc.nextLine().split(" ");

            for (int j = 0; j < votes.length; j++) {
                map.put(votes[j], map.get(votes[j]) + 1);
            }
        }

        List<Person> peopleList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            peopleList.add(new Person(entry.getKey(), entry.getValue()));
        }

        Collections.sort(peopleList);

        for (Person person : peopleList) {
            System.out.println(person.name + " " + person.popular);
        }

    }
}

class Person implements Comparable<Person> {
    String name;
    int popular;

    public Person(String name, int popular) {
        this.name = name;
        this.popular = popular;
    }

    @Override
    public int compareTo(Person o) {
        if (this.popular == o.popular) {
            return this.name.compareTo(o.name);
        }

        return o.popular - this.popular;
    }
}
