package com.myplayground.DesignPatterns.Prototype;

import java.lang.Package;

public class Driver_Prototype {
    public static void main(String[] args) {
        PackageConfig packageConfig = new PackageConfig("hardcover", "blue", "subsidizedGift");
        /**
         *
         */
        for (int i=0; i<100; i++) {
            PackageConfig pkg_config = packageConfig.clone();
            System.out.println("Original prototype "+ packageConfig + " object "+ pkg_config.hashCode());
        }



        packageConfig.setColor("Yellow");
        for (int i=0; i<100; i++) {
            PackageConfig pkg_config = packageConfig.clone();
            System.out.println("Original prototype "+ packageConfig + " object "+ pkg_config.hashCode());
        }
        System.out.println(" Yellow prototype "+ packageConfig);

    }
}
