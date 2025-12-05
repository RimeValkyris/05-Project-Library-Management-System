package lbs;

import java.util.ArrayList;
import java.util.List;

public class MemberManager {
    public static final MemberManager instance = new MemberManager();

    private List<Member> members = new ArrayList<>();

    private MemberManager() {
        // Add sample members
        addMember(new Member(123456, "John", "A", "Doe", "Computer Science", "1A", "john.doe@example.com", 1234567890L, "2023-01-01"));
        addMember(new Member(234567, "Jane", "B", "Smith", "Mathematics", "2B", "jane.smith@example.com", 2345678901L, "2023-02-01"));
        addMember(new Member(345678, "Alice", "C", "Johnson", "Physics", "3C", "alice.johnson@example.com", 3456789012L, "2023-03-01"));
        addMember(new Member(456789, "Bob", "D", "Williams", "Chemistry", "4D", "bob.williams@example.com", 4567890123L, "2023-04-01"));
        addMember(new Member(567890, "Charlie", "E", "Brown", "Biology", "5E", "charlie.brown@example.com", 5678901234L, "2023-05-01"));
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