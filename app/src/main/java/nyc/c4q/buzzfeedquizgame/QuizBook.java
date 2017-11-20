package nyc.c4q.buzzfeedquizgame;

/**
 * Created by muridjonrahimov on 11/16/17.
 */


public class QuizBook {

    public static String[] questions = new String[]{

            "int x[] = new int[]{10,20,30}; Arrays can also be created and initialize as in above statement.",// 1: true
            "In an instance method or a constructor, \"this\" is a reference to the current object.",// 2: true
            "Garbage Collection is manual process.",                                                 // 3: false
            "Variable name can begin with a letter, \"$\", or \"_\".",                               // 4: true
            "Assignment operator is evaluated Left to Right.",                                       // 5: false
            "All binary operators except for the assignment operators are evaluated from Left to Right",// 6: true
            "Java programming is not statically-typed, means all variables should not first be declared before they can be used.",//7:false
            "Java technology is both a programming language and a platform.",                        // 8: true
            "James Gosling is father of Java?.",                                                     // 9: true
    };

    public static int[] images = new int[]{

            R.drawable.img_0512, R.drawable.img_0516, R.drawable.img_0521, R.drawable.img_0522,
            R.drawable.img_0523, R.drawable.img_0525, R.drawable.img_0526, R.drawable.img_0527,
            R.drawable.img_0528
    };

    public static boolean[] answers = new boolean[]{
            true, true, false, true, false, true, false, true, true
    };
}