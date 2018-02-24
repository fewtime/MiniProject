/**
 * Created by cowlog on 18-2-24.
 * PhoneBook
 */

class PhoneBook {
    private String name;
    private String phoneNum;
    private String email;

// --Commented out by Inspection START (18-2-24 上午11:28):
//    public PhoneBook() {
//
//    }
// --Commented out by Inspection STOP (18-2-24 上午11:28)

    PhoneBook(String name, String phoneNum, String email) {
        super();
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    String getName() {
        return name;
    }
// --Commented out by Inspection START (18-2-24 上午11:28):
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (18-2-24 上午11:28)
    String getPhoneNum() {
        return phoneNum;
    }
// --Commented out by Inspection START (18-2-24 上午11:28):
//    public void setPhoneNum(String phoneNum) {
//        this.phoneNum = phoneNum;
//    }
// --Commented out by Inspection STOP (18-2-24 上午11:28)
    String getEmail() {
        return email;
    }
// --Commented out by Inspection START (18-2-24 上午11:28):
//    public void setEmail(String email) {
//        this.email = email;
//    }
// --Commented out by Inspection STOP (18-2-24 上午11:28)


}
