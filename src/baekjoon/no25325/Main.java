package baekjoon.no25325;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();

        sc.nextLine();
        String[] people = sc.nextLine().split(" ");

        for (String s : people) {
            map.put(s, 0);
        }

        for (int i = 0; i < n; i++) {
            String[] votes = sc.nextLine().split(" ");

            for (String vote : votes) {
                map.put(vote, map.get(vote) + 1);
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
