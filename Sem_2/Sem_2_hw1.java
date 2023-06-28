/*Задание
1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */
/*Пример 1:
        Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
        Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow'

        Пример 2:
        Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
        Результат: SELECT * FROM USER */

//Не совсем понятно что требуется в задаче, сделаю как понял
/*
 Алгоритм
 0. Подключили библиотеку json-20230618.jar
 1. Сделаем строку изначальную jsonString с данными из условия задачи
 2. Сделаем функцию sqlfromjsonRequest, в качестве аргумента будет строка изначальная jsonString
 3. В функции sqlfromjsonRequest сделаем json объект jsonObj из на основе строки inputstr(jsonString) 
 4. Считаем количество "null" в строке
 5. Нужно сделать одномерный массив из ключей jsonObj значения которых не равны "null"
 6. Также нужно сделать одномерный массив из значений, не равных "null". Возможно,что можно сделать каое-то массив из
 кортежей или списков типа ключ:значение (не "null" которые), но пока не знаю как.
 7. Сделаем функцию countEl, которая будет считать кол-во key:value в строке json, скорее всего есть специальные методы,
 но мне о них неизвестно, поэтому эта функция будет искать количество двоеточий в строке json.
 8. Делаем функцию вормирования запроса нужного нам: createQuery.
 P.S. Не получилось вывести запрос в изначальном порядке, т.е. в таком виде, в каком была изначальная строка в 
 условии, т.к. в JSONObject записи находятся вразнобой. 
 */
package Sem_2;

//import org.json.JSONArray;
//import java.util.Scanner;
import org.json.JSONObject; //Пришлось добавить в зависимости библиотеку .jar
import java.util.Arrays;
//import org.json.JSONException;

public class Sem_2_hw1 {
    public static String[] keys; // Чтобы были доступны везде в программе
    public static String[] values; //
    // public static JSONObject jsonObj;

    public static void main(String[] args) {
        // Пункт 1 алгоритма

        String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        //String jsonString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\",\"adress\":\"Zovodskaya street\"}";
        //String jsonString = "{\"name\":\"null\", \"country\":\"null\", \"city\":\"null\", \"age\":\"null\"}";
        //String jsonString = "{\"name\":\"Ivanov\", \"country\":\"null\", \"city\":\"null\", \"age\":\"null\"}";

        String query = "Select*from students ";
        StringBuilder jsonquery = new StringBuilder(query);
        String queryResult = "";
        String modifiedQuery = "";
        int countNull = countNullinStr(jsonString); // пункт 4 алгоритма
        int countPair = countEl(jsonString);
        sqlfromjsonRequest(jsonString, countNull);

        if (countNull < countPair) {
            queryResult = createQuery(jsonquery, keys, values, countPair, countNull);
            modifiedQuery = queryResult.substring(0, queryResult.length() - 4);
        } else {
            modifiedQuery = query;

        }
        System.out.println("Сформирован следующий запрос: ");
        System.out.println(modifiedQuery);
    }

    // функция поиска "null" в строке
    public static int countNullinStr(String inputstr) {
        int count = 0;
        for (int i = 0; i < inputstr.length() - 3; i++) {
            if (inputstr.substring(i, i + 4).equals("null")) {
                count++;
            }
        }
        return count;
    }

    public static void sqlfromjsonRequest(String inputstr, int count) {
        // этот аргумент count сделал для того, чтобы получаемые массивы ключей и
        // значений были без "null", строгой
        // размерности, нужной нам.

        JSONObject jsonObj = new JSONObject(inputstr); // Будем работать с json
        // объектом, пункт 3 алгоритма, плохо, что с этим JSONObject не получается
        // сделать в нужном нам порядке строку-фильтр json
        keys = new String[jsonObj.length() - count]; // пункт 5 алгоритма, типа глобальные сделал массивы
        values = new String[jsonObj.length() - count]; // пункт 6 алгоритма
        int idx = 0;
        
        for (String key : jsonObj.keySet()) {
            if (!jsonObj.get(key).equals("null")) {
                keys[idx] = key;
                values[idx] = jsonObj.getString(keys[idx]);
                idx++;
            }
        }

        // System.out.println(Arrays.toString(keys));
        // System.out.println(Arrays.toString(values));
    }

    // приходитс делать эту функцию, так как в JSONObject элементы не в изначальном
    // порядке
    public static void sortMass(String[] k, String[] v, int count, int countN) {

    }

    // пункт 8 алгоритма
    public static String createQuery(StringBuilder inputquery, String[] k, String[] v, int count, int countN) {
        inputquery.append("where ");
        for (int j = 0; j < count - countN; j++) {
            inputquery.append(keys[j]);
            inputquery.append(" = ");
            inputquery.append("'" + values[j] + "'");
            inputquery.append(" and "); //получится лишний and в конце строки-запроса, обрежем его позже
        }
        return inputquery.toString();
    }

    public static int countEl(String inputstr) {
        int count = 0;
        for (int i = 0; i < inputstr.length(); i++) {
            // char c = inputstr.charAt(i);
            if (inputstr.charAt(i) == ':') {
                count++;
            }
        }
        return count;
    }

}