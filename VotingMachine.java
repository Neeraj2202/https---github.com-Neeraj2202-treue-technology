import java.util.*;

class User {
    String username;
    private String password;
    private boolean hasVoted;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.hasVoted = false;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void markAsVoted() {
        hasVoted = true;
    }
}

class Candidate {
    private String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void vote() {
        votes++;
    }
}

class VotingSystem {
    private List<User> users;
    private List<Candidate> candidates;

    public VotingSystem() {
        users = new ArrayList<>();
        candidates = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.authenticate(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean vote(User user, Candidate candidate) {
        if (!user.hasVoted()) {
            candidate.vote();
            user.markAsVoted();
            return true;
        }
        return false;
    }

    public void displayResults() {
        System.out.println("Election Results:");
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getName() + ": " + candidate.getVotes() + " votes");
        }
    }
}

public class VotingMachine {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Create users and candidates
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        votingSystem.addUser(user1);
        votingSystem.addUser(user2);

        Candidate candidate1 = new Candidate("Candidate A");
        Candidate candidate2 = new Candidate("Candidate B");
        votingSystem.addCandidate(candidate1);
        votingSystem.addCandidate(candidate2);

        // User authentication and voting
        User authenticatedUser = votingSystem.authenticateUser("user1", "password1");
        if (authenticatedUser != null) {
            boolean voted = votingSystem.vote(authenticatedUser, candidate1);
            if (voted) {
                System.out.println("Vote cast successfully!");
            } else {
                System.out.println("You have already voted.");
            }
        }

        // Display election results
        votingSystem.displayResults();
    }
}
