import org.kohsuke.github.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class GithubDashBoard {

    private final static String TOKEN = "my_token";

    public static void main(String[] args) throws IOException {
        GitHub gitHub = new GitHubBuilder().withOAuthToken(TOKEN).build();

        GHRepository repository = gitHub.getRepository("whiteship/live-study");

        List<GHIssue> issues = repository.getIssues(GHIssueState.ALL);
        Map<String, Integer> participant = new HashMap<>();

        // 1 ~ 18까지 이슈 순회
        for (GHIssue issue : issues) {
            Set<String> commentUsers = new HashSet<>();

            // 댓글 한개 이상이면 중복 제거
            for (GHIssueComment comment : issue.getComments()) {
                commentUsers.add(comment.getUser().getLogin());
            }

            // 참여 횟수 증가
            for (String commentUser : commentUsers) {
                if (participant.containsKey(commentUser)) {
                    participant.replace(commentUser, participant.get(commentUser) + 1);
                    continue;
                }

                participant.put(commentUser, 1);
            }
        }

        // 출력
        for (String name : participant.keySet()) {
            double rate = (double)participant.get(name) * 100 / issues.size();
            System.out.println("참가자 : " + name + " , 진행률 : " + new DecimalFormat("#.##").format(rate));
        }
    }
}
