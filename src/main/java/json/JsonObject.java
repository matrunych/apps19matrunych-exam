package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> arr;

    public JsonObject(JsonPair... jsonPairs) {
        this.arr = new ArrayList<>();
        for (JsonPair pair : jsonPairs){
            this.arr.add(pair);
        }
    }

    public void add(JsonPair jsonPair) {
        this.arr.add(jsonPair);
    }

    @Override
    public String toJson() {
        String res = "{";
        JsonPair pair;
        for (int i = 0; i < this.arr.size(); i++){
            pair = this.arr.get(i);

            res += "'" + pair.key + "': '" + pair.value;

            if (i != this.arr.size() - 1) {
                res += ", ";
            }
        }
        return res + "}";
    }

//    public boolean contains(String name){
//
//        return null;
//    }

    public Json find(String name) {
        for (int i = 0; i < this.arr.size(); i++){
            if (this.arr.get(i).key.equals(name)){
                return this.arr.get(i).value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject proj = new JsonObject();
        for (String name : names) {
            Json val = find(name);
            if (val != null) {
                proj.add(new JsonPair(name, val));
            }
        }
        return proj;
    }
}
