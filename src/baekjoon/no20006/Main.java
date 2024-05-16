package baekjoon.no20006;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt(); // 플레이어의 수
        int m = sc.nextInt(); // 방의 정원

        List<Player> playerList = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            playerList.add(new Player(sc.nextInt(), sc.next()));
        }

        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);

            if (roomList.isEmpty()) {
                Room room = new Room(1, player.level - 10, player.level + 10);
                roomList.add(room);
                room.players.add(player);
            } else {
                boolean flag = true;
                for (int j = 0; j < roomList.size(); j++) {
                    Room room = roomList.get(j);
                    if (room.low <= player.level && player.level <= room.high && room.size < m) {
                        room.size++;
                        room.players.add(player);
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    Room createdRoom = new Room(1, player.level - 10, player.level + 10);
                    roomList.add(createdRoom);
                    createdRoom.players.add(player);
                }
            }
        }

        for (Room room : roomList) {
            Collections.sort(room.players, (o1, o2) -> o1.nickname.compareTo(o2.nickname));
            if (room.size == m) {
                System.out.println("Started!");
                for (Player player : room.players) {
                    System.out.println(player.level + " " + player.nickname);
                }
            } else {
                System.out.println("Waiting!");
                for (Player player : room.players) {
                    System.out.println(player.level + " " + player.nickname);
                }
            }
        }
    }
}

class Room {
    int size;
    int low;
    int high;
    List<Player> players = new ArrayList<>();

    public Room (int size, int low, int high) {
        this.size = size;
        this.low = low;
        this.high = high;
    }
}

class Player {
    int level;
    String nickname;

    public Player (int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }
}
