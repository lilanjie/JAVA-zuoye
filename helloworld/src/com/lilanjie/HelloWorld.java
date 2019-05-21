package com.lilanjie;


import java.util.StringTokenizer;

//命名 类名要用大驼峰 HelloWorld
public class HelloWorld {
    public static void main(String[] args) {
        Student zhanghaoyan = new Student("张昊岩", 99);
        //System.out.println(zhanghaoyan.getName()+"的分数是： "+zhanghaoyan.getScore());


        Student lilanjie = new Student("李澜洁", 100);
        //System.out.println(lilanjie.getName()+"的分数是： "+lilanjie.getScore());


        //if(lilanjie.isScoreGreaterThan(zhanghaoyan)) {
        //System.out.println("李澜洁比张昊岩分数高");
        //}

        //System.out.println(lilanjie.getFirstName());

        // lilanjie.rename("盯盯");
        //zhanghaoyan.print();

        Student xiaoyanyan = new Student("小岩岩", 61);
        //xiaoyanyan.print();

        Student kenan = new Student("柯南", 92);
        Student maolilan = new Student("毛利兰", 90);
        Student huiyuanai = new Student("灰原哀", 91);
        Student gongtengxinyi = new Student("工藤新一", 88);
        Student maolixiaowulang = new Student("毛利小五郎", 87);
        Student lingmuyuanzi = new Student("铃木园子", 70);
        Student fubupingci = new Student("服部平次", 90);
        Student huge = new Student("胡歌", 98);
        Student dilireba = new Student("迪丽热巴", 97);


        //List<Student> list = new ArrayList<>();
        //list.add(lilanjie);
        //list.add(zhanghaoyan);
        //list.add(xiaoyanyan);
        //list.add(kenan);
        //list.add(maolilan);
        //list.add(huiyuanai);
        //list.add(gongtengxinyi);
        //list.add(maolixiaowulang);
        //list.add(fubupingci);
        //尝试一下使用 for(Student student:list){}遍历
        //c
        //}
        // for(Student student:list){
        //    student.print();
        //}

        //Map<String,Student>map=new HashMap<>();
        //map.put("李澜洁" ,lilanjie);
        //map.put("张昊岩",zhanghaoyan);
        //map.put("胡歌",huge);
        //map.put("迪丽热巴",dilireba);

        //map.get("胡歌").print();

    //StudentList list=new StudentList();
        // list.add(0,lilanjie);
        // list.add(1,zhanghaoyan);
         //list.add(2,xiaoyanyan);
         //list.add(3,kenan);
        // list.add(4,dilireba);
        // list.add(2,huge);
        //list.remove(3);

        // list.add(9,huge);
        // Student n=list.getStudent(2);
        // n.print();
        //StudentLinkedList linkedList = new StudentLinkedList();
         //linkedList.add(0,lilanjie);
       // linkedList.add(1,zhanghaoyan);
         //linkedList.add(2,xiaoyanyan);
         //linkedList.add(3,kenan);
         //linkedList.add(4,dilireba);
         //linkedList.add(5,huge);

         //Student n = linkedList.get(3);
        // n.print();
         //linkedList.remove(3);
        // linkedList.add(3,gongtengxinyi);

        //for(int i=0;i<linkedList.size;i++) {
           // Student s = linkedList.get(i);
            // s.print();
       // }
      //int [] arr = new int []{2,7,9,11};
        //TwoSums twoSums = new TwoSums();
       //twoSums = new TwoSums();

       //int[] ints = twoSums.twoSums(arr, 9);


       // System.out.println("["+ints[0]+" "+ints[1]+"]");
       //int x = 123;
       // Reverse reverse = new Reverse();
       //reverse = new Reverse();
      //int y = reverse.reverse(-2147483648);
      //System.out.println(y);

       //
       //
     //int m=Math.abs(-2147483648);
     //System.out.println(m);
//Palindrome palindrome = new Palindrome();
//palindrome = new Palindrome();
// boolean m = palindrome.isPalindrome(-121);
    // System.out.println(m);
        //RomanToInt romanToInt = new RomanToInt();
        //romanToInt = new RomanToInt();
        //int num = romanToInt.romanToInt("IM");
       // System.out.println(num);

        //String [] words = new String[]{"flower","flow","dog"};
        //LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        //longestCommonPrefix = new LongestCommonPrefix();
        //String str = longestCommonPrefix.longestCommonPrefix(words);
        //System.out.println(str);

        //ValidParentheses validParentheses = new ValidParentheses();
        //validParentheses = new ValidParentheses();
        //boolean x = validParentheses.isValid("{[]}");
        //System.out.println(x);





        //Insertionsort insertionsort = new Insertionsort();
        //int[] A = new int[]{31 , 41 , 59 , 26 , 41 , 58};
       // int[] b = Insertionsort.insertionsort(A);
       // for (int i = 0 ; i < b.length ; i++ ){
           // System.out.print(" "+ b[i] );
        //}

        //StringBuffer country = new StringBuffer("china\n");//修改字符串
        //country.append("中国");                             //追加字符串。
        //System.out.println(country);

        //String course = "java,java EE,Android";
        //StringTokenizer st = new StringTokenizer(course,",");//字符串分割器，用逗号分隔；
        //while (st.hasMoreTokens()){                                //遍历，判断是否已经到结尾；
            //System.out.println(st.nextToken());                    //输出下一个字段
       // }

       // String course = "java,java E,Android";
       // String[] strings = course.split(",");
       // for(String str:strings){
           // System.out.println(str);
        //}

        String[] citys = {"北京","上海","武汉"};
        for(String city:citys){
            System.out.println(city);
        }








    }
}



//要建个包，不要直接放在src下
//包名一般是公司域名倒着写  如baidu.com就会以com.baidu开头
//建个包名com.lilanjie 把代码放到包里
