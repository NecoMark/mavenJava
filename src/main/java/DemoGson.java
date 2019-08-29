import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.*;
import com.alibaba.fastjson.JSON;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import com.google.gson.*;
public class DemoGson {
    static String s = "qwe";
    public static void main(String[] args) {

//        String jsonStr = "{\"firstPacket\":1560752205715,\"srcPort\":7625,\"dstPort\":80,\"tcpflags\":{\"abdRst\": 0},\"timestamp\":1560752211830,\"srcIp\":\"10.29.0.2\",\"dstIp\":\"10.31.37.4\",\"firstConnectCountPackets\":0,\"http\": {\"uri\":[\"kxoa.sipedu.org\\/wzbf\\/xy2018\\/attachment.php?s=861d5ee26e9e489561384dd5003c7f9c&id=286245&u=294&extension=doc&attach=1560750622_0.attach&filename=%E6%98%9F%E6%B4%8B%E5%AD%A6%E6%A0%A1201906%E4%B8%80%EF%BC%8812%EF%BC%89%E7%8F%AD%E9%81%93%E6%B3%95%E5%AD%A6%E7%A7%91%E8%B4%A8%E9%87%8F%E5%88%86%E6%9E%90%E8%A1%A8.doc&attachpath=2\\/9\\/4\"],\"requestHeaderField\":[\"accept\",\"referer\",\"accept-language\",\"user-agent\",\"accept-encoding\",\"host\",\"connection\",\"cookie\"],\"requestHeaderValue\":[\"*\\/*\",\"http:\\/\\/kxoa.sipedu.org\\/wzbf\\/xy2018\\/showthread.php?t=213872&pp=20\",\"zh-cn\",\"mozilla\\/4.0 (compatible; msie 8.0; windows nt 6.1; wow64; trident\\/4.0; slcc2; .net clr 2.0.50727; .net clr 3.5.30729; .net clr 3.0.30729; media center pc 6.0; .net4.0c; .net4.0e; infopath.3)\",\"gzip, deflate\",\"kxoa.sipedu.org\",\"keep-alive\",\"userid=463; password=28d883545e01bb10dbca84336a90afaa; sessionid=861d5ee26e9e489561384dd5003c7f9c; threadread=a%3a1%3a%7bi%3a213872%3bi%3a1560752253%3b%7d; mxeditor=wysiwyg\"],\"responseHeaderField\":[\"connection\",\"date\",\"server\",\"x-powered-by\",\"x-powered-by\",\"set-cookie\",\"content-type\",\"cache-control\",\"expires\",\"content-disposition\",\"content-transfer-encoding\",\"content-length\"],\"responseHeaderValue\":[\"close\",\"mon, 17 jun 2019 06:17:39 gmt\",\"microsoft-iis\\/6.0\",\"asp.net\",\"php\\/4.3.1\",\"sessionid=861d5ee26e9e489561384dd5003c7f9c; path=\\/\",\"application\\/msword\",\"max-age=31536000\",\"tue, 16 jun 2020 06:17:39 gmt\"," +
//                "\"attachment; filename=\\\"\xD0\xC7\xD1\xF3ѧУ201906һ\xA3\xA812\xA3\xA9\xB0\xE0\xB5\xC0\xB7\xA8ѧ\xBF\xC6\xD6\xCA\xC1\xBF\xB7\xD6\xCE\xF6\xB1\xED.doc\\\"\",\"binary\",\"74240\"],\"method\":[\"GET\"],\"statuscode\":[200]},\"protocol\":[\"http\",\"tcp\"]}";
        JsonElement element = new JsonParser().parse("");
        JsonObject jsonObject = element.getAsJsonObject();

        StuUnion stuUnion = new StuUnion();
        stuUnion.setStu(new Stu("tom",10));
        stuUnion.setId(1);

        Map<String, Object> hashMap = new HashMap<String, Object>();
        /*
        Map<String,Object> map= null;
        try {
            map = new HashMap<String, Object>();
            BeanInfo beanInfo = Introspector.getBeanInfo(stuUnion.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (key.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method getter = property.getReadMethod();
                Object value = getter!=null ? getter.invoke(stuUnion) : null;
                map.put(key, value);
            }
            System.out.println(map);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        */


        try {
            Field[] fs = stuUnion.getClass().getDeclaredFields();
            for (Field f: fs){

                if("stu".equalsIgnoreCase(f.getName())){
                    Field[] stuField = f.get(stuUnion).getClass().getDeclaredFields();
                    HashMap map = new HashMap();
                    for(Field sf: stuField){
                        map.put(sf.getName(), sf.get(f.get(stuUnion)));
                    }
                    hashMap.put("stu", map);
                    continue;
                }
                hashMap.put(f.getName(), f.get(stuUnion));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(hashMap);
        String str = JSON.toJSONString(stuUnion);
//        System.out.println(str);
//        System.out.println(JSON.parseObject(str, Map.class));

        String jsonStr = "{ruleInfo: {\"name\":\"恶意软件导致HTTP请求包含不正常的关键词\",\"id\":1000016,\"version\":1}}";
        Map amap = JSON.parseObject(jsonStr, Map.class);

        Long st = 1089L;
        System.out.println((double)st/100);

//        HashMap<String, Object> hm = new HashMap<>();
//        hm.put("a", new ArrayList<>());
//        hm.put("b", "v");
//        System.out.println(hm);

        List<Long> list = new ArrayList<Long>();
        list.add(9L);
        list.add(3L);
        list.add(4L);
        list.add(5L);
        list.add(6L);

        Iterator<Long> it = list.iterator();
        while(it.hasNext()){
            Long temp = it.next();
            if(temp < 5){
                it.remove();
            }
        }
        System.out.println(list);

        Map maplat = new HashMap();

        List<Map<Object, Object>> listMap = new ArrayList<>();
        Map<Object ,Object> map = new HashMap<>();

        maplat.put("str", 1);

        map.put("str", maplat.get("str"));
        listMap.add(map);
        map.put("str2", 2);
        map.put("str3", listMap);

        maplat.put("key", listMap);
        System.out.println(maplat.get("index"));
        String a = "fdsfs";
        System.out.println(String.format("fsdf %s", a));

//        JsonElement element = new JsonParser().parse()

        if(!test()){
            System.out.println("342424");
        };

        String ster = "11111fdssfs@sdfs.com";

        System.out.println(ster.split("@")[0]);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date()));
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setFlag(true);
        emailEntity.setId(1);
        emailEntity.setName("tom");

        String jsonStr3 = JSON.toJSONString(emailEntity);

        EmailEntity em = JSON.parseObject(jsonStr3, EmailEntity.class);


        if (em.isFlag()){

            System.out.println(JSON.parseObject(jsonStr3, EmailEntity.class).toString());
        }

        List<String> arrlist = new ArrayList<>();
        arrlist.add("aaaa");
        arrlist.add("bbbb");

//        System.out.println(arrlist.toString());
        String sstr = JSON.toJSONString(arrlist);

        System.out.println(sstr);
        List<String> llr = JSONObject.parseArray(sstr, String.class);

        System.out.println(llr.toString());

        DecimalFormat dft = new DecimalFormat("#0.0000");
        long cpu = 5;
        System.out.println(Double.valueOf(dft.format(((double)cpu/100))));

        System.out.println(Objects.equals("", null));

        Map<String, String> hmap = new HashMap<>();
        hmap.put("a", "aa");
        hmap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("23d");
        List<String> unmodList = Collections.unmodifiableList(linkedList);
//        unmodList.add("dd");
        System.out.println(unmodList.toString());
        linkedList.add("33d");
        System.out.println(unmodList.toString());

        Child[] childs = {new Child("a")};
        Parent[] parents = childs;
        parents[0] = new Parent("b");
        childs[0].run();

    }
    public static boolean test(){
        List list = null;
        try{
            list.add(1);
            System.out.println();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            System.out.println("fdsfsfsfsfssfsfsfs");
        }

    }

}


class StuUnion{
    Stu stu;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StuUnion() {
    }

    public StuUnion(Stu stu, int id) {
        this.stu = stu;
        this.id = id;
    }

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

}


class Stu {
    String name;
    int age;

    public Stu() {
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class EmailEntity{
    private String name;
    private int id;
    private boolean flag;

    public EmailEntity() {
    }

    public EmailEntity(String name, int id, boolean flag) {
        this.name = name;
        this.id = id;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "EmailEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", flag=" + flag +
                '}';
    }
}

class CodeStandard{

    public void test(String ...args){
        int sum = 0;
        int[] temp = {1, 2, 3};
        // 求和
        for (int i: temp){
            sum += i;
        }
        System.out.println(sum);


        EmailEntity emailEntity = new EmailEntity();

        if (emailEntity.getName().equals("")){
            // 避免使用这种调用equlas的方式，可能会引发空指针异常。
        }

        if ("".equals(emailEntity.getName())){

        }

        if (Objects.equals("", emailEntity.getName())){

        }

    }

    public void test2(){
        StringBuffer sb = new StringBuffer();
        // 需要在括号处换行
        sb.append("a").append("b").append(
            "c");

        // 函数参数传递多个参数需要换行
        test("a", "b",
            "c");

    }
}

class Parent{
    private String name;

    public Parent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Child extends Parent{
    public Child(String name) {
        super(name);
    }
    public void run(){
        System.out.println("run");

//        try {
//            try {
//
//            }finally {
//
//            }
//        } catch () {
//
//        }
    }
}
