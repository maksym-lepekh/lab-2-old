package maxl.dev.lab1;

/**
 * Created by Максим on 22.10.13.
 */
public class VotingTask implements Runnable {
    private int votes;
    private User user;
    public VotingTask(User user, int votes)
    {
        this.votes = votes;
        this.user = user;
    }

    @Override
    public void run() {
        user.changeVotes(votes);
        user.getFriends();
        for (User i : user.getFriends()) {
            i.changeVotes(votes/2);
        }

    }
}
