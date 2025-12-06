package lbs;
public class Member {
		private String memberCode; 
		private long studentNumber; 
		private String FirstName;
		private String MiddleName;
		private String LastName;
		private String Course;
		private String SectionAndYear;
		private String Email;
		private long PhoneNumber;
		private String DateJoined;
		
		// Constructor
		public Member(long studentNumber, String firstName, String middleName, String lastName, String course,
					String sectionAndYear, String email, long phoneNumber, String dateJoined) {
			super();
			this.studentNumber = studentNumber;
			this.memberCode = MemberIdGenerator.nextId();
			FirstName = firstName;
			MiddleName = middleName;
			LastName = lastName;
			Course = course;
			SectionAndYear = sectionAndYear;
			Email = email;
			PhoneNumber = phoneNumber;
			DateJoined = dateJoined;
		}
		
		
		public Member(String memberCode, long studentNumber, String firstName, String middleName, String lastName, String course,
					String sectionAndYear, String email, long phoneNumber, String dateJoined) {
			super();
			this.memberCode = memberCode;
			this.studentNumber = studentNumber;
			FirstName = firstName;
			MiddleName = middleName;
			LastName = lastName;
			Course = course;
			SectionAndYear = sectionAndYear;
			Email = email;
			PhoneNumber = phoneNumber;
			DateJoined = dateJoined;
		}
		
		public String getMemberCode() {
			return memberCode;
		}
		
		public void setMemberCode(String memberCode) {
			this.memberCode = memberCode;
		}
		
		public long getStudentNumber() {
			return studentNumber;
		}
		
		public void setStudentNumber(long studentNumber) {
			this.studentNumber = studentNumber;
		}
		
		public String getFirstName() {
			return FirstName;
		}
		
		public void setFirstName(String firstName) {
			FirstName = firstName;
		}
		
		public String getMiddleName() {
			return MiddleName;
		}
		
		public void setMiddleName(String middleName) {
			MiddleName = middleName;
		}
		
		public String getLastName() {
			return LastName;
		}
		
		public void setLastName(String lastName) {
			LastName = lastName;
		}
		
		public String getCourse() {
			return Course;
		}
		
		public void setCourse(String course) {
			Course = course;
		}
		
		public String getSectionAndYear() {
			return SectionAndYear;
		}
		
		public void setSectionAndYear(String sectionAndYear) {
			SectionAndYear = sectionAndYear;
		}
		
		public String getEmail() {
			return Email;
		}
		
		public void setEmail(String email) {
			Email = email;
		}
		
		public long getPhoneNumber() {
			return PhoneNumber;
		}
		
		public void setPhoneNumber(long phoneNumber) {
			PhoneNumber = phoneNumber;
		}
		
		public String getDateJoined() {
			return DateJoined;
		}
		
		public void setDateJoined(String dateJoined) {
			DateJoined = dateJoined;
		}
}