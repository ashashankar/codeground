package com.myplayground.playground;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class NumberOfSeniorCitizensLC2678 {
    public static void main(String[] args) {
        String[] data = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(citizens(data));
        System.out.println(getCitizensApproachTwo(data));
    }

    public static int citizens(String[] citizen) {
        int result = 0;
        for (String person : citizen) {
            String age = person.substring(11,13);
            if (Integer.parseInt(age) > 60) result++;
        }
        return result;
    }

    public static int getCitizensApproachTwo(String[] data) {
        int seniorCount  =0 ;
        for (String s : data) {
            int tens = s.charAt(11) - '0';
            int ones = s.charAt(12) - '0';
            int age = tens * 10 + ones;
            if (age > 60 ) seniorCount++;
        }
        return  seniorCount;
    }
}

@Getter
@Setter
class Citizen {
    int age;
    String gender;
    String phone;
    Citizen(int age, String gender, String phone) {
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
}
