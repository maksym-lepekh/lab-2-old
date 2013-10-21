package maxl.dev.lab1;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Максим on 22.10.13.
 */
public class Lab2 {
    public static void main (String args[]){
        Reader fr = new Reader("lab2.dat");
        try {
            fr.read();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        User[] users = new User[fr.userNum];
        for(int i = 0; i < fr.userNum; i++)
        {
            users[i] = new User();
        }
        for(int[] i : fr.connections){
            users[i[0]].getFriends().add(users[i[1]]);
            users[i[1]].getFriends().add(users[i[0]]);
            System.out.println("Friends: " + i[0] + " and " + i[1] + ".");
        }

        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (int[] i : fr.voting) {
            System.out.println("Voting: user " + i[0] + " gets " + i[1] + " votes.");
            executor.execute(new VotingTask(users[i[0]], i[1]));
        }
        executor.shutdown();

        for (int i = 0; i< fr.userNum; i++)
        {
            System.out.println("User " + i  + " have " + users[i].getVotes() + " votes.");
        }
    }
}
