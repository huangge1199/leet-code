import cn.hutool.core.io.file.FileWriter;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String result = HttpRequest.post("https://ke.gupaoedu.cn/api/v2/curriculum/outline?curriculumId=288")
                .timeout(20000)
                .execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(result);
        JSONObject chapterList = jsonObject.getJSONObject("data");
        FileWriter writer = new FileWriter("test.txt");
        writer.write("test");

        System.out.println("--------");
    }
}
