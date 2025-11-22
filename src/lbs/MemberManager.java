package lbs;

import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    public static final MemberManager instance = new MemberManager();

    private List<Member> members = new ArrayList<>();

    private MemberManager() {
        // Add initial members
        members.add(new Member(12345L, "John", "A.", "Doe", "Computer Science", "A-2023", "john.doe@example.com", 1234567890L, "2023-01-01"));
        members.add(new Member(67890L, "Jane", "B.", "Smith", "Information Technology", "B-2023", "jane.smith@example.com", 9876543210L, "2023-02-15"));
        members.add(new Member(54321L, "Bob", "C.", "Johnson", "Software Engineering", "C-2023", "bob.johnson@example.com", 5551234567L, "2023-03-10"));
    }

    public void addMember(Member m) {
        members.add(m);
    }

    public void removeMember(int index) {
        if (index >= 0 && index < members.size()) {
            members.remove(index);
        }
    }

    public void updateMember(int index, Member m) {
        if (index >= 0 && index < members.size()) {
            members.set(index, m);
        }
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public int getMemberCount() {
        return members.size();
    }

    public List<Member> searchMembers(String query) {
        List<Member> result = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        for (Member m : members) {
            if (m.getFirstName().toLowerCase().contains(lowerQuery) ||
                m.getLastName().toLowerCase().contains(lowerQuery) ||
                m.getCourse().toLowerCase().contains(lowerQuery) ||
                m.getEmail().toLowerCase().contains(lowerQuery)) {
                result.add(m);
            }
        }
        return result;
    }
}