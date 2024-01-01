package concept.comparatorExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerSorter {

    public static void printPlayerName(List<Player> footballTeam) {
        footballTeam.forEach(p -> System.out.println(p.getName() + " - " + p.getRanking()));
    }

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);
        System.out.println("Before Sorting");
        printPlayerName(footballTeam);

        Collections.sort(footballTeam);
        System.out.println("\nAfter Sorting using comparable");
        printPlayerName(footballTeam);

        PlayerRankingComparator playerComparator = new PlayerRankingComparator();
        Collections.sort(footballTeam, playerComparator);
        System.out.println("\nAfter Sorting on ranking using comparator");
        printPlayerName(footballTeam);

        PlayerNameComparator playerNameComparator = new PlayerNameComparator();
        Collections.sort(footballTeam, playerNameComparator);
        System.out.println("\nAfter Sorting on name using comparator");
        printPlayerName(footballTeam);
    }

}
