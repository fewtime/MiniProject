import java.util.Collection;
import java.util.Scanner;

/**
 * Created by cowlog on 18-2-24.
 * Demo
 */
public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String name ;
        do {
            System.out.println("可进行的操作有：");
            System.out.println("	1.存入信息");
            System.out.println("	2.通过姓名查询其他信息");
            System.out.println("	3.通过电话查询其他信息");
            System.out.print("请输入您要进行的操作：");
            switch (input.nextInt()) {
                case 1:
                    System.out.print("请输入姓名：");
                    name = input.next();
                    System.out.print("请输入电话号码：");
                    String phoneNum = input.next();
                    System.out.print("请输入邮箱：");
                    String email = input.next();
                    IOUtil.save(name, phoneNum, email);
                    break;
                case 2:
                    System.out.println("通过姓名查询其他信息");
                    findByName();
                    break;
                case 3:
                    System.out.println("通过电话查询其他信息");
                    findByPhoneNum();
                    break;
                default:
                    System.out.println("没有该操作！");
            }
            System.out.print("是否继续操作（y/n）：");
        } while ("y".equals(input.next()));
    }

    private static void findByName() {
        String name ;
        System.out.print("请输入需要查询的姓名：");
        name = input.next();
        if(IOUtil.phoneDatas.containsKey(name)){
            System.out.println(name+"的电话号码是:"+IOUtil.phoneDatas.get(name).getPhoneNum()+",邮箱是："+IOUtil.phoneDatas.get(name).getEmail());
        }else{
            System.out.println("没有名为"+name+"的信息。");
        }
    }

    private static void findByPhoneNum(){
        System.out.print("请输入需要查询的号码：");
        String phoneNum = input.next();
        Collection<PhoneBook> pbs = IOUtil.phoneDatas.values();
        for(PhoneBook pb:pbs){
            if(phoneNum.equals(pb.getPhoneNum())){
                System.out.print("电话号码为"+phoneNum+"的姓名是："+pb.getName()+",邮箱是："+pb.getEmail());
                return;
            }
        }
        System.out.println("没有电话号码为"+phoneNum+"的信息。");
    }
}
