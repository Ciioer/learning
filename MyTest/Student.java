package MyTest;

public class Student {

       private static class Inner{
           private  static Student student =new Student();
       }
       private Student(){
           if(Inner.student!=null){
               try{
                   throw  new IllegalAccessException("禁止反射");
               }catch (IllegalAccessException e){
                      e.printStackTrace();
               }
           }
       };
      public static Student getStudent(){
           return Inner.student;
      }

}
