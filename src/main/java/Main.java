import cn.hutool.core.io.file.FileWriter;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String result = HttpRequest.post("https://ke.gupaoedu.cn/api/v2/curriculum/outline?curriculumId=288")
                .timeout(20000)
                .execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(result);
        JSONArray chapterList = jsonObject.getJSONObject("data").getJSONArray("outlineVOList");
        FileWriter writer = new FileWriter("D:\\project\\leet-code\\src\\main\\java\\test.txt");
        for (int i = 0; i < chapterList.size(); i++) {
            JSONObject chaps = chapterList.getJSONObject(i);
            writer.append("第" + (i + 1) + "章：" + chaps.getStr("title") + "\r\n");
            JSONArray chapters = chaps.getJSONArray("chapterList");
            if (chapters == null) {
                continue;
            }
            for (int j = 0; j < chapters.size(); j++) {
                JSONObject sections = chapters.getJSONObject(j);
                writer.append("\t第" + (i + 1) + "-" + (j + 1) + "节：" + sections.getStr("title") + "\r\n");
                JSONArray sets = sections.getJSONArray("sectionDetailList");
                if (sets == null) {
                    continue;
                }
                for (int k = 0; k < sets.size(); k++) {
                    writer.append("\t\t"
                            + (k + 1) + "."
                            + sets.getJSONObject(k).getStr("title")
                            + "\t"
                            + getDurats(sets.getJSONObject(k).getInt("duration"))
                            + "\r\n");
                }
            }
        }
    }

    private static String getDurats(Integer time) {
        String str = "";
        if (time == null) {
            return str;
        }
        if (time > 60) {
            str = time % 60 + "秒";
            time /= 60;
            if (time > 60) {
                str = time % 60 + "分" + str;
                time /= 60;
                str = time + "时" + str;
            } else {
                str = time % 60 + "分" + str;
            }
        } else {
            str = time % 60 + "秒";
        }
        return str;
    }
}
