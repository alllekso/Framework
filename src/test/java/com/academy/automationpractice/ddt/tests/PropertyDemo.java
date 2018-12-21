package com.academy.automationpractice.ddt.tests;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
2) Сгенерировать массив 100 абонентов:
		- id возрастает для каждого следующего абонента (необязательно последовательно)
		- со случайными именами и фамилиями (брать из подготовленного массива данных)
		- возраст от 18 до 60 лет
		- телефонный номер заполнить по следующему правилу (задача была на предыдущих занятиях):
			- 10 цифр
			- первый три цифры 999,
			- последняя 0 или 5
			- остальные цифры - любые
 */
public class PropertyDemo {
    private static String[] firstNames = {"Maша", "Петя", "Вася", "Миша", "Даша", "Катя", "Саша", "Паша"};
    private static String[] lastNames = {"Корженко", "Михайленко", "Кузьменко", "Клопотенко", "Половик"};
    private static Random rand = new Random();
    private static long id = 1L;

    // TODO
    private static String txtFile = "subscribers.txtFile";
    private static String xlsFile = "subscribers.xlsx";

    private static String PROP_NAME = "java-part.properties";


    public static String readProperty(String key) {
        Properties prop = new Properties();
        InputStream is = PropertyDemo.class.getClassLoader().getResourceAsStream("java-part.properties");
        try (InputStreamReader isr = new InputStreamReader(is, "UTF-8")) {
            prop.load(isr);
            return prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}