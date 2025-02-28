/*
    Name: Mohamed Magdy Anwar
    ID : 20230353
    Section : S9 & S10
    Date : 27 / 2
    Version : V3.2
 */
import java.io.*;
import java.util.*;

class user {
    private String name;
    private String email;
    private int age;
    private String Password;
    private int id;
    private String Phone;
    private String[] Courses;

    user()
    {
        this.name = "Guest";
        this.email = "guest@gmail.com";
        this.age = 0;
        this.Password = "";
        this.id = 0;
        this.Phone = "";
    }

    user(int id, String Password)
    {
        this.name = "Guest";
        this.email = "guest@gmail.com";
        this.age = 0;
        this.Password = Password;
        this.id = id;
        this.Phone = "";
    }

    user(String name, String email, int age, String Password, int id, String Phone, String[] Courses)
    {
        this.name = name;
        this.email = email;
        this.age = age;
        this.Password = Password;
        this.id = id;
        this.Phone = Phone;
        this.Courses = Courses;
    }

    void setData(String name, String email, int age, String Password, int id, String Phone)
    {
        this.name = name;
        this.email = email;
        this.age = age;
        this.Password = Password;
        this.id = id;
        this.Phone = Phone;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public int getAge()
    {
        return this.age;
    }

    public String getPassword()
    {
        return this.Password;
    }

    public String getPhone()
    {
        return this.Phone;
    }

    public int getId()
    {
        return this.id;
    }

    public String[] getCourses()
    {
        return this.Courses;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.Password = password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.Phone = phoneNumber;
    }

    public void setId() {
        this.id = id;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setCourses(String[] courses)
    {
        this.Courses = courses;
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, user> Data = new HashMap<>();
        DataSetup(Data);
        boolean IsRunning = true;
        boolean LoggedIn = false;
        user user = null;
        while (IsRunning) {
            if(!LoggedIn) {
                Login_menu();
                String choice;
                choice = sc.nextLine();
                System.out.println("===============================================");
                switch (choice) {
                    case "1":
                    {
                        while(true)
                        {
                            System.out.print("Enter your ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            if(Data.containsKey(id))
                            {
                                System.out.print("Enter your Password: ");
                                String Password = sc.nextLine();
                                if(Data.get(id).getPassword().equals(Password))
                                {
                                    user = new user(Data.get(id).getName(), Data.get(id).getEmail() , Data.get(id).getAge() , Data.get(id).getPassword(), id, Data.get(id).getPhone(), Data.get(id).getCourses());
                                    System.out.printf("logged in Successfully, Welcome %s\n", user.getName());
                                    LoggedIn = true;
                                    break;
                                }
                                else
                                {
                                    System.out.println("Wrong Password!");
                                }
                            }
                            else {
                                System.out.println("Wrong ID !");
                            }
                            System.out.println("===============================================");
                        }
                        break;
                    }
                    case "2":
                    {
                        System.out.print("Enter your ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        if(Data.containsKey(id))
                        {
                            System.out.println("This id is already existed!");
                        }
                        else {
                            while(true)
                            {
                                try{
                                    System.out.print("Enter your Name: ");
                                    String name = sc.nextLine();
                                    System.out.print("Enter your Email: ");
                                    String email = sc.nextLine();
                                    System.out.print("Enter your Age: ");
                                    int age = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter your Password: ");
                                    String Password = sc.nextLine();
                                    System.out.println("Enter your PhoneNumber: ");
                                    String Phone = sc.nextLine();
                                    user = new user(name , email , age , Password,id , Phone , new String[]{});
                                    Data.put(id, user);
                                    LoggedIn = true;
                                    System.out.println("User Successfully registered!");
                                    break;
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Something went wrong" + e.getMessage());
                                }
                            }
                        }
                        System.out.println("===============================================");
                        break;
                    }
                    case "3":
                    {
                        IsRunning = false;
                        System.out.println("Thanks for Using our System <3");
                        System.out.println("===============================================");
                        break;
                    }
                    default:
                    {
                        System.out.println("Wrong Choice!");
                        System.out.println("===============================================");
                        break;
                    }
                }
            }
            if(!LoggedIn)
            {
                continue;
            }
            boolean options = true;
            while(options)
            {
                Menu();
                System.out.print("Enter your choice: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                    {
                        String[] RegCourses = user.getCourses();
                        System.out.print("Registered Courses: ");
                        for(String RegCourse: RegCourses)
                        {
                            System.out.print(RegCourse + " ");
                        }
                        System.out.println();
                        break;
                    }
                    case "2":
                    {
                        String[] Courses = new String[]{
                                "Data Structures", "Algorithms", "Operating Systems","Machine Learning", "Database Systems", "Artificial Intelligence","Computer Networks", "Cybersecurity", "Web Development"
                                ,"Data Science", "Software Engineering", "Cloud Computing","Mobile App Development","Theory of Computation", "Cryptography","Big Data", "Deep Learning","Computer Vision","Network Security"
                                ,"Web Development"
                        };
                        HashMap<Integer, String> CoursesID = new HashMap<>();
                        int cnt = 1;
                        for(String course : Courses)
                        {
                            CoursesID.put(cnt , course);
                            cnt++;
                        }
                        String[] RegCourses = user.getCourses();
                        cnt = 0;
                        for(String RegCourse: RegCourses)
                        {
                            cnt = CoursesID.size() + 1;
                            for(int i = 0 ; i <= cnt; i++)
                            {
                                if(RegCourse.equals(CoursesID.get(i)))
                                {
                                    CoursesID.remove(i);
                                }
                            }
                        }
                        System.out.println("===============================================");
                        System.out.println("Available Courses: ");
                        for(int i = 1 ; i <= CoursesID.size(); i++)
                        {
                            if(CoursesID.containsKey(i))
                            {
                                System.out.println(i + " " + CoursesID.get(i));
                            }
                        }
                        int id = 0;
                        while(true)
                        {
                            try{
                                System.out.print("Enter Course ID: ");
                                id = sc.nextInt();
                                sc.nextLine();
                                if(id <= 0 || id > CoursesID.size())
                                {
                                    throw new Exception();
                                }
                                if(!CoursesID.containsKey(id))
                                {
                                    throw new Exception();
                                }
                                break;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Wrong ID!" + e.getMessage());
                            }
                        }
                        String[] userCourses = user.getCourses();
                        boolean flag = true;
                        for(String course: userCourses)
                        {
                            if(course.equals(CoursesID.get(id)))
                            {
                                System.out.println("This Course is already Registered !");
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                        {
                            String[] newCourses = new String[userCourses.length + 1];
                            for(int i = 0 ; i < userCourses.length; i++)
                            {
                                newCourses[i] = userCourses[i];
                            }
                            newCourses[userCourses.length] = CoursesID.get(id);
                            user.setCourses(newCourses);
                            System.out.println("Course Registered Successfully!");
                        }
                        break;
                    }
                    case "3":
                    {
                        String[] Courses = user.getCourses();
                        System.out.print("Registered Courses: ");
                        int cnt = 1;
                        for(String course : Courses)
                        {
                            System.out.print(cnt + ". " + course + " ");
                            cnt++;
                        }
                        while(true)
                        {
                            try{
                                System.out.print("\nEnter The Number corresponding to the Course Name to unRegister it: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                if(id <= 0 || id > Courses.length)
                                {
                                    throw new Exception();
                                }
                                String Removed_course = Courses[id - 1];
                                String[] newCourses = new String[Courses.length - 1];
                                cnt = 0;
                                for(String Course : Courses)
                                {
                                    if(Course.equals(Removed_course))
                                    {
                                        continue;
                                    }
                                    newCourses[cnt] = Course;
                                    cnt++;
                                }
                                user.setCourses(newCourses);
                                System.out.println("Course Unregistered Successfully!");
                                break;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Wrong ID!");
                            }
                        }
                        break;
                    }
                    case "4":
                    {
                        System.out.println("Which Data to Change: ");
                        System.out.println("1. Name");
                        System.out.println("2. Email");
                        System.out.println("3. Age");
                        System.out.println("4. Password");
                        System.out.println("5. PhoneNumber");
                        choice = sc.nextLine();
                        switch(choice)
                        {
                            case "1":
                            {
                                System.out.print("Enter your Name: ");
                                String name = sc.nextLine();
                                user.setName(name);
                                System.out.println("Name Successfully Changed!");
                                break;
                            }
                            case "2":
                            {
                                System.out.print("Enter your Email: ");
                                String email = sc.nextLine();
                                user.setEmail(email);
                                System.out.println("Email Successfully Changed!");
                                break;
                            }
                            case "3":
                            {
                                while(true)
                                {
                                    try{
                                        System.out.print("Enter your Age: ");
                                        int age = sc.nextInt();
                                        sc.nextLine();
                                        if(age <= 0)
                                        {
                                            throw new Exception("Age cannot be zero or negative");
                                        }
                                        if(age < 17)
                                        {
                                            throw new Exception("Age cannot be less than 17");
                                        }
                                        user.setAge(age);
                                        System.out.println("Age Successfully Changed!");
                                        break;
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println("Wrong AGE!" + e.getMessage());
                                    }
                                }
                                break;
                            }
                            case "4":
                            {
                                while(true)
                                {
                                    try{
                                        System.out.print("Enter your Password: ");
                                        String Password = sc.nextLine();
                                        if(Password.equals(user.getPassword()))
                                        {
                                            throw new Exception("new Password Can't equal the old one");
                                        }
                                        if(Password.length() < 8)
                                        {
                                            throw new Exception("new Password Length must be at least 8 characters");
                                        }
                                        user.setPassword(Password);
                                        System.out.println("Password Successfully Changed!");
                                        break;
                                    }
                                    catch (Exception e)
                                    {
                                        System.out.println("Wrong Password!" + e.getMessage());
                                    }
                                }
                                break;
                            }
                            case "5":
                            {
                                System.out.print("Enter your PhoneNumber: ");
                                String phone = sc.nextLine();
                                user.setPhoneNumber(phone);
                                System.out.println("Phone Number Successfully Changed!");
                                break;
                            }
                            default:
                            {
                                System.out.println("Wrong Choice!");
                                break;
                            }
                        }
                        break;
                    }
                    case "5":
                    {
                        options = false;
                        LoggedIn = false;
                        System.out.println("Logged out Successfully!");
                        break;
                    }
                    default:
                    {
                        System.out.println("Wrong Choice!");
                        break;
                    }
                }
            }

        }
    }
    public static void Login_menu()
    {
        System.out.println("===============================================");
        System.out.println("Welcome to FCAI-CU Managment System");
        System.out.println("===============================================");
        System.out.println("1. Login");
        System.out.println("2. Register a new user");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }
    public static void Menu()
    {
        System.out.println("===============================================");
        System.out.println("Welcome to FCAI-CU Managment System");
        System.out.println("===============================================");
        System.out.println("1. View Registered Courses");
        System.out.println("2. Register new Course");
        System.out.println("3. Unregister Course");
        System.out.println("4. Change User Data");
        System.out.println("5. Logout and Exit");
    }
    public static void DataSetup(HashMap<Integer , user>Data)
    {
        Data.put(1 , new user("John Doe","john.doe@example.com",25,"pass123",1,"0123456789,25", new String[]{
                "Data Structures", "Algorithms", "Operating Systems"}));
        Data.put(2 , new user("Alice Smith","alice.smith@gmail.com",30,"alicePass",2,"01122334455", new String[]{
                "Machine Learning", "Database Systems", "Artificial Intelligence"}));
        Data.put(3 , new user("Bob Johnson","bob.johnson@yahoo.com",22,"bobSecret",3,"01011223344",new String[]{
                "Computer Networks", "Cybersecurity", "Web Development"}));
        Data.put(4 , new user("Charlie Brown","charlie.brown@hotmail.com",28,"charlieX",4,"01555667788", new String[]{
                "Data Science", "Software Engineering", "Cloud Computing"}));
        Data.put(5 , new user("Emily White","emily.white@outlook.com",21,"emilyPass",5,"01099887766", new String[]{
                "Mobile App Development", "Data Structures", "Algorithms"}));
        Data.put(6 , new user("david Black","david.black@company.com",27,"david123",6,"01111222333", new String[]{
                "Operating Systems", "Theory of Computation", "Cryptography"}));
        Data.put(7 , new user("Sarah Green","sarah.green@edu.org",23,"sarah321",7,"01233445566", new String[]{
                "Big Data", "Deep Learning", "Software Engineering"}));
        Data.put(8 , new user("Michael Blue","michael.blue@tech.com",26,"michaelXYZ",8,"01543218765", new String[]{
                "Cybersecurity", "Computer Vision", "Network Security"}));
        Data.put(9 , new user("Emma Red","emma.red@research.org",20,"emmaPass",9,"01056781234", new String[]{
                "Web Development", "Artificial Intelligence", "Data Science"}));
        Data.put(10 , new user("Oliver Grey","oliver.grey@university.edu",24,"oliver007",10,"01299887744", new String[]{
                "Machine Learning", "Algorithms", "Database Systems"}));
    }
}