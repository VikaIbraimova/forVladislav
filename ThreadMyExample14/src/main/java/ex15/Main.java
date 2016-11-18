package ex15;

import ex15.ex.SAXParserExample;
import ex15.ex2.DOMParserExample;

/**
 * Created by vika on 18.11.16.
 */
public class Main {
    public static void main(String[] args) {
        //Пример работы с SAX парсером
        SAXParserExample.mainSAX();
        //Пример работы с DOM парсером
        DOMParserExample.mainDOM();
    }
}
