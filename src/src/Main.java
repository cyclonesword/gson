import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Domenico on 17/04/2016.
 */
public class Main {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(Person.class,  new PersonDeserializer())
                .registerTypeAdapter(MyCollection.class,  new MyCollectionDeserializer())
                .create();

        String json1 = "{\"id\":3,\"first_name\":\"Mario\",\"second_name\":\"Mario pollo22111112\",\"address\":\"\",\"city\":\"\",\"email\":\"blabla@bla.com\",\"password\":\"abcqq\",\"registration_date\":\"2016-04-14 22:10:45\",\"location\":\"here\"}";

        Account account = gson.fromJson(json1, Account.class);
        System.out.println("First deserialization: " + account.getFirst_name() + " " + account.getSecond_name() + "\n");
        System.out.println("First serialization: " + gson.toJson(account));

        System.out.println(
                "Array to json: " + gson.toJson(new int[]{1, 5}));

        int[] arrint = gson.fromJson("[1, 5]", int[].class);

        System.out.print("json to Array: [");

        for(int i : arrint) {
            System.out.print(i+ " ");
        }
//ciaociao
        System.out.print("]");


        String json2 = "{ \"first_name\":\"Mario\",\"second_name\":\"Mario pollo22111112\",\"address\":\"Via polli 2\",\"postal_code\":\"90141\",\"city\":\"Palermo\",\"state\":\"Italy\" } ";

        String json3 = "["+ json2 + "," + json2 + "]";

        Person p = gson.fromJson(json2, Person.class);
        System.out.println(p.toString());

        System.out.println("\n"+gson.toJson(p));



        MyCollection mc = gson.fromJson(json3, MyCollection.class);

        //System.out.println(mc.toString());



    }

    public static class MyCollection extends ArrayList<Object> {

    }

    public static class MyCollectionDeserializer implements JsonDeserializer<MyCollection> {

        @Override
        public MyCollection deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            JsonArray ja = json.getAsJsonArray();
            MyCollection mc = new MyCollection();

            for(JsonElement je : ja) {
                JsonObject jo = je.getAsJsonObject();

                String fname = jo.get("first_name").toString();
                String sname = jo.get("second_name").toString();

                String street = jo.get("address").toString();
                String city = jo.get("city").toString();
                String pcode = jo.get("postal_code").toString();
                String state = jo.get("state").toString();

                Address address = new Address(street, city, pcode, state);

                mc.add(new Person(fname , sname, address));
            }

            return mc;

        }
    }

    public static class PersonDeserializer implements JsonDeserializer<Person> {

        @Override
        public Person deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


            System.out.println(new StringBuilder().append("\n\n").append(json.toString()).append("TypeofT: ").append(typeOfT.toString()).append("\n").toString());
           // JsonParser pa = new JsonParser();

            JsonObject jo = json.getAsJsonObject();
            String fname = jo.get("first_name").toString();
            String sname = jo.get("second_name").toString();

            String street = jo.get("address").toString();
            String city = jo.get("city").toString();
            String pcode = jo.get("postal_code").toString();
            String state = jo.get("state").toString();

            Address address = new Address(street, city, pcode, state);

           /* JsonArray ja = json.getAsJsonArray();
            String fname = ja.get(0).toString();
            String sname = ja.get(1).toString();
*/
            return new Person(fname , sname, address);

        }
    }


}
