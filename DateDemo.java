import com.boda.utils.Date;

public class DateDemo {

    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today.toString());
        Date birthday = new Date(2005, 12, 6);
        if (birthday.isLeapYear()) {
            System.out.println(birthday.getYear() + "年是闰年");
        } else {
            System.out.println(birthday.getYear() + "年不是闰年");
        }
        System.out.println("你已出生" + birthday.between(today) + "天。");
    }
}
