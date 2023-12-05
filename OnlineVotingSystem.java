import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {

    private Map<String, Integer> candidates;
    private Map<String, Boolean> voters;

    public OnlineVotingSystem() {
        candidates = new HashMap<>();
        voters = new HashMap<>();
    }

    public void addCandidate(String name) {
        candidates.put(name, 0);
    }

    public void displayCandidates() {
        System.out.println("Candidates:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate);
        }
    }

    public void vote(String candidate, String voterId) {
        if (!voters.containsKey(voterId) && candidates.containsKey(candidate)) {
            candidates.put(candidate, candidates.get(candidate) + 1);
            voters.put(voterId, true);
            System.out.println("Vote cast successfully!");
        } else {
            System.out.println("Invalid vote. Either the candidate does not exist or the voter has already voted.");
        }
    }

    public void displayResults() {
        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        OnlineVotingSystem votingSystem = new OnlineVotingSystem();
        Scanner scanner = new Scanner(System.in);

        // Add candidates
        votingSystem.addCandidate("Candidate A");
        votingSystem.addCandidate("Candidate B");
        votingSystem.addCandidate("Candidate C");

        while (true) {
            System.out.println("\n1. Display Candidates");
            System.out.println("2. Vote");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    votingSystem.displayCandidates();
                    break;
                case 2:
                    System.out.print("Enter the candidate's name: ");
                    String candidateName = scanner.nextLine();
                    System.out.print("Enter your voter ID: ");
                    String voterId = scanner.nextLine();
                    votingSystem.vote(candidateName, voterId);
                    break;
                case 3:
                    votingSystem.displayResults();
                    break;
                case 4:
                    System.out.println("Exiting the voting system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
